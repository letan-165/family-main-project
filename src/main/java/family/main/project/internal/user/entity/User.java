package family.main.project.internal.user.entity;

import family.main.project.common.enums.UserTypeLogin;
import family.main.project.common.enums.UserRole;
import family.main.project.common.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
    String password;
    String email;

    @Column(name = "type_login")
    @Enumerated(EnumType.STRING)
    UserTypeLogin typeLogin;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @Enumerated(EnumType.STRING)
    UserRole role;
}
