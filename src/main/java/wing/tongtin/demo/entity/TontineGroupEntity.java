package wing.tongtin.demo.entity;


import wing.tongtin.demo.enumeration.GroupStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "TontineGroup")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TontineGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String groupName;

    private BigDecimal contributionAmount;

    private Integer totalMembers;

    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    private String imageUrl;

}