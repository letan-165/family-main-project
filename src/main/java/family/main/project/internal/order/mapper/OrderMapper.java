package family.main.project.internal.order.mapper;

import family.main.project.common.model.response.ItemObjResponse;
import family.main.project.internal.cart.entity.CartItem;
import family.main.project.internal.order.dto.request.OrderCreateFromCartRequest;
import family.main.project.internal.order.dto.request.OrderCreateRequest;
import family.main.project.internal.order.dto.request.OrderItemRequest;
import family.main.project.internal.order.dto.request.OrderUpdateInfoRequest;
import family.main.project.internal.order.dto.response.OrderUpdateInfoResponse;
import family.main.project.internal.order.entity.OrderItem;
import family.main.project.internal.order.entity.UserOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
    OrderUpdateInfoResponse toOrderUpdateInfoResponse(UserOrder userOrder);

    OrderCreateRequest toOrderCreateRequest(OrderCreateFromCartRequest request);

    OrderItemRequest toOrderItemRequest(CartItem cartItem);

    void updateRequestToOrder(OrderUpdateInfoRequest request, @MappingTarget UserOrder userOrder);

    @Mapping(source = "orderId", target = "objId")
    void updateOrderItemToItemObjResponse(OrderItem item, @MappingTarget ItemObjResponse response);
}