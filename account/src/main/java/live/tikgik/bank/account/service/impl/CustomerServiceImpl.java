package live.tikgik.bank.account.service.impl;

import live.tikgik.bank.account.dto.response.BankDto;
import live.tikgik.bank.account.dto.response.CardsDto;
import live.tikgik.bank.account.dto.response.CustomerDetailsDto;
import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.dto.response.CustomerResponseDto;
import live.tikgik.bank.account.entity.Account;
import live.tikgik.bank.account.entity.Customer;
import live.tikgik.bank.account.exception.ResourceAlreadyExistException;
import live.tikgik.bank.account.exception.ResourceNotFoundException;
import live.tikgik.bank.account.mapper.AccountMapper;
import live.tikgik.bank.account.mapper.CustomerMapper;
import live.tikgik.bank.account.repository.AccountRepository;
import live.tikgik.bank.account.repository.CustomerRepository;
import live.tikgik.bank.account.service.CustomerService;
import live.tikgik.bank.account.service.client.BankFeignClient;
import live.tikgik.bank.account.service.client.CardsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountRepository accountsRepository;
    private final AccountMapper accountMapper;
    private final CardsFeignClient cardsFeignClient;
    private final BankFeignClient bankFeignClient;
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Customer save(Customer entity) {
        if (customerRepository.existsByMobileNumber(entity.getMobileNumber())) {
            throw new ResourceAlreadyExistException("Customer", "mobileNumber", entity.getMobileNumber());
        }
        return customerRepository.save(entity);
    }

    @Override
    public Customer findByNumberAndPassword(LoginRequest customerRequestDto) {
        return customerRepository.findByMobileNumberAndPassword(customerRequestDto.getMobileNumber(), customerRequestDto.getPassword())
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "number", customerRequestDto.getMobileNumber()));
    }

    @Override
    public Customer findByNumberd(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
    }

    @Override
    public Customer findById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId));
    }

    @Override
    public CustomerResponseDto toDto(Customer customer) {
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = customerMapper.toCustomerDetailsDto(customer);
        customerDetailsDto.setAccountsDto(accountMapper.toAccountsDto(accounts));

        ResponseEntity<BankDto> loansDtoResponseEntity = bankFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if (loansDtoResponseEntity != null) {
            customerDetailsDto.setBanksDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if (cardsDtoResponseEntity != null) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
