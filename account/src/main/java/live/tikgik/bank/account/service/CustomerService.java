package live.tikgik.bank.account.service;

import live.tikgik.bank.account.dto.response.CustomerDetailsDto;
import live.tikgik.bank.account.dto.request.LoginRequest;
import live.tikgik.bank.account.dto.response.CustomerResponseDto;
import live.tikgik.bank.account.entity.Customer;

public interface CustomerService {
    Customer save(Customer entity);

    Customer findByNumberAndPassword(LoginRequest customerRequestDto);
    Customer findByNumberd(String mobileNumber);

    Customer findById(Long customerId);

    CustomerResponseDto toDto(Customer customer);
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);

}
