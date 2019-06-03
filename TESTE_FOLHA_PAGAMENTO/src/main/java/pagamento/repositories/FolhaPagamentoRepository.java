package pagamento.repositories;

import org.springframework.data.repository.CrudRepository;
import pagamento.model.FolhaPagamento;

public interface FolhaPagamentoRepository extends CrudRepository<FolhaPagamento,Integer> {
}
