package ejb_utenteCrud;

import java.util.List;

import javax.ejb.Local;

import model.Utente;


@Local
public interface Iutenti {
	 public boolean inserisciutente();
	 public void cancellautente(Utente ut);
	 public void modificautente(Utente ut);
	 public List cercautente(Utente ut);
}
