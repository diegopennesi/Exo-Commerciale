package ejb_elettronicaCrud;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.BollaacquistoElettronica;
import model.Elettronica;

@Stateless
public class ElettronicaEJB implements Ielettronica{
	
	@EJB
	Iconnessioni x;

	@Override
	public boolean inseriscielettronica(Elettronica el) {
		EntityManager entitymanager=x.apriconnessione();
		try{
			entitymanager.persist(el);
		}catch (Exception e) {
			return false;
		}
		x.chiudiconnessione(entitymanager);	
		return true;
	}
	@Override
	public void cancellaelettronica(Elettronica el) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.remove(el);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public void modificaelettronica(Elettronica el) {
		EntityManager entitymanager=x.apriconnessione();
		Elettronica temp=entitymanager.find(Elettronica.class, el.getId());
		temp.setNome(el.getNome());
		temp.setDestrizione(el.getDestrizione());
		temp.setPrezzo(el.getPrezzo());
		temp.setQuantita(el.getQuantita());
		temp.setReparti(el.getReparti());
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public Elettronica cercaelettronicaperid(Elettronica el) {
		EntityManager entitymanager=x.apriconnessione();
		Elettronica temp=entitymanager.find(Elettronica.class, el.getId());
		return temp;
	}
	@Override
	public void inseriscibolla(BollaacquistoElettronica bolla) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.persist(bolla);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public List<Elettronica> prendilista() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Elettronica> query = entitymanager.createQuery("SELECT p FROM Elettronica p",Elettronica.class);
		List<Elettronica> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	}


}
