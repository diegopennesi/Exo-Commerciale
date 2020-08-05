package ejb_utenteCrud;

import java.util.List;

import javax.ejb.Local;

import model.Utente;


@Local
public interface Iutenti {
	 public boolean inserisciutente(Utente ut);
	 public void cancellautente(Utente ut);
	 public void modificautente(Utente ut);
	 public List cercautenteperNome(Utente ut);
}
