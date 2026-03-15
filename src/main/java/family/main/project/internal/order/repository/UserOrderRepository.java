package family.main.project.internal.order.repository;

import family.main.project.internal.order.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, String> {
}
