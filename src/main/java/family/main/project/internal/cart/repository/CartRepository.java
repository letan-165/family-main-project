package family.main.project.internal.cart.repository;

import family.main.project.internal.cart.entity.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<UserCart, Long> {
    Optional<UserCart> findByUserId(String userId);
}
