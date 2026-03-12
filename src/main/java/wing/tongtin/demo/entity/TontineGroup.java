package wing.tongtin.demo.entity;


import com.etontine.enumeration.GroupStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TontineGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String groupName;

    private BigDecimal contributionAmount;

    private Integer totalMembers;

    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    private GroupStatus status;

}