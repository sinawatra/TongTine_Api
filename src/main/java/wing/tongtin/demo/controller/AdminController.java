package wing.tongtin.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wing.tongtin.demo.repository.ContributionRepository;
import wing.tongtin.demo.repository.TontineGroupRepository;
import wing.tongtin.demo.repository.UserRepository;
import wing.tongtin.demo.response.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final TontineGroupRepository groupRepository;
    private final ContributionRepository contributionRepository;
    private final UserRepository userRepository;

    @GetMapping("/groups")
    public ApiResponse<?> getAllGroups() {
        return ApiResponse.builder()
                .success(true)
                .message("Success")
                .data(groupRepository.findAll())
                .build();
    }

    @GetMapping("/contributions")
    public ApiResponse<?> getAllContributions() {
        return ApiResponse.builder()
                .success(true)
                .message("Success")
                .data(contributionRepository.findAll())
                .build();
    }

    @GetMapping("/users")
    public ApiResponse<?> getAllUsers() {
        return ApiResponse.builder()
                .success(true)
                .message("Success")
                .data(userRepository.findAll())
                .build();
    }
}
