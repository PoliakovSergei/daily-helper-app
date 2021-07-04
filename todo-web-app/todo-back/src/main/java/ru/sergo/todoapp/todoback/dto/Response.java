package ru.sergo.todoapp.todoback.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Response<T> {

    private Integer code;
    private T data;
    private String message;

    @UtilityClass
    public class ResponseBuilder {
        public <T> Response<T> ok(T data) {
            return new Response<>(HttpStatus.OK.value(), data, HttpStatus.OK.getReasonPhrase());
        }

        public <T> Response<T> fail(HttpStatus status, String message) {
            return new Response<>(status.value(), null, message);
        }
    }
}
