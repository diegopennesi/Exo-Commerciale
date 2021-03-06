package ejb_fatturaCrud;

import java.util.List;

import javax.ejb.Local;

import model.Account;
import model.Fattura;
import model.Reparti;

@Local
public interface Ifattura {
	public boolean inseriscifattura(Fattura fa);
	//public void modificafattura(Fattura fa);//non so neanche se lo usiamo(?)
	public List<Fattura> cercafatturaperId(Fattura fa);
	public List<Fattura> cercafatturaperIdUtente(Account a);//tocca vedere se va bene
	public List<Fattura> cercafatturaperReparto(Reparti rp);
	public List<Fattura> scaricatuttefatture();
	public void cancellafattura(Fattura fa);
}
