package family.main.project.internal.cart.mapper;


import family.main.project.internal.cart.dto.request.CreateCartRequest;
import family.main.project.internal.cart.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartItem toOCartItem(CreateCartRequest request);

}
