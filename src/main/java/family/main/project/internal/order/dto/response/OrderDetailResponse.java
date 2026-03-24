package family.main.project.internal.order.dto.response;

import family.main.project.common.model.response.ItemObjResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailResponse extends OrderResponse {
    List<ItemObjResponse> items;
}
