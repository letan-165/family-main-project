package family.main.project.internal.order.dto.response;

import family.main.project.internal.order.entity.ItemOrder;
import family.main.project.internal.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    String receiverName;
    String phone;
    String address;
    Order order;
    List<ItemResponse> items;
}
