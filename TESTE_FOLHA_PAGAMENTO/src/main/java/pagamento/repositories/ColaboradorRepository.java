package pagamento.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import pagamento.model.Colaborador;
@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {

}
