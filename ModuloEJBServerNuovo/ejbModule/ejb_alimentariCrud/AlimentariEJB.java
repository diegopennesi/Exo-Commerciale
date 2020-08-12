package ejb_alimentariCrud;


import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.Alimentari;
import model.BollaacquistoAlimenti;

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
	public Alimentari cercaalimentoperid(Alimentari al) {
		EntityManager entitymanager=x.apriconnessione();
		Alimentari temp=entitymanager.find(Alimentari.class, al.getId());
		return temp;
	}
	@Override
	public void inseriscibolla(BollaacquistoAlimenti bolla) {
		EntityManager entitymanager=x.apriconnessione();
		entitymanager.persist(bolla);
		x.chiudiconnessione(entitymanager);
	}
	@Override
	public List<Alimentari> prendiLista() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<Alimentari> query = entitymanager.createQuery("SELECT p FROM Alimentari p",Alimentari.class);
		List<Alimentari> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	}
	
	

}
