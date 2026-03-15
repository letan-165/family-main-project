package family.main.project.internal.order.service;

import family.main.project.internal.order.dto.request.AddItemOrderRequest;
import family.main.project.internal.order.entity.Item;
import family.main.project.internal.order.entity.ItemOrder;
import family.main.project.internal.order.repository.ItemOrderRepository;
import family.main.project.internal.order.repository.ItemRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ItemOrderService {

    ItemOrderRepository itemOrderRepository;
    ItemRepository itemRepository;

    public List<ItemOrder> getByOrder(Long orderId) {
        return itemOrderRepository.findByOrderId(orderId);
    }


    public ItemOrder addItem(AddItemOrderRequest request) {

        Item item = itemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        ItemOrder itemOrder = ItemOrder.builder()
                .id(UUID.randomUUID().toString())
                .orderId(request.getOrderId())
                .itemId(request.getItemId())
                .quantity(request.getQuantity())
                .total(item.getPrice() * request.getQuantity())
                .build();

        return itemOrderRepository.save(itemOrder);
    }

    public ItemOrder updateQuantity(String id, Integer quantity) {

        ItemOrder itemOrder = itemOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemOrder not found"));

        itemOrder.setQuantity(quantity);

        return itemOrderRepository.save(itemOrder);
    }

    public void delete(String id) {
        itemOrderRepository.deleteById(id);
    }
}