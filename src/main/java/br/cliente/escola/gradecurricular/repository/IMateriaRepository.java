package br.cliente.escola.gradecurricular.repository;

import br.cliente.escola.gradecurricular.entity.MateriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepository extends JpaRepository<MateriaEntity, Long> {

}
