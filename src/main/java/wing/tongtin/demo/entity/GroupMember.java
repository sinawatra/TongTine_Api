package wing.tongtin.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private TontineGroupEntity group;

    private Integer payoutOrder;

    private String imageUrl;
}