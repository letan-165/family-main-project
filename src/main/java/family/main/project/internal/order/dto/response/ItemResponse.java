package family.main.project.internal.order.dto.response;

import lombok.Data;

@Data
public class ItemResponse {
    Long itemId;
    Integer quantity;
    Integer total;
}
