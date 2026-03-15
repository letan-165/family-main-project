package family.main.project.internal.order.service;

import family.main.project.common.enums.OrderStatus;
import family.main.project.internal.order.dto.request.CreateOrderRequest;
import family.main.project.internal.order.dto.request.OrderItemRequest;
import family.main.project.internal.order.entity.*;
import family.main.project.internal.order.repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;
    ItemRepository itemRepository;
    ItemOrderRepository itemOrderRepository;
    UserOrderRepository userOrderRepository;

    @Transactional
    public Long createOrder(CreateOrderRequest request) {
        Order order = Order.builder()
                .status(OrderStatus.PENDING)
                .note(request.getNote())
                .timeBooking(new Date())
                .total(0)
                .build();

        order = orderRepository.save(order);

        int total = 0;

        for (OrderItemRequest itemReq : request.getItems()) {
            Item item = itemRepository.findById(itemReq.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            int price = item.getPrice() * itemReq.getQuantity();

            ItemOrder itemOrder = ItemOrder.builder()
                    .id(UUID.randomUUID().toString())
                    .orderId(order.getId())
                    .itemId(itemReq.getItemId())
                    .quantity(itemReq.getQuantity())
                    .total(price)
                    .build();

            itemOrderRepository.save(itemOrder);

            total += price;
        }

        order.setTotal(total);
        orderRepository.save(order);

        UserOrder userOrder = UserOrder.builder()
                .id(UUID.randomUUID().toString())
                .userId(request.getUserId())
                .orderId(order.getId().toString())
                .receiverName(request.getReceiverName())
                .phone(request.getPhone())
                .address(request.getAddress())
                .build();

        userOrderRepository.save(userOrder);

        return order.getId();
    }
}