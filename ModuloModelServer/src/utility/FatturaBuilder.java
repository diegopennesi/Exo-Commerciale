package utility;

import model.Account;
import model.Alimentari;
import model.Fattura;
import model.Reparti;

public class FatturaBuilder {
	
	public void FatturaBuilder(Account a,Object s,int id_scontrino,int iva,Reparti rep) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(((Alimentari)s).getDescrizione());
		fattura.setQuantita(((Alimentari)s).getQuantita());
		fattura.setAccount(a);
		fattura.setPrezzo(((Alimentari)s).getPrezzo());
		fattura.setIva(iva);
		fattura.setListaReparti(rep);
	}

}
