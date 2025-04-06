package live.tikgik.bank.bank.repository;

import live.tikgik.bank.bank.entityy.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}