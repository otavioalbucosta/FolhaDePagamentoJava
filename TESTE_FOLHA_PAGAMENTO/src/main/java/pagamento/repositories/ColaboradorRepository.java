package pagamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import pagamento.model.Colaborador;


@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {
	
	@Query(value="SELECT c.nome FROM colaborador c", nativeQuery=true)
	public List<String> listarColaboradores();
	
	@Query(value="SELECT c.* FROM colaborador c WHERE c.id = :id", nativeQuery=true)
	public List<Colaborador> getInfoColab(@Param("id") Long id);
	
	String totalProvEDes = "SELECT \r\n" + 
			"(\r\n" + 
			"    SELECT sum(ocorrencia_folha.valor) \r\n" + 
			"    FROM ocorrencia_folha, colaborador \r\n" + 
			"    WHERE ocorrencia_folha.ocorrencia = 'DESCONTO' AND ocorrencia_folha.colaborador_id = colaborador.id AND colaborador.id = :id\r\n" + 
			"    GROUP BY colaborador.id\r\n" + 
			")as Descontos,\r\n" + 
			"\r\n" + 
			"(\r\n" + 
			"    SELECT sum(ocorrencia_folha.valor)\r\n" + 
			"    FROM ocorrencia_folha, colaborador\r\n" + 
			"    WHERE ocorrencia_folha.ocorrencia = 'PROVENTO' AND ocorrencia_folha.colaborador_id = colaborador.id AND colaborador.id = :id\r\n" + 
			"    GROUP BY colaborador.id\r\n" + 
			") as Proventos\r\n" + 
			"\r\n" + 
			"FROM colaborador\r\n" + 
			"WHERE colaborador.id = :id";
	
	@Query(value=totalProvEDes, nativeQuery=true)
	public List<List<Double>> getTotalOcorrencias(@Param("id") Long id);
}
