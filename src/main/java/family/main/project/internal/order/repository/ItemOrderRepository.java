package family.main.project.internal.order.repository;

import family.main.project.internal.order.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemOrderRepository extends JpaRepository<ItemOrder, String> {
    List<ItemOrder> findByOrderId(Long orderId);
}