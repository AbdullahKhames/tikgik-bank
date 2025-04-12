package live.tikgik.bank.bank.controller;

import live.tikgik.bank.bank.aop.ToLog;
import live.tikgik.bank.bank.config.BanksContactInfoDto;
import live.tikgik.bank.bank.dto.request.BankRequestDto;
import live.tikgik.bank.bank.dto.response.BankResponseDto;
import live.tikgik.bank.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/banks")
public class BankController {
    private final BankService bankService;
    private final BanksContactInfoDto accountsContactInfoDto;
    @Value("${build.version}")
    private String buildVersion;
    @PostMapping
    @ToLog
    public ResponseEntity<BankResponseDto> create(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @RequestBody BankRequestDto bankRequestDto) {
        return ResponseEntity.ok(bankService.createBank(bankRequestDto));
    }
    @ToLog
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable String id) {
        return ResponseEntity.ok(bankService.deleteBank(id));
    }
    @ToLog
    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDto> get(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable String id) {
        return ResponseEntity.ok(bankService.getBank(id));
    }
    @ToLog
    @GetMapping
    public ResponseEntity<List<BankResponseDto>> getAll(
            @RequestHeader("tikGik-correlation-id") String correlationId
            ) {
        return ResponseEntity.ok(bankService.getAllBanks());
    }
    @ToLog
    @PutMapping("/{id}")
    public ResponseEntity<BankResponseDto> update(
            @RequestHeader("tikGik-correlation-id") String correlationId,
            @PathVariable String id, @RequestBody BankRequestDto bankRequestDto) {
        return ResponseEntity.ok(bankService.updateBank(id, bankRequestDto));
    }
    @ToLog
    @GetMapping("/build-version")
    public String test(
            @RequestHeader("tikGik-correlation-id") String correlationId
            ) {
        return buildVersion;
    }
    @ToLog
    @GetMapping("/contact")
    public BanksContactInfoDto contact(
            @RequestHeader("tikGik-correlation-id") String correlationId
            ) {
        return accountsContactInfoDto;
    }

}
