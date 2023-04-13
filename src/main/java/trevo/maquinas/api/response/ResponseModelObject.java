package trevo.maquinas.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModelObject extends ResponseModel {
    private Object object;
    public ResponseModelObject (String message, Object object) {
        this.setObject(object);
        this.setMessage(message);
    }

}
