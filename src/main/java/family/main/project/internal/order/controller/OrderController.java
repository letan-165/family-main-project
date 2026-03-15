package family.main.project.internal.order.controller;

import family.main.project.common.model.response.ApiResponse;
import family.main.project.internal.order.dto.request.CreateOrderRequest;
import family.main.project.internal.order.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;

    @PostMapping("/public")
    ApiResponse<Long> createOrder(@RequestBody CreateOrderRequest request){
        return ApiResponse.<Long>builder()
                .message("create order")
                .result(orderService.createOrder(request))
                .build();
    }

}