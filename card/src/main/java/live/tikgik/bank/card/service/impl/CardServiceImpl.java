package live.tikgik.bank.card.service.impl;

import live.tikgik.bank.card.dto.request.CardRequestDto;
import live.tikgik.bank.card.dto.response.CardResponseDto;
import live.tikgik.bank.card.entityy.Card;
import live.tikgik.bank.card.exception.ResourceNotFoundException;
import live.tikgik.bank.card.mapper.CardMapper;
import live.tikgik.bank.card.repository.CardRepository;
import live.tikgik.bank.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class CardServiceImpl implements CardService {
    private final CardMapper cardMapper;
    private final CardRepository cardRepository;
    @Override
    @Transactional
    public CardResponseDto createCard(CardRequestDto accountRequestDto) {
        Card card = cardMapper.fromDto(accountRequestDto);
        card.setCardNumber("12312351");
        card.setCardType("debit");
        card.setAvailableAmount(1003202303);
        card.setAmountUsed(12312);
        card.setTotalLimit(1003202304);
        return cardMapper.toDto(cardRepository.save(card));
    }

    @Override
    @Transactional
    public String deleteCard(String accountId) {
        Card card = cardRepository.findByMobileNumber(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "accountId", accountId));
        cardRepository.delete(card);
        return "deleted successfully";
    }

    @Override
    public CardResponseDto getCard(String accountId) {
        Card card = cardRepository.findByMobileNumber(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "accountId", accountId));
        return cardMapper.toDto(card);
    }

    @Override
    public List<CardResponseDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(cardMapper::toDto)
                .toList();
    }


    @Override
    @Transactional

    public CardResponseDto updateCard(String accountId, CardRequestDto accountRequestDto) {
        Card card = cardRepository.findByMobileNumber(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "accountId", accountId));
        cardMapper.updateCard(card, accountRequestDto);
        return cardMapper.toDto(cardRepository.save(card));
    }
}
