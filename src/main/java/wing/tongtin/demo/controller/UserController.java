package wing.tongtin.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wing.tongtin.demo.entity.UserEntity;
import wing.tongtin.demo.response.ApiResponse;
import wing.tongtin.demo.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ApiResponse<?> getUserInfo(@PathVariable String id) {
        UserEntity user = userService.getUserInfoById(id);
        return ApiResponse.builder()
                .success(true)
                .message("User found")
                .data(user)
                .build();
    }
}