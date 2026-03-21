package family.main.project.internal.order.mapper;

import family.main.project.internal.order.dto.request.ItemSaveRequest;
import family.main.project.internal.order.dto.response.ItemResponse;
import family.main.project.internal.order.entity.Item;
import family.main.project.internal.order.entity.ItemOrder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {
    Item toItem(ItemSaveRequest request);
    ItemResponse toItemResponse(ItemOrder itemOrder);

    void updateItemFromRequest(@MappingTarget Item item, ItemSaveRequest request);
}