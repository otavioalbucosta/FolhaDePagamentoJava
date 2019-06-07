package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pagamento.model.FolhaPagamento;
import pagamento.repositories.FolhaPagamentoRepository;

@Controller    
@RequestMapping(path="/folhapagamento")
public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoRepository folhapagamentorepository;
    @PostMapping(path="/add")
    public @ResponseBody String addnewfolha (@RequestParam int mes,@RequestParam int ano){
        FolhaPagamento f = new FolhaPagamento();
        f.setMes(mes);
        f.setAno(ano);
        f.setTotalDescontos();
        f.setTotalProventos();
        folhapagamentorepository.save(f);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<FolhaPagamento> getAllUsers() {
        return folhapagamentorepository.findAll();
    }

    @GetMapping(path="/delete")
    public @ResponseBody String deleteById ( @RequestParam Long id) {
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
