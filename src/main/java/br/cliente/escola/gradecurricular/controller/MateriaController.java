package br.cliente.escola.gradecurricular.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// responsavel por indicar que estamos trabalhando em um modelo arquitetural rest
// resquestmapping assume a semantica de requestbody por padrão -indico por padrao a minha URN
@RestController
@RequestMapping("/materia")
public class MateriaController {

    @GetMapping("/")
    public ResponseEntity<String> hellorWolrdRest(){ // responde uma entidade do modelo string
        return ResponseEntity.status(HttpStatus.OK).body("Olá mundo Rest");
    }
}
