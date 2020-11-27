package br.cliente.escola.gradecurricular.service;

import br.cliente.escola.gradecurricular.entity.MateriaEntity;

import java.util.List;

public interface IMateriaService {

    public Boolean atualizar(final MateriaEntity materia);

    public  Boolean excluir(final Long id);

    public MateriaEntity consultar(final Long id);

    public List<MateriaEntity> listar();

    public Boolean cadastrar(final MateriaEntity materiaEntity);


}
