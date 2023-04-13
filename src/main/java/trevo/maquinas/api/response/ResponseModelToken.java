package trevo.maquinas.api.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter

public class ResponseModelToken {
    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private Object token;

    public ResponseModelToken(Object token) {
        this.setToken(token);
    }
}
