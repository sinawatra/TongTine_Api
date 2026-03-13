package wing.tongtin.demo.repository;


import wing.tongtin.demo.entity.TontineGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TontineGroupRepository extends JpaRepository<TontineGroupEntity, String> {
}