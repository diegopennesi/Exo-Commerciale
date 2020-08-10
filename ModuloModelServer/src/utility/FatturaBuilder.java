package utility;

import model.Account;
import model.Alimentari;
import model.Fattura;

public class FatturaBuilder {
	
	public void FatturaBuilder(Account a,Object s,int id_scontrino) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(((Alimentari)s).getDescrizione());
		fattura.setQuantita(((Alimentari)s).getQuantita());
		fattura.setAccount(a);
	}

}
