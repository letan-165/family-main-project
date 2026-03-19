package family.main.project.internal.order.dto.response;

import family.main.project.internal.order.entity.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    String receiverName;
    String phone;
    String address;
    Order order;
}
