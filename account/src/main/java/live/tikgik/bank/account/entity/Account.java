package live.tikgik.bank.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Account extends BaseEntity {
    private Long customerId;
    private String mobileNumber;
    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
