package ejb_alimentariCrud;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Alimentari;

@Stateless
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
		Alimentari temp=entitymanager.find(Alimentari.class, al.getId());
		temp.setNome(al.getNome());
		temp.setPrezzo(al.getPrezzo());
		temp.setDescrizione(al.getDescrizione());
		temp.setQuantita(al.getQuantita());
		temp.setScadenza(al.getScadenza());
		temp.setReparti(al.getReparti());
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public Utente cercaalimwntoperid(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		Alimentari temp=entitymanager.find(Alimentari.class, al.getId());
		return temp;
	}
	
	

}
