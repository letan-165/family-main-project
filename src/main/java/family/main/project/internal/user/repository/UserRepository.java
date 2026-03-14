package family.main.project.internal.user.repository;

import family.main.project.internal.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String name);
    boolean existsByUsername(String name);
}
