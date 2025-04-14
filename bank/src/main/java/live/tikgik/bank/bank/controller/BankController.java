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
            
            @RequestBody BankRequestDto bankRequestDto) {
        return ResponseEntity.ok(bankService.createBank(bankRequestDto));
    }
    @ToLog
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            
            @PathVariable String id) {
        return ResponseEntity.ok(bankService.deleteBank(id));
    }
    @ToLog
    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDto> get(
            
            @PathVariable String id) {
        return ResponseEntity.ok(bankService.getBank(id));
    }
    @ToLog
    @GetMapping
    public ResponseEntity<List<BankResponseDto>> getAll(
            
            ) {
        return ResponseEntity.ok(bankService.getAllBanks());
    }
    @ToLog
    @PutMapping("/{id}")
    public ResponseEntity<BankResponseDto> update(
            
            @PathVariable String id, @RequestBody BankRequestDto bankRequestDto) {
        return ResponseEntity.ok(bankService.updateBank(id, bankRequestDto));
    }
    @ToLog
    @GetMapping("/build-version")
    public String test(
            
            ) {
        return buildVersion;
    }
    @ToLog
    @GetMapping("/contact")
    public BanksContactInfoDto contact(
            
            ) {
        return accountsContactInfoDto;
    }

}
