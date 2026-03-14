package family.main.project.internal.user.mapper;

import family.main.project.internal.user.dto.request.UpdateProfileRequest;
import family.main.project.internal.user.dto.response.ProfileResponse;
import family.main.project.internal.user.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {
    ProfileResponse toProfileResponse(Profile profile);
    void updateToProfile(@MappingTarget Profile profile, UpdateProfileRequest request);
}
