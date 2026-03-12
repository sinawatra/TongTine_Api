package wing.tongtin.demo.controller;

import wing.tongtin.demo.request.LoginRequest;
import wing.tongtin.demo.request.RegisterRequest;
import wing.tongtin.demo.response.ApiResponse;
import wing.tongtin.demo.response.JwtResponse;
import wing.tongtin.demo.service.AuthService;
import wing.tongtin.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody RegisterRequest request) {

        return ApiResponse.builder()
                .success(true)
                .message("User registered")
                .data(userService.register(request))
                .build();
    }


    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest request) {
        JwtResponse token = authService.login(request);
        return ApiResponse.builder()
                .success(true)
                .message("Login Success")
                .data(token).build();
    }

}