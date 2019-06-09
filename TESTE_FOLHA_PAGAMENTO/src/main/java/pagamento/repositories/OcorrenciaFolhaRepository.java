package pagamento.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import pagamento.model.OcorrenciaFolha;
@Repository
public interface OcorrenciaFolhaRepository extends CrudRepository<OcorrenciaFolha, Long>{

}
