package live.tikgik.bank.account.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
