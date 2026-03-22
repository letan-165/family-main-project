package family.main.project.internal.cart.dto.response;

import family.main.project.common.model.response.ItemResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllMyCartResponse {
    Long cartId;
    List<ItemResponse> items;
}
