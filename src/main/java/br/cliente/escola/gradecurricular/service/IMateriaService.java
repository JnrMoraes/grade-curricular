package br.cliente.escola.gradecurricular.service;

import br.cliente.escola.gradecurricular.entity.MateriaEntity;

import java.util.List;

public interface IMateriaService {

    public Boolean atualizar(final MateriaEntity materia);

    public  Boolean excluir(final Long id);

    public MateriaEntity consultarMateria(final Long id);

    public List<MateriaEntity> listarMateria();

    public Boolean cadastrarMateria(final MateriaEntity materiaEntity);

}
