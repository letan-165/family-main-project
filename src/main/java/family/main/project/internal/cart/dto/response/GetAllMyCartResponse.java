package family.main.project.internal.cart.dto.response;

import family.main.project.common.model.response.ItemObjResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllMyCartResponse {
    Long cartId;
    List<ItemObjResponse> items;
}
