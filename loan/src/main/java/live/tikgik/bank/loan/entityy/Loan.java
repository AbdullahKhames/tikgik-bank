package live.tikgik.bank.loan.entityy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long loanNumber;
    private Long customerId;
    private Double loanAmount;
    private Double interestRate;
    private Double paidAmount;
}
