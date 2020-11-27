package br.cliente.escola.gradecurricular.service;

import br.cliente.escola.gradecurricular.entity.MateriaEntity;
import br.cliente.escola.gradecurricular.exception.MateriaException;
import br.cliente.escola.gradecurricular.repository.IMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            /*
             * Método consultar irá fazer a verificação da existência o obj.
             * Caso não haja, retornará uma exceção.
             * */

            MateriaEntity materiaEntityAtualizada = this.consultar(materiaEntity.getId());

            materiaEntityAtualizada.setNome(materiaEntity.getNome());
            materiaEntityAtualizada.setCodigo(materiaEntity.getCodigo());
            materiaEntityAtualizada.setHoras(materiaEntity.getHoras());
            materiaEntityAtualizada.setFrequencia(materiaEntity.getFrequencia());
            // salva as alterações feitas
            this.iMateriaRepository.save(materiaEntityAtualizada);

            return Boolean.TRUE;

        } catch (MateriaException m){
            throw m;

        } catch (Exception e){
            throw e;

        }
    }

    @Override
    public Boolean excluir(Long id) {
        try{
            this.consultar(id);

            this.iMateriaRepository.deleteById(id);
            return true;

        } catch (MateriaException m) {
            throw m;

        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public MateriaEntity consultar(Long id){
        try{
            Optional<MateriaEntity> materiaEntityOptional = this.iMateriaRepository.findById(id);
            if(materiaEntityOptional.isPresent()){
                return materiaEntityOptional.get();

            }
            throw new MateriaException("Matéria não encontrada", HttpStatus.NOT_FOUND);
//            throw new Exception(); // para forçar Exception e ir em um erro interno

        } catch (MateriaException m){
            throw m;

        } catch (Exception e){
            throw new MateriaException("Erro interno não indentidicado. Contacte o suporte",
                    HttpStatus.INTERNAL_SERVER_ERROR);
//
        }
    }

    @Override
    public List<MateriaEntity>listar(){
        try{
            return this.iMateriaRepository.findAll();
        } catch (Exception e){
            return  new ArrayList<>();
        }
    }

    @Override
    public Boolean cadastrar(MateriaEntity materiaEntity) {
       try{
           this.iMateriaRepository.save(materiaEntity);
           return true;
       } catch (Exception e){
           return false;
       }
    }


}

