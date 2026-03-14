package family.main.project.internal;


import family.main.project.common.model.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    @GetMapping("/ping")
    ApiResponse<Boolean> ping(){
        return ApiResponse.<Boolean>builder()
                .message("pong")
                .result(true)
                .build();
    }
}
