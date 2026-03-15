package family.main.project.internal.order.dto.request;

import lombok.Data;

@Data
public class AddItemOrderRequest {
    Long orderId;
    Long itemId;
    Integer quantity;
}