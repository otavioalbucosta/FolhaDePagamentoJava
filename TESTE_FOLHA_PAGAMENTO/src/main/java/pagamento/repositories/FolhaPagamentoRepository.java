package pagamento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pagamento.model.FolhaPagamento;
@Repository
public interface FolhaPagamentoRepository extends CrudRepository<FolhaPagamento,Long> {
}
