package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pagamento.model.FolhaPagamento;
import pagamento.repositories.FolhaPagamentoRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/folhapagamento")
public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoRepository folhapagamentorepository;
    @GetMapping(path="/add")
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
        // This returns a JSON or XML with the users
        return folhapagamentorepository.findAll();
    }

    @GetMapping(path="/delete") // Map ONLY GET Requests
    public @ResponseBody String deleteById ( @RequestParam int codigo) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {
            FolhaPagamento c = new FolhaPagamento(codigo);
            folhapagamentorepository.delete(c);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "Colaborador de codigo: "+codigo+" foi deletado com sucesso";
    }

}
