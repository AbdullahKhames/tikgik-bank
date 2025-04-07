package live.tikgik.bank.bank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseDto <T> {
    private T data;
    private String message;
    private LocalDateTime time = LocalDateTime.now();
    private int statusCode;
    private String statusMessage;

}
