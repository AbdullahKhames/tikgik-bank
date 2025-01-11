package live.tikgik.bank.account.mapper;

import live.tikgik.bank.account.dto.request.AccountRequestDto;
import live.tikgik.bank.account.dto.response.AccountResponseDto;
import live.tikgik.bank.account.entity.Account;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        implementationName = "<CLASS_NAME>Impl",
        implementationPackage = "<PACKAGE_NAME>",
        uses = {},
        imports = {}
)
public interface AccountMapper {
    Account toEntity(AccountRequestDto accountRequestDto);
    AccountResponseDto toDto(Account account);

    @Mappings({
            @Mapping(target = "customerId", ignore = true)
    })
    void updateEntity(@MappingTarget Account account, AccountRequestDto accountRequestDto);
}
