package family.main.project.common.model.response;

import family.main.project.common.enums.ItemType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ItemObjResponse {
    Long id;
    Long itemId;
    Long objId;
    String name;
    ItemType type;
    Integer price;
    String picture;
    String description;
    Integer quantity;
}
