package model;

@Entity
@Data // Si usas Lombok
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // Otros campos relevantes como roles, emails, etc.
}
