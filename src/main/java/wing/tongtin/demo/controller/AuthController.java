package wing.tongtin.demo.controller;

import wing.tongtin.demo.entity.UserEntity;
import wing.tongtin.demo.request.LoginRequest;
import wing.tongtin.demo.request.RegisterRequest;
import wing.tongtin.demo.response.ApiResponse;
import wing.tongtin.demo.response.JwtResponse;
import wing.tongtin.demo.response.RegisterResponse;
import wing.tongtin.demo.service.AuthService;
import wing.tongtin.demo.service.UserService;
import wing.tongtin.demo.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ApiResponse<?> register(@RequestBody RegisterRequest request) {
        UserEntity user = userService.register(request);
        String token = jwtUtils.generateJwtToken(user.getId());

        RegisterResponse response = RegisterResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .imageUrl(user.getImageUrl())
                .kycVerified(user.getKycVerified())
                .token(token)
                .tokenType("Bearer")
                .build();

        return ApiResponse.builder()
                .success(true)
                .message("User registered. Please submit KYC documents to complete verification.")
                .data(response)
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