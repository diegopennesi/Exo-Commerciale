package ejb_utenteCrud;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Utente;

@Stateless
public class UtentiEJB implements Iutenti {
	//vanno effettuati i vari catch di persistenza sql in ogni metodo
	@EJB
	Iconnessioni x;

	@Override
	public boolean inserisciutente(Utente ut) {
		EntityManager entitymanager=x.apriconnessione();
		try{
			entitymanager.persist(ut);
		}catch (Exception e) {
			return false;
		}
		x.chiudiconnessione(entitymanager);	
		return true;
	}
	@Override
	public void cancellautente(Utente ut) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.remove(ut);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public void modificautente(Utente ut) {
		EntityManager entitymanager=x.apriconnessione();
		Utente temp=entitymanager.find(Utente.class, ut.getId());
		temp.setNome(ut.getNome());
		temp.setCognome(ut.getCognome());
		temp.setIndirizzo(ut.getIndirizzo());
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public List<Utente> cercautenteperNome(Utente ut) {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Utente> query =entitymanager.createQuery("SELECT c FROM Utente c WHERE c.name LIKE :custName", Utente.class).setParameter("custName", ut.getNome());
		List<Utente> listaUtente= query.getResultList();
		x.chiudiconnessione(entitymanager);
		return listaUtente;
	}
}
