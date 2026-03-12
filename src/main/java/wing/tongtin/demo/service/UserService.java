package wing.tongtin.demo.service;

import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import wing.tongtin.demo.entity.UserEntity;
import wing.tongtin.demo.repository.UserRepository;
import wing.tongtin.demo.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserEntity register(RegisterRequest request) {
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        UserEntity user = UserEntity.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .password(hashedPassword)
                .kycVerified(false)
                .build();

        return userRepository.save(user);
    }

}