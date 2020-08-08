package ejb_alimentariCrud;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Alimentari;


public class AlimentariEJB implements Ialimentari {
	
	@EJB
	Iconnessioni x;
	
	@Override
	public boolean inseriscialimento(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		try{
			entitymanager.persist(al);
		}catch (Exception e) {
			return false;
		}
		x.chiudiconnessione(entitymanager);	
		return true;
	}
	@Override
	public void cancellaalimento(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.remove(al);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public void modificaalimento(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		Utente temp=entitymanager.find(Utente.class, al.getId());
		temp.setNome(al.getNome());
		temp.setCognome(al.getCognome());
		temp.setIndirizzo(al.getIndirizzo());
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public Utente cercaalimwntoperid(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		Utente temp=entitymanager.find(Utente.class, al.getId());
		return temp;
	}
	
	

}
