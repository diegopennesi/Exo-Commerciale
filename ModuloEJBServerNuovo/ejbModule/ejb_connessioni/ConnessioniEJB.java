package ejb_connessioni;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Stateless
public class ConnessioniEJB implements Iconnessioni
{
	@Override
	public EntityManager apriconnessione() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpaServer");
		EntityManager entitymanager = emfactory.createEntityManager();
		//entitymanager.getTransaction().begin();
		return entitymanager;
	}
	@Override
	public void chiudiconnessione(EntityManager entitymanager) {
//		entitymanager.getTransaction().commit();
//		entitymanager.clear();
		entitymanager.close();
	}
}
