package family.main.project.internal.order.controller;

import family.main.project.common.model.response.ApiResponse;
import family.main.project.internal.order.dto.request.AddItemOrderRequest;
import family.main.project.internal.order.entity.ItemOrder;
import family.main.project.internal.order.service.ItemOrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-orders")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ItemOrderController {
    ItemOrderService itemOrderService;

    @PostMapping("/public")
    ApiResponse<ItemOrder> addItem(@RequestBody AddItemOrderRequest request){
        return ApiResponse.<ItemOrder>builder()
                .message("add item")
                .result(itemOrderService.addItem(request))
                .build();
    }

    @GetMapping("/public/{orderId}")
    ApiResponse<List<ItemOrder>> getItems(@PathVariable Long orderId){
        return ApiResponse.<List<ItemOrder>>builder()
                .message("get items")
                .result(itemOrderService.getByOrder(orderId))
                .build();
    }

    @DeleteMapping("/public/{id}")
    ApiResponse<String> deleteItem(@PathVariable String id){
        itemOrderService.delete(id);
        return ApiResponse.<String>builder()
                .message("delete item")
                .result(id)
                .build();
    }
}