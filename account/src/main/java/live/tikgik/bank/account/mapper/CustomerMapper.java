package live.tikgik.bank.account.mapper;
import live.tikgik.bank.account.dto.request.CustomerRequestDto;
import live.tikgik.bank.account.dto.response.CustomerResponseDto;
import live.tikgik.bank.account.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = org.mapstruct.NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        implementationName = "<CLASS_NAME>Impl",
        implementationPackage = "<PACKAGE_NAME>",
        uses = {},
        imports = {}
)
public interface CustomerMapper {
    Customer toEntity(CustomerRequestDto customerRequestDto);
    CustomerResponseDto toDto(Customer customer);
}
