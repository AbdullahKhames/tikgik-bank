package live.tikgik.bank.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedBy
    @Column(updatable = false)
    protected String createdBy;
    @LastModifiedBy
    @Column(insertable = false)
    protected String updatedBy;
    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    protected LocalDateTime updatedDate;
}
