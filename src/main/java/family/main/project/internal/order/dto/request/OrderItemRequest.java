package family.main.project.internal.order.dto.request;


import lombok.Data;

@Data
public class OrderItemRequest {
    Long itemId;
    Integer quantity;
}