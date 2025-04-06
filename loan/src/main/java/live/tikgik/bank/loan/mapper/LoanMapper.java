package live.tikgik.bank.loan.mapper;

import live.tikgik.bank.loan.dto.request.LoanRequestDto;
import live.tikgik.bank.loan.dto.response.LoanResponseDto;
import live.tikgik.bank.loan.entityy.Loan;
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
public interface LoanMapper {
    Loan fromDto(LoanRequestDto loanRequestDto);
    LoanResponseDto toDto(Loan loan);
    @Mappings({
            @Mapping(target = "customerId", ignore = true)
    })
    void updateLoan(@MappingTarget Loan loan, LoanRequestDto loanRequestDto);
}
