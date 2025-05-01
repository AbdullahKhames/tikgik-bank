package live.tikgik.bank.account.service;

import live.tikgik.bank.account.dto.request.AccountRequestDto;
import live.tikgik.bank.account.dto.response.AccountResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    AccountResponseDto createAccount(AccountRequestDto accountRequestDto);

    String deleteAccount(Long accountId);

    AccountResponseDto getAccount(Long accountId);

    List<AccountResponseDto> getAllAccounts();

    AccountResponseDto updateAccount(Long accountId, AccountRequestDto accountRequestDto);

    boolean updateCommunicationStatus(Long accountNumber);
}
