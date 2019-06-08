package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pagamento.model.FolhaPagamento;
import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.OcorrenciaFolhaRepository;
import pagamento.model.TipoOcorrencia;


@RestController    
@RequestMapping(path="/ocorrencia") 
public class OcorrenciaFolhaController {
	
	
	@Autowired 
	private OcorrenciaFolhaRepository ocorrenciaFolhaRepository;
	
	
		
	@PostMapping(path="/add") 
	public @ResponseBody String addOcorrencia (@RequestParam String descricao,@RequestParam float valor,@RequestParam String ocorrencia) {
		OcorrenciaFolha of=new OcorrenciaFolha();
		of.setDescricao(descricao);
		of.setOcorrencia(ocorrencia);
		of.setValor(valor);
		ocorrenciaFolhaRepository.save(of);
		return "Salvo";
	}
	
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteOcorrenciaById(@RequestParam Long id){
		OcorrenciaFolha of = new OcorrenciaFolha(id);
		try{
		ocorrenciaFolhaRepository.delete(of);
		return "Deletado";
		}finally{
		}	
		}
	
	 @PutMapping(path="/update")
	    public @ResponseBody String updateOcorrencia (@RequestParam Long id ,@RequestParam String descricao,@RequestParam float valor,@RequestParam String ocorrencia){
	       OcorrenciaFolha of = new OcorrenciaFolha(id);
	       of.setDescricao(descricao);
	       of.setOcorrencia(ocorrencia);
	       of.setValor(valor);
	       ocorrenciaFolhaRepository.save(of);
	        return "Saved";
	    }
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<OcorrenciaFolha> getAllOcorrencia() {
		return ocorrenciaFolhaRepository.findAll();
	}
	
	
}
