package ejb_utenteCrud;

import java.util.List;

import javax.ejb.Local;

import model.Utente;


@Local
public interface Iutenti {
	 public boolean inserisciutente(Utente ut);
	 public void cancellautente(Utente ut);
	 public void modificautente(Utente ut);
	 public Utente cercautenteperid(Utente ut);
	 public Utente cercautenteperid_account(int id_account);
	 public List<Utente> cercautenteperNome(Utente ut);
}
