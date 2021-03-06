package ejb_bollaCrud;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ejb_connessioni.Iconnessioni;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;


@Stateless
public class BollaCRUD implements Ibolla {
	@EJB
	Iconnessioni x;

	@Override
	public List<BollaacquistoAlimenti> prendiListaBolleAlimenti() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<BollaacquistoAlimenti> query = entitymanager.createQuery("SELECT p FROM BollaacquistoAlimenti p",BollaacquistoAlimenti.class);
		List<BollaacquistoAlimenti> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;

	}

	@Override
	public List<BollaacquistoAbbigliamento> prendiListaBolleAbbigliamento() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<BollaacquistoAbbigliamento> query = entitymanager.createQuery("SELECT p FROM BollaacquistoAbbigliamento p",BollaacquistoAbbigliamento.class);
		List<BollaacquistoAbbigliamento> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	}

	@Override
	public List<BollaacquistoElettronica> prendiListaBolleElettronica() {
		EntityManager entitymanager=x.apriconnessione();
		TypedQuery<BollaacquistoElettronica> query = entitymanager.createQuery("SELECT p FROM BollaacquistoElettronica p",BollaacquistoElettronica.class);
		List<BollaacquistoElettronica> lista = query.getResultList();
		x.chiudiconnessione(entitymanager);
		return lista;
	
	}

}
