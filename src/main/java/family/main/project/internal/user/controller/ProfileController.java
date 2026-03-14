package family.main.project.internal.user.controller;

import family.main.project.common.model.response.ApiResponse;
import family.main.project.internal.user.dto.request.UpdateProfileRequest;
import family.main.project.internal.user.dto.response.ProfileResponse;
import family.main.project.internal.user.service.ProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ProfileController {
    ProfileService profileService;

    @PutMapping("/public/{userId}")
    ApiResponse<ProfileResponse> updateProfile(@PathVariable String userId, UpdateProfileRequest request){
        return ApiResponse.<ProfileResponse>builder()
                .message("update profile: " + userId)
                .result(profileService.updateProfile(userId,request))
                .build();
    }

}
