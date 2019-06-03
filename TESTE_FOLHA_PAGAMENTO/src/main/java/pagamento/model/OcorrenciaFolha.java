package pagamento.model;



import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;



@Entity // This tells Hibernate to make a table out of this class

public class OcorrenciaFolha {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String descricao;
    private float valor;
    private Enum ocorrencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colaborador")
    private Colaborador colaborador;


	public OcorrenciaFolha() {
	}

	public OcorrenciaFolha(int codigo) {
		this.codigo = codigo;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public Enum getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(Enum ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	
    
    
    
	
	
	
	
	
	

}
