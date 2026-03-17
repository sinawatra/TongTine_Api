package wing.tongtin.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import wing.tongtin.demo.enumeration.KycDocumentType;
import wing.tongtin.demo.enumeration.KycStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "kyc_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String file;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KycDocumentType type;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private KycStatus status = KycStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String reviewedBy;

    private String rejectionReason;

    private LocalDateTime createdAt;

    private LocalDateTime reviewedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}