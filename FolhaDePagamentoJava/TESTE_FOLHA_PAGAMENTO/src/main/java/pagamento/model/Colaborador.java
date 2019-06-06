package pagamento.model;



import java.util.*;
import javax.persistence.*;


@Entity // This tells Hibernate to make a table out of this class
public class Colaborador {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String bairro;
    private String cep;
    private String cpf;
    private float salarioAtual;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "colaborador")
    private List<OcorrenciaFolha> ocorrencias =new ArrayList();


   	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FolhaPagamento")
	private FolhaPagamento folhaPagamento;

	public Colaborador(){}
    public Colaborador(int codigo){
    	this.codigo=codigo;
    }

	public FolhaPagamento getFolhaPagamento() {
		return folhaPagamento;
	}

	public void setFolhaPagamento(FolhaPagamento folhaPagamento) {
		this.folhaPagamento = folhaPagamento;
	}
    
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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


	public List<OcorrenciaFolha> getOcorrencias() {
		return ocorrencias;
	}

	public void inserirOcorrencias(OcorrenciaFolha ocorrencia) {
		this.ocorrencias.add(ocorrencia);
	}





}
