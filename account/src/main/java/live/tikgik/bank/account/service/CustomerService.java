package live.tikgik.bank.account.service;

import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.dto.response.CustomerResponseDto;
import live.tikgik.bank.account.entity.Customer;

public interface CustomerService {
    Customer save(Customer entity);

    Customer findByNumberAndPassword(LoginRequest customerRequestDto);

    Customer findById(Long customerId);

    CustomerResponseDto toDto(Customer customer);
}
