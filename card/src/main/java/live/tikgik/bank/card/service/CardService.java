package live.tikgik.bank.card.service;

import live.tikgik.bank.card.dto.request.CardRequestDto;
import live.tikgik.bank.card.dto.response.CardResponseDto;

import java.util.List;

public interface CardService {
    CardResponseDto createCard(CardRequestDto accountRequestDto);

    String deleteCard(String accountId);

    CardResponseDto getCard(String accountId);

    List<CardResponseDto> getAllCards();

    CardResponseDto updateCard(String accountId, CardRequestDto accountRequestDto);
}
