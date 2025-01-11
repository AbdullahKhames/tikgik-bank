package live.tikgik.bank.account.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_seq", allocationSize = 3)
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;
    private String password;
}
