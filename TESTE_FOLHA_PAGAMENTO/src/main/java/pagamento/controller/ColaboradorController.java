package pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.result.Field;

import java.util.ArrayList;
import java.util.List;
import pagamento.model.Colaborador;
import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.ColaboradorRepository;

@RestController   
@RequestMapping(path="/colaborador") 
public class ColaboradorController {
	
	
	@Autowired 
	private ColaboradorRepository colaboradorRepository;
	

	@PostMapping(path="/add") 
	public @ResponseBody String addColab ( @RequestParam String nome, @RequestParam String endereco,
			@RequestParam String telefone, @RequestParam String bairro, @RequestParam String cep, @RequestParam String cpf,
			@RequestParam float salarioAtual) {
		
		Colaborador c = new Colaborador();
		c.setBairro(bairro);
		c.setCep(cep);
		c.setCpf(cpf);
		c.setEndereco(endereco);
		c.setNome(nome);
		c.setSalarioAtual(salarioAtual);
		c.setTelefone(telefone);
		

		colaboradorRepository.save(c);
		return "Salvo";
	}
	
	@PostMapping(path ="/inOcorrencia")
	public @ResponseBody String insereOcorrencia(@RequestParam Long id, @RequestParam Long id_oco) {
		try {
			Colaborador c = new Colaborador(id);
			OcorrenciaFolha oc = new OcorrenciaFolha(id_oco);
			c.addOcorrencia(oc);
			colaboradorRepository.save(c);
			return "Salvo";
		}catch(Exception a){
			return "Erro" + a.toString();
		}
	}
	
	@DeleteMapping(path="/delete") 
	public @ResponseBody String deleteColabById ( @RequestParam Long id) {
		try {
			Colaborador c = new Colaborador(id);
			colaboradorRepository.delete(c);
			}
		catch (Exception ex) {
		      return "Error deleting the user:" + ex.toString();
		    }
		    return "Colaborador de codigo: "+id+" foi deletado com sucesso";	
	}
	
	
	@PutMapping(path ="/update")
	public @ResponseBody String updateColabById (@RequestParam Long id ,@RequestParam String nome, @RequestParam String endereco,
			@RequestParam String telefone, @RequestParam String bairro, @RequestParam String cep, @RequestParam String cpf,
			@RequestParam float salarioAtual) {
		Colaborador c = new Colaborador(id);
		c.setBairro(bairro);
		c.setCep(cep);
		c.setCpf(cpf);
		c.setEndereco(endereco);
		c.setNome(nome);
		c.setSalarioAtual(salarioAtual);
		c.setTelefone(telefone);
		colaboradorRepository.save(c);
		return "salvo";
	}
	
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Colaborador> getAllColabs() {
		return colaboradorRepository.findAll();
	}
	
	
}