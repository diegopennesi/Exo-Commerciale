package ejb_accountcrud;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ejb_connessioni.Iconnessioni;
import model.Account;

@Stateless
public class AccountEJB implements IAccountCrud {

	@EJB
	Iconnessioni x;
	
	@Override
	public Account getAccount(String username,String password) {
		EntityManager entityManager=x.apriconnessione();
		try {
			
		Account account= (Account)  entityManager.createQuery("select a from Account a where a.username=:username and a.password=:password",Account.class)
				.setParameter("username", username).setParameter("password", password);
		return account;
		}catch (NoResultException e) {
			return null;
		}
	}
	
	public Account getAccountById(int id) {
		EntityManager entityManager = x.apriconnessione();
		Account account=entityManager.find(Account.class, id);
		return account;
	}

	public void updateAccount(Account account) {
		EntityManager entityManager=x.apriconnessione();
		entityManager.merge(account);
		x.chiudiconnessione(entityManager);
	}
	
	public void deleteAccount(int id) {
		EntityManager entityManager = x.apriconnessione();
		Account account= entityManager.find(Account.class, id);
		entityManager.remove(account);
		x.chiudiconnessione(entityManager);
	}
	
}
