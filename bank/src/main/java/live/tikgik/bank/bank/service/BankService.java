package live.tikgik.bank.bank.service;

import live.tikgik.bank.bank.dto.request.BankRequestDto;
import live.tikgik.bank.bank.dto.response.BankResponseDto;

import java.util.List;

public interface BankService {
    BankResponseDto createBank(BankRequestDto accountRequestDto);

    String deleteBank(String accountId);

    BankResponseDto getBank(String accountId);

    List<BankResponseDto> getAllBanks();

    BankResponseDto updateBank(String accountId, BankRequestDto accountRequestDto);
}
