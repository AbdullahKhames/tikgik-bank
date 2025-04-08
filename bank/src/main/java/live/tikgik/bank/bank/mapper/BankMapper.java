package live.tikgik.bank.bank.mapper;

import live.tikgik.bank.bank.dto.request.BankRequestDto;
import live.tikgik.bank.bank.dto.response.BankResponseDto;
import live.tikgik.bank.bank.entityy.Bank;
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
public interface BankMapper {
    Bank fromDto(BankRequestDto bankRequestDto);
    BankResponseDto toDto(Bank bank);

    void updateBank(@MappingTarget Bank bank, BankRequestDto bankRequestDto);
}
