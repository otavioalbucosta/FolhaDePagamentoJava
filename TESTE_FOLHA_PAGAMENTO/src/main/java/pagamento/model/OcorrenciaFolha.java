package pagamento.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;


@Entity

public class OcorrenciaFolha implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
    private float valor;
    @Enumerated(EnumType.STRING)
    private TipoOcorrencia ocorrencia;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="colaborador_id")
    private Colaborador colaborador;


	public OcorrenciaFolha() {
	}

	public OcorrenciaFolha(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public Colaborador getColaborador() {
		return colaborador;
	}
	@JsonIgnore
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public TipoOcorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		if(ocorrencia.equals("p") || ocorrencia.equals("PROVENTO") || ocorrencia.equals("provento")) {
			this.ocorrencia=TipoOcorrencia.PROVENTO;
		}else if(ocorrencia.equals("d") || ocorrencia.equals("DESCONTO") || ocorrencia.equals("desconto")){
			this.ocorrencia=TipoOcorrencia.DESCONTO;
		}


	}
	public Long getColaboradorId(){
		return colaborador.getId();
	}


	
	
    
    
    
	
	
	
	
	
	

}
