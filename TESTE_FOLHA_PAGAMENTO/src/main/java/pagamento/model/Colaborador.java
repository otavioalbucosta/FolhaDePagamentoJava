package pagamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;




@Entity
@Table(name="colaborador")
public class Colaborador implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String bairro;
    private String cep;
    private String cpf;
    private float salarioAtual;
	
    @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "colaborador")
    private List<OcorrenciaFolha> ocorrencias=new ArrayList<>();

    
   	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="folhaPagamento_id")
   	@JsonIgnore
	private FolhaPagamento folhaPagamento;

	public Colaborador(){}
    public Colaborador(Long id){
    	this.id=id;
    }


    
    @JsonIgnore
	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}
	@JsonIgnore
	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}
	@JsonIgnore
	public Long getFolhaPagamentoId(){return folhaPagamento.getId();}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getSalarioAtual() {
		return salarioAtual;
	}
	public void setSalarioAtual(float salarioAtual) {
		this.salarioAtual = salarioAtual;
	}
	
	public void addOcorrencia(OcorrenciaFolha of) {
		this.ocorrencias.add(of);
		
	}
	

	@JsonIgnore
	public List<OcorrenciaFolha> getOcorrencias() {
		return ocorrencias;
	}

	public void inserirOcorrencias(OcorrenciaFolha ocorrencia) {
		this.ocorrencias.add(ocorrencia);
	}





}
