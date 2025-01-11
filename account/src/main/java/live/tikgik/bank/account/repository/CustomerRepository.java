package live.tikgik.bank.account.repository;

import jakarta.validation.constraints.NotNull;
import live.tikgik.bank.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);

    boolean existsByMobileNumber(String mobileNumber);

    Optional<Customer> findByMobileNumberAndPassword(@NotNull String mobileNumber, @NotNull String password);
}