package family.main.project.internal.cart.dto.request;

import lombok.Data;

@Data
public class CreateCartRequest {
    Long cartId;
    Long itemId;
    Integer quantity;
}
