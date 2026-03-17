package wing.tongtin.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wing.tongtin.demo.entity.UserEntity;
import wing.tongtin.demo.enumeration.Role;
import wing.tongtin.demo.repository.UserRepository;
import wing.tongtin.demo.request.LoginRequest;
import wing.tongtin.demo.response.JwtResponse;
import wing.tongtin.demo.util.JwtUtils;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder passwordEncoder;

    public JwtResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByPhone(request.getPhone())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Check KYC verification status (skip for ADMIN users)
        if (user.getRole() != Role.ADMIN && (user.getKycVerified() == null || !user.getKycVerified())) {
            throw new RuntimeException("KYC verification required. Please submit your KYC documents and wait for approval.");
        }

        String token = jwtUtils.generateJwtToken(user.getId());
        return new JwtResponse(token, "Bearer");
    }
}
