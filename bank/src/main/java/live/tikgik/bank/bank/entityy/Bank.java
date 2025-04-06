package live.tikgik.bank.bank.entityy;

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
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bankNumber;
    private Long customerId;
    private Double bankAmount;
}
