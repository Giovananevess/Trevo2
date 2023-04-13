package trevo.maquinas.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseModel {
    private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String message;
}

