package live.tikgik.bank.account.service.impl;

import live.tikgik.bank.account.dto.request.AccountRequestDto;
import live.tikgik.bank.account.dto.response.AccountResponseDto;
import live.tikgik.bank.account.entity.Account;
import live.tikgik.bank.account.entity.Customer;
import live.tikgik.bank.account.exception.ResourceNotFoundException;
import live.tikgik.bank.account.mapper.AccountMapper;
import live.tikgik.bank.account.repository.AccountRepository;
import live.tikgik.bank.account.service.AccountService;
import live.tikgik.bank.account.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final Random random = new Random();
    @Override
    @Transactional
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {
        Customer customer = customerService.findById(accountRequestDto.getCustomerId());
        Account account = accountMapper.toEntity(accountRequestDto);
        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(10000000000L + random.nextInt(0, Integer.MAX_VALUE));
        accountRepository.save(account);
        AccountResponseDto dto = accountMapper.toDto(account);
        dto.setCustomer(customerService.toDto(customer));
        return dto;
    }

    @Override
    @Transactional
    public String deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountId));
        accountRepository.delete(account);

        return "deleted successfully";
    }

    @Override
    public AccountResponseDto getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountId));
        return accountMapper.toDto(account);
    }

    @Override
    public List<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public AccountResponseDto updateAccount(Long accountId, AccountRequestDto accountRequestDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountId));
        accountMapper.updateEntity(account, accountRequestDto);
        return accountMapper.toDto(account);
    }
}
