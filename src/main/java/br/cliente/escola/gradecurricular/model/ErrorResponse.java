package br.cliente.escola.gradecurricular.model;

import lombok.Builder;
import lombok.Getter;

@Builder // permite que os atributos sejam imutavies, não muito legal quando se tem serialazible
@Getter
public class ErrorResponse {

    private String mensagem;
    private int httpStatus;
    private long timeStamp;


}
