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
        card.setInterestRate(0.1);
        card.setPaidAmount(0.0);
        return cardMapper.toDto(cardRepository.save(card));
    }

    @Override
    @Transactional

    public String deleteCard(Long accountId) {
        Card card = cardRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "accountId", accountId));
        cardRepository.delete(card);
        return "deleted successfully";
    }

    @Override
    public CardResponseDto getCard(Long accountId) {
        Card card = cardRepository.findById(accountId)
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

    public CardResponseDto updateCard(Long accountId, CardRequestDto accountRequestDto) {
        Card card = cardRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "accountId", accountId));
        cardMapper.updateCard(card, accountRequestDto);
        return cardMapper.toDto(cardRepository.save(card));
    }
}
