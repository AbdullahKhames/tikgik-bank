package live.tikgik.bank.bank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorDto {

	private int statusCode;
	private String statusMessage;
	private String url;
	private LocalDateTime errorTime;
	private String errorMessage;
}
