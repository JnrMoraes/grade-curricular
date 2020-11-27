package br.cliente.escola.gradecurricular.handler;

import br.cliente.escola.gradecurricular.exception.MateriaException;
import br.cliente.escola.gradecurricular.model.ErrorResponse;
import br.cliente.escola.gradecurricular.model.ErrorResponse.ErrorResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // indica que todas as exception viram para ca
public class ResourceHandler {

    @ExceptionHandler({MateriaException.class})
    public ResponseEntity<ErrorResponse> handlerMeteriaException(MateriaException m) {
        ErrorResponseBuilder erro = ErrorResponse.builder();
        erro.httpStatus(m.getHttpStatus().value());
        erro.mensagem(m.getMessage());
        erro.timeStamp(System.currentTimeMillis());
        return ResponseEntity.status(m.getHttpStatus()).body(erro.build());

    }
}
