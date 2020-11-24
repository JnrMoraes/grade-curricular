package br.cliente.escola.gradecurricular.controller;


import br.cliente.escola.gradecurricular.entity.MateriaEntity;
import br.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// responsavel por indicar que estamos trabalhando em um modelo arquitetural rest
// resquestmapping assume a semantica de requestbody por padrão -indico por padrao a minha URN
@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private IMateriaRepository iMateriaRepository;

//    @GetMapping("/")
//    public ResponseEntity<String> hellorWorldRest(){ // responde uma entidade do modelo string
//        return ResponseEntity.status(HttpStatus.OK).body("Olá mundo Rest");
//    }

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMateria(){
        return ResponseEntity.status(HttpStatus.OK).body(this.iMateriaRepository.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<MateriaEntity> consultaId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.iMateriaRepository.findById(id).get()); // chamo o Optiona e depois dou um get nele, ver o Sonar
    }

    @PostMapping
    public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materiaEntity){ // json, corpo para o webservice
        try{
            this.iMateriaRepository.save(materiaEntity);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }

    }


}
