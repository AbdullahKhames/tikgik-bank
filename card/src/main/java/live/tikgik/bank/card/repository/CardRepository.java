package live.tikgik.bank.card.repository;

import live.tikgik.bank.card.entityy.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByMobileNumber(String mobileNumber);
}