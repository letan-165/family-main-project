package family.main.project.internal.user.mapper;

import family.main.project.internal.user.dto.request.UserSignUpRequest;
import family.main.project.internal.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toUser(UserSignUpRequest request);
}
