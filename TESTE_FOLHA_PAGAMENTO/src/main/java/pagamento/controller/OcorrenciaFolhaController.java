package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.OcorrenciaFolhaRepository;
import pagamento.model.TipoOcorrencia;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/ocorrencia") // This means URL's start with /demo (after Application path)
public class OcorrenciaFolhaController {
	
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private OcorrenciaFolhaRepository ocorrenciaFolhaRepository;
	
	
		
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String descricao,@RequestParam float valor,@RequestParam TipoOcorrencia ocorrencia) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		OcorrenciaFolha of=new OcorrenciaFolha();
		of.setDescricao(descricao);
		of.setOcorrencia(ocorrencia);
		of.setValor(valor);
		ocorrenciaFolhaRepository.save(of);
/*//-------------------------------------------------------------------------------------------------------------------------
		try {
			Colaborador c=colaboradorRepository.findById(colaboradorID).get();		
			colaboradorRepository.delete(c);
			c.addOcorrencia(of.getCodigo());
			colaboradorRepository.save(c);
			
			}catch (Exception ex) {
		      return "Error deleting the user:" + ex.toString();
		    }
		    return "Colaborador de codigo: "+colaboradorID+" foi deletado com sucesso";
		
		
*///-------------------------------------------------------------------------------------------------------------------------
		
		
		return "deu certo";
	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<OcorrenciaFolha> getAllUsers() {
		// This returns a JSON or XML with the users
		return ocorrenciaFolhaRepository.findAll();
	}
	
	
	
	/*
	@GetMapping(path="/addOF") // Map ONLY GET Requests
	public @ResponseBody String addOF ( @RequestParam int userID,@RequestParam int ofID) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request	
		try {
			
			
	
			}
		catch (Exception ex) {
		      return "Error deleting the user:" + ex.toString();
		    }
		    return "Colaborador de codigo: "+userID+" foi deletado com sucesso";	
	}
	*/
	
	

	
	
	
	
	
	
}
