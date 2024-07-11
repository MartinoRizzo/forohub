package controller;

package com.example.ForoHub.controller;

import com.example.ForoHub.model.Topic;
import com.example.ForoHub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable(value = "id") Long id) {
        Topic topic = topicService.findTopicById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        return ResponseEntity.ok().body(topic);
    }

    @PostMapping
    public Topic createTopic(@Validated @RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable(value = "id") Long id, @Validated @RequestBody Topic topicDetails) {
        Topic updatedTopic = topicService.updateTopic(id, topicDetails);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable(value = "id") Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}

