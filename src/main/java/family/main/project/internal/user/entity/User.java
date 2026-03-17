package family.main.project.internal.user.entity;

import family.main.project.common.enums.UserLoginType;
import family.main.project.common.enums.UserRole;
import family.main.project.common.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "users")
@Builder
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

    @Enumerated(EnumType.STRING)
    UserLoginType loginType;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @Enumerated(EnumType.STRING)
    UserRole role;
}
