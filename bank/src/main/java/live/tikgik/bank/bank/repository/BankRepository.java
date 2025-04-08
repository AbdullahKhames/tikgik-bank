package live.tikgik.bank.bank.repository;

import live.tikgik.bank.bank.entityy.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<Bank> findByMobileNumber(String mobileNumber);
}