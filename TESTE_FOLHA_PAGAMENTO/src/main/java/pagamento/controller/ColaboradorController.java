package pagamento.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mysql.cj.result.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pagamento.model.Colaborador;
import pagamento.model.OcorrenciaFolha;
import pagamento.repositories.ColaboradorRepository;
import pagamento.repositories.OcorrenciaFolhaRepository;

@RestController   
@RequestMapping(path="/colaborador") 
public class ColaboradorController {
	
	
	@Autowired 
	private ColaboradorRepository colaboradorRepository;
	@Autowired
	private OcorrenciaFolhaRepository ocorr;

	@PostMapping(path="/add") 
	public @ResponseBody String addColab (@RequestParam String nome, @RequestParam String endereco,
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

			Colaborador c = colaboradorRepository.findById(id).get();
			OcorrenciaFolha of = ocorr.findById(id_oco).get();
			of.setColaborador(c);
			c.getOcorrencias().add(of);
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

	@GetMapping(path="/findById/{ocoId}")
	public @ResponseBody Optional<Colaborador> getOcorrenciaById(@PathVariable(value="colabId")Long colabId){
		return colaboradorRepository.findById(colabId);
	}
}