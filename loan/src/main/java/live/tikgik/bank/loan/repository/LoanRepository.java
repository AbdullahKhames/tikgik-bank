package live.tikgik.bank.loan.repository;

import live.tikgik.bank.loan.entityy.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}