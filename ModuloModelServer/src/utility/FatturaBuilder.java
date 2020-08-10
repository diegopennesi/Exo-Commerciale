package utility;

import javax.ejb.EJB;

import ejb_repartiCrud.Ireparti;
import model.Account;
import model.Alimentari;
import model.Fattura;
public class FatturaBuilder {
	@EJB
	Ireparti x;
	
	public Fattura fatturaBuilder(Account a,Object s,int id_scontrino,int iva) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(((Alimentari)s).getDescrizione());
		fattura.setQuantita(((Alimentari)s).getQuantita());
		fattura.setAccount(a);
		fattura.setPrezzo(((Alimentari)s).getPrezzo());
		fattura.setIva(iva);
		fattura.setListaReparti(x.prendiReparti());
		return fattura;
	}

}
