package family.main.project.internal.order.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllMyResponse {
    String userId;
    List<OrderResponse> orderResponses;
}
