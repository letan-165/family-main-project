package family.main.project.internal.user.mapper;

import family.main.project.internal.user.dto.request.ProfileUpdateRequest;
import family.main.project.internal.user.dto.request.UserSignUpRequest;
import family.main.project.internal.user.dto.response.ProfileResponse;
import family.main.project.internal.user.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {
    UserProfile toUserProfile(UserSignUpRequest request);
    ProfileResponse toProfileResponse(UserProfile profile);
    void updateToProfile(@MappingTarget UserProfile profile, ProfileUpdateRequest request);
}
