package family.main.project.common.model.response;

import family.main.project.common.enums.ItemType;
import lombok.Data;

@Data
public class ItemResponse {
    Long id;
    Long objId;
    String name;
    ItemType type;
    Integer price;
    String picture;
    String description;
    Integer quantity;
}
