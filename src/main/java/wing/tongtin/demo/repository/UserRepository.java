package wing.tongtin.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wing.tongtin.demo.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByPhone(String phone);

}