package live.tikgik.bank.card.mapper;

import live.tikgik.bank.card.dto.request.CardRequestDto;
import live.tikgik.bank.card.dto.response.CardResponseDto;
import live.tikgik.bank.card.entityy.Card;
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
public interface CardMapper {
    Card fromDto(CardRequestDto cardRequestDto);
    CardResponseDto toDto(Card card);

    void updateCard(@MappingTarget Card card, CardRequestDto cardRequestDto);
}
