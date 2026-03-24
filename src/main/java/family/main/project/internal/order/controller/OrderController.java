package family.main.project.internal.order.controller;

import family.main.project.common.model.response.ApiResponse;
import family.main.project.internal.cart.dto.request.CreateCartRequest;
import family.main.project.internal.order.dto.request.OrderCreateFromCartRequest;
import family.main.project.internal.order.dto.request.OrderCreateRequest;
import family.main.project.internal.order.dto.request.OrderUpdateStatusRequest;
import family.main.project.internal.order.dto.response.OrderDetailResponse;
import family.main.project.internal.order.dto.response.OrderUpdateStatusResponse;
import family.main.project.internal.order.entity.UserOrder;
import family.main.project.internal.order.service.OrderService;
import family.main.project.internal.user.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;

    @PostMapping("/public")
    ApiResponse<UserOrder> createOrder(@RequestBody OrderCreateRequest request){
        String userId = AuthService.getUserIdFromToken();

        return ApiResponse.<UserOrder>builder()
                .message("create order")
                .result(orderService.createFromIndex(userId ,request))
                .build();
    }

    @PostMapping("/public/{cartId}/cart")
    ApiResponse<UserOrder> createOrderFromCart(@PathVariable Long cartId,@RequestBody OrderCreateFromCartRequest request){
        return ApiResponse.<UserOrder>builder()
                .message("create order from cart")
                .result(orderService.createFromCart(cartId ,request))
                .build();
    }

    @PutMapping("/public/{id}/status")
    ApiResponse<OrderUpdateStatusResponse> updateStatus(@PathVariable Long id, @RequestBody OrderUpdateStatusRequest request){
        return ApiResponse.<OrderUpdateStatusResponse>builder()
                .message("update status order")
                .result(orderService.updateStatus(id,request.getStatus()))
                .build();
    }

    @GetMapping("/public/{id}/detail")
    ApiResponse<OrderDetailResponse> updateStatus(@PathVariable Long id){
        return ApiResponse.<OrderDetailResponse>builder()
                .message("get detail order")
                .result(orderService.getDetail(id))
                .build();
    }
}