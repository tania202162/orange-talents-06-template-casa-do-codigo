package br.com.zup.academy.tania.casadocodigo.fluxopagto;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	//@PersistenceContext
	//private EntityManager entityManager;

	@PostMapping(value = "/clientes")
	@Transactional
	public String cria(@RequestBody @Valid ClienteRequest request) {
		Cliente cliente = request.toModel();
/*		
		if(cliente.getEstado().isEmpty()) {
			Query query = entityManager.createQuery(
					"select a.nome from estado a inner join pais b on (a.pais_id = b.id) where b.nome ="+ '"'+cliente.getPais()+'"'); 
			List<?> list =  query.getResultList();
			if (list.isEmpty()) {
				 cliente.setEstado("null");
			}  else return "Existe Estado cadastrado para o Pais escolhido!";
		}	
		else {

			Query query1 = entityManager.createQuery("select a.nome from estado a inner join pais b on (a.pais_id = b.id) where b.nome = "+ '"'+cliente.getPais()+'"' +" and a.nome = "+ '"'+cliente.getEstado()+'"');
			List<?> list1 =  query1.getResultList();
			if (list1.isEmpty()) {
				 return "Estado não cadastrado para o Pais escolhido";
			}  
		}	
	*/	
			manager.persist(cliente);
			System.out.println(cliente.toString());
			return cliente.toString();			
		} 
	}