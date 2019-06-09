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
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "colaborador")
    private List<OcorrenciaFolha> ocorrencias=new ArrayList<>();


   	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="folhaPagamrnto_id")
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
	
	public String getThing(String att) {
		switch (att) {
			case "nome":
				return this.getNome();
			case "endereco":
				return this.getEndereco();
			case "cep":
				return this.getCep();
			case "cpf":
				return this.getNome();
			case "telefone":
				return this.getTelefone();	
			case "bairro":
				return this.getBairro();
			case "salarioAtual":
				Float sA = this.getSalarioAtual();
				return sA.toString();
			default :
				break;
		}
		return "não achou";
	}

	public void setThing(String att,String neww) {
		switch (att) {
			case "nome":
				this.setNome(neww);
				break;
			case "endereco":
				this.setEndereco(neww);
				break;
			case "cep":
				this.setCep(neww);
				break;
			case "cpf":
				this.setCpf(neww);
				break;
			case "telefone":
				this.setTelefone(neww);
				break;
			case "bairro":
				this.setBairro(neww);
				break;
			case "salarioAtual":
				float sA = Float.parseFloat(neww);
				this.setSalarioAtual(sA);
			default :
				break;
		}
	}
	@JsonIgnore
	public List<OcorrenciaFolha> getOcorrencias() {
		return ocorrencias;
	}

	public void inserirOcorrencias(OcorrenciaFolha ocorrencia) {
		this.ocorrencias.add(ocorrencia);
	}





}
