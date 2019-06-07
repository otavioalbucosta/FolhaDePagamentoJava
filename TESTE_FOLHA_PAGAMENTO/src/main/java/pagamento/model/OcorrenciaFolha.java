package pagamento.model;



import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;



@Entity

public class OcorrenciaFolha {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String descricao;
    private float valor;
    @Enumerated(EnumType.STRING)
    private TipoOcorrencia ocorrencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colaborador")
    private Colaborador colaborador;


	public OcorrenciaFolha() {
	}

	public OcorrenciaFolha(Long id) {
		this.id = id;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
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
		if(ocorrencia == "p") {
			this.ocorrencia=TipoOcorrencia.PROVENTO;
		}else if(ocorrencia == "d"){
			this.ocorrencia=TipoOcorrencia.DESCONTO;
		}
	}
	
	
    
    
    
	
	
	
	
	
	

}
