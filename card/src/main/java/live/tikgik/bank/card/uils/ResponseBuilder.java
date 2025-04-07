package live.tikgik.bank.card.uils;


import live.tikgik.bank.card.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;

public class ResponseBuilder {
    public static <T> ResponseDto<T> buildResponse(T data, String message, int status, String statusMessage) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setData(data);
        responseDto.setMessage(message);
        responseDto.setStatusCode(status);
        responseDto.setStatusMessage(statusMessage);
        return responseDto;
    }
    public static <T> ResponseDto<T> buildSuccessResponse(T data, String message) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setData(data);
        responseDto.setMessage(message);
        responseDto.setStatusCode(HttpStatus.OK.value());
        responseDto.setStatusMessage(HttpStatus.OK.getReasonPhrase());
        return responseDto;
    }

    public static <T> ResponseDto<T> buildFailedResponse(T errorDto, String message) {
        ResponseDto<T> responseDto = new ResponseDto<>();
        responseDto.setData(errorDto);
        responseDto.setMessage(message);
        responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDto.setStatusMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        return responseDto;
    }
}
