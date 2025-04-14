package live.tikgik.bank.card.controller;

import live.tikgik.bank.card.aop.ToLog;
import live.tikgik.bank.card.config.CardsContactInfoDto;
import live.tikgik.bank.card.dto.request.CardRequestDto;
import live.tikgik.bank.card.dto.response.CardResponseDto;
import live.tikgik.bank.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CardController {
    private final CardService cardService;
    private final CardsContactInfoDto accountsContactInfoDto;
    @Value("${build.version}")
    private String buildVersion;
    @PostMapping
    @ToLog
    public ResponseEntity<CardResponseDto> create(
            
            @RequestBody CardRequestDto cardRequestDto) {
        return ResponseEntity.ok(cardService.createCard(cardRequestDto));
    }
    @DeleteMapping("/{id}")
    @ToLog
    public ResponseEntity<String> delete(
            
            @PathVariable String id) {
        return ResponseEntity.ok(cardService.deleteCard(id));
    }
    @ToLog
    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> get(
            
            @PathVariable String id) {
        return ResponseEntity.ok(cardService.getCard(id));
    }
    @ToLog
    @GetMapping
    public ResponseEntity<List<CardResponseDto>> getAll(
            
            ) {
        return ResponseEntity.ok(cardService.getAllCards());
    }
    @ToLog
    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDto> update(
            
            @PathVariable String id, @RequestBody CardRequestDto cardRequestDto) {
        return ResponseEntity.ok(cardService.updateCard(id, cardRequestDto));
    }
    @ToLog
    @GetMapping("/build-version")
    public String test(
            
            ) {
        return buildVersion;
    }
    @ToLog
    @GetMapping("/contact")
    public CardsContactInfoDto contact(
            
            ) {
        return accountsContactInfoDto;
    }
}
