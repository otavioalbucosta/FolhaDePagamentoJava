package pagamento.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;
@Entity
public class FolhaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mes;
    private int ano;
    private double totalDescontos;
    private double totalProventos;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy= "folhaPagamento")
    private List<Colaborador> colaboradores = new ArrayList();

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
   
    @JsonIgnore
    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public FolhaPagamento() {

    }
    public FolhaPagamento(Long id){this.id=id;}

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos() {
        this.totalDescontos = 0;
        for(Colaborador colaborador: this.colaboradores) {
            for(OcorrenciaFolha ocorrencia: colaborador.getOcorrencias()) {
                if(ocorrencia.getOcorrencia() == TipoOcorrencia.DESCONTO) {
                    this.totalDescontos += ocorrencia.getValor();
                }
            }
        }
    }

    public double getTotalProventos() {
        return totalProventos;
    }

    public void setTotalProventos() {
        this.totalProventos = 0;
        for(Colaborador colaborador: this.colaboradores) {
            for(OcorrenciaFolha ocorrencia: colaborador.getOcorrencias()) {
                if(ocorrencia.getOcorrencia() == TipoOcorrencia.PROVENTO) {
                    this.totalProventos += ocorrencia.getValor();
                }
            }
        }
    }

    public void inserirColaboradores(Colaborador colaborador) {
        this.colaboradores.add(colaborador);
    }


    public double calcularFolha() {
        double total = 0;

        for(Colaborador colaborador: this.colaboradores) {
            total += colaborador.getSalarioAtual();
        }
        total += this.totalProventos;
        total -= this.totalDescontos;

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}

