package wing.tongtin.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wing.tongtin.demo.entity.UserEntity;
import wing.tongtin.demo.repository.UserRepository;
import wing.tongtin.demo.request.LoginRequest;
import wing.tongtin.demo.response.JwtResponse;
import wing.tongtin.demo.util.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;
    private  final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;

    public JwtResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByPhone(request.getPhone()).orElseThrow(()-> new RuntimeException("User not found"));


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtils.generateJwtToken(user.getId());
        return new JwtResponse(token, "Bearer");
    }
}
