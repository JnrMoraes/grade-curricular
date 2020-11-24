package br.cliente.escola.gradecurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tb_materia")
@Data
@NoArgsConstructor
public class MateriaEntity implements Serializable { // tranforma em sequencia de bites, conserva com segurnça o que é escrito aqui

    private static final long serialVersionUID = 7027177949298477102L;

    @JsonInclude(Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")  // especifica a regra, a responsabilidade não é do cliente e sim do banco
    @GenericGenerator(name = "increment", strategy = "increment") // qual a estrategia = 1,2,3,4 sequencial
    @Column(name = "id")
    private Long id;


    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @Column(name = "hrs")
    private int horas;

    @JsonInclude(Include.NON_EMPTY)
    @Column(name = "cod")
    private String codigo;

    @Column(name = "freq")
    private int frequencia;

}
