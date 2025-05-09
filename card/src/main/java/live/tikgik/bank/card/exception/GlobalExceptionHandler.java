package live.tikgik.bank.card.exception;





import live.tikgik.bank.card.dto.response.ErrorDto;
import live.tikgik.bank.card.dto.response.ResponseDto;
import live.tikgik.bank.card.uils.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<ResponseDto<ErrorDto>> handleGlobalException(Exception e, WebRequest webRequest) {
        ErrorDto errorDto = ErrorDto.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .statusMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .url(webRequest.getDescription(false))
                .errorMessage(e.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBuilder.buildFailedResponse(errorDto, e.getMessage()));
    }
}
