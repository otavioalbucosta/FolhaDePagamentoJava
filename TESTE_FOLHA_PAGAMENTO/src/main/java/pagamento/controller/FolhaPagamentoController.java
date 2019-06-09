package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pagamento.model.Colaborador;
import pagamento.model.FolhaPagamento;
import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.ColaboradorRepository;
import pagamento.repositories.FolhaPagamentoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/folhapagamento")
public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoRepository folhapagamentorepository;
    private ColaboradorRepository colabrepo;
    @PostMapping(path="/add")
    public @ResponseBody String addFolha (@RequestParam int mes,@RequestParam int ano){
        FolhaPagamento f = new FolhaPagamento();
        f.setMes(mes);
        f.setAno(ano);
        f.setTotalDescontos();
        f.setTotalProventos();
        folhapagamentorepository.save(f);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FolhaPagamento> getAllFolhas() {
        return folhapagamentorepository.findAll();
    }

    @GetMapping(path="/findById/{ocoId}")
    public @ResponseBody Optional<FolhaPagamento> getOcorrenciaById(@PathVariable(value="folhaId")Long folhaId){
        return folhapagamentorepository.findById(folhaId);
    }

    @PostMapping(path="/insereFolha")
    public @ResponseBody String insereFolha(@RequestParam Long idFolha, @RequestParam Long idColab) {
    	FolhaPagamento fp = folhapagamentorepository.findById(idFolha).get();
    	Colaborador c = colabrepo.findById(idColab).get();
    	fp.inserirColaboradores(c);
    	c.setFolhaPagamento(fp);
    	fp.setTotalDescontos();
        fp.setTotalProventos();
    	folhapagamentorepository.save(fp);
		return null;
        
    }
    
    @GetMapping(path = "/getValor")
	public @ResponseBody double calcTotFolha(@RequestParam Long id){
		FolhaPagamento fp = new FolhaPagamento(id);
		return fp.calcularFolha();
	}
    
    
    @PutMapping(path="/update")
    public @ResponseBody String updateFolha (@RequestParam Long id ,@RequestParam int mes,@RequestParam int ano){
        FolhaPagamento f = new FolhaPagamento(id);
        f.setMes(mes);
        f.setAno(ano);
        f.setTotalDescontos();
        f.setTotalProventos();
        folhapagamentorepository.save(f);
        return "Saved";
    }
    
    
    @DeleteMapping(path="/delete")
    public @ResponseBody String deleteFolhaById ( @RequestParam Long id) {
        try {
            FolhaPagamento c = new FolhaPagamento(id);
            folhapagamentorepository.delete(c);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "folha de codigo: "+id+" foi deletado com sucesso";
    }

}
