package family.main.project.internal.item.mapper;

import family.main.project.common.model.response.ItemObjResponse;
import family.main.project.internal.item.dto.request.ItemSaveRequest;
import family.main.project.internal.item.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {
    Item toItem(ItemSaveRequest request);

    @Mapping(source = "id", target = "itemId")
    ItemObjResponse toItemResponse(Item item);

    void updateRequestToItem(ItemSaveRequest request,@MappingTarget Item item);
}