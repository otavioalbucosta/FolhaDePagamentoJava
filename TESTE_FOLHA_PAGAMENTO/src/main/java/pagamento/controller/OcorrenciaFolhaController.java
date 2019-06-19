package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import pagamento.model.FolhaPagamento;
import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.OcorrenciaFolhaRepository;
import pagamento.model.TipoOcorrencia;

import java.util.List;
import java.util.Optional;


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
		System.out.println(of.getOcorrencia());
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
	    public @ResponseBody String updateOcorrencia (@RequestParam Long id ,@RequestParam(required = false) String descricao,@RequestParam(required = false) Float valor,@RequestParam(required = false) String ocorrencia){
	       OcorrenciaFolha of = new OcorrenciaFolha(id);
	       if(descricao!=null){of.setDescricao(descricao);}
	       if(ocorrencia!=null){of.setOcorrencia(ocorrencia);}
	       if(valor!=null){of.setValor(valor);}
	       ocorrenciaFolhaRepository.save(of);
	        return "Saved";
	    }
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<OcorrenciaFolha> getAllOcorrencia() {
		return ocorrenciaFolhaRepository.findAll();
	}

	@GetMapping(path="/findById/{ocoId}")
	public @ResponseBody Optional<OcorrenciaFolha> getOcorrenciaById(@PathVariable(value="ocoId")Long ocoId){
		return ocorrenciaFolhaRepository.findById(ocoId);
	}
	
	
}
