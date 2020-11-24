package br.cliente.escola.gradecurricular.service;

import br.cliente.escola.gradecurricular.entity.MateriaEntity;
import br.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements  IMateriaService{

    @Autowired
    private IMateriaRepository iMateriaRepository;

    @Override
    public Boolean atualizar(MateriaEntity materiaEntity) {
        try{
            // busca a materia que quero atualizar e guardo em uma variável
            MateriaEntity materiaEntityAtualizada = this.iMateriaRepository.findById(materiaEntity.getId()).get();

            // atualizo todos os valores
            materiaEntityAtualizada.setNome(materiaEntity.getNome());
            materiaEntityAtualizada.setCodigo(materiaEntity.getCodigo());
            materiaEntityAtualizada.setHoras(materiaEntity.getHoras());
            materiaEntityAtualizada.setFrequencia(materiaEntity.getFrequencia());

            // salva as alterações feitas
            this.iMateriaRepository.save(materiaEntityAtualizada);

            return true;

        } catch (Exception e){

            return  false;
        }
    }

    @Override
    public Boolean excluir(Long id) {
        try{
            this.iMateriaRepository.deleteById(id);
            return true;

        } catch (Exception e){
            return false;
        }
    }

    @Override
    public MateriaEntity consultarMateria(Long id){
        try{
            Optional<MateriaEntity> materiaEntityOptional = this.iMateriaRepository.findById(id);
            if(materiaEntityOptional.isPresent()){
                return materiaEntityOptional.get();
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<MateriaEntity>listarMateria(){
        try{
            return this.iMateriaRepository.findAll();
        } catch (Exception e){
            return  new ArrayList<>();
        }
    }

    @Override
    public Boolean cadastrarMateria(MateriaEntity materiaEntity) {
       try{
           this.iMateriaRepository.save(materiaEntity);
           return true;
       } catch (Exception e){
           return false;
       }
    }


}

