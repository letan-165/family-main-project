package family.main.project.internal.order.service;

import family.main.project.common.exception.AppException;
import family.main.project.common.exception.ErrorCode;
import family.main.project.internal.order.dto.request.OrderUpdateInfoRequest;
import family.main.project.internal.order.dto.response.GetAllMyResponse;
import family.main.project.internal.order.dto.response.ItemResponse;
import family.main.project.internal.order.dto.response.OrderResponse;
import family.main.project.internal.order.dto.response.OrderUpdateInfoResponse;
import family.main.project.internal.order.entity.ItemOrder;
import family.main.project.internal.order.entity.Order;
import family.main.project.internal.order.entity.UserOrder;
import family.main.project.internal.order.mapper.ItemMapper;
import family.main.project.internal.order.mapper.OrderMapper;
import family.main.project.internal.order.repository.ItemOrderRepository;
import family.main.project.internal.order.repository.OrderRepository;
import family.main.project.internal.order.repository.UserOrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserOrderService {

    UserOrderRepository userOrderRepository;
    OrderRepository orderRepository;
    ItemOrderRepository itemOrderRepository;

    OrderMapper orderMapper;
    ItemMapper itemMapper;


    @Cacheable(value = "user-order", key = "#userId")
    public GetAllMyResponse getAllMy(String userId, Pageable pageable) {
        List<UserOrder> userOrders = userOrderRepository.findAllByUserId(userId,pageable).getContent();

        List<Long> orderIds = userOrders.stream()
                .map(UserOrder::getOrderId)
                .toList();

        List<Order> orders = orderRepository.findAllById(orderIds);

        Map<Long, Order> orderMaps = orders.stream()
                .collect(Collectors.toMap(Order::getId, o -> o));

        List<OrderResponse> orderResponses = userOrders.stream().map(userOrder -> {

            OrderResponse orderResponse = orderMapper.toOrderResponse(userOrder);
            Long orderId = userOrder.getOrderId();

            Order order = orderMaps.get(orderId);
            if (order == null) {
                throw new AppException(ErrorCode.ORDER_NO_EXISTS);
            }
            orderResponse.setOrder(order);

            List<ItemOrder> itemOrders = itemOrderRepository.findByOrderId(orderId);
            List<ItemResponse> itemResponses = itemOrders.stream()
                    .map(itemMapper::toItemResponse)
                            .toList();

            orderResponse.setItems(itemResponses);

            return orderResponse;
        }).toList();


        return GetAllMyResponse.builder()
                .userId(userId)
                .orderResponses(orderResponses)
                .build();
    }

    @CacheEvict(value = "user-order", key = "#result.userId")
    public OrderUpdateInfoResponse updateInfo(Long orderId, OrderUpdateInfoRequest request) {
        UserOrder userOrder = userOrderRepository.findByOrderId(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NO_EXISTS));

        orderMapper.updateOrderFromRequest(userOrder, request);

        UserOrder update = userOrderRepository.save(userOrder);

        return orderMapper.toOrderUpdateInfoResponse(update);
    }

}
