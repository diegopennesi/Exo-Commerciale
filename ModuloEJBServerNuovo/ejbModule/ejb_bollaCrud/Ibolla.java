package ejb_bollaCrud;

import java.util.ArrayList;


import javax.ejb.Local;

import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;


@Local
public interface Ibolla {
	public ArrayList<BollaacquistoAlimenti> prendiListaBolleAlimenti();
	public ArrayList<BollaacquistoAbbigliamento> prendiListaBolleAbbigliamento();
	public ArrayList<BollaacquistoElettronica> prendiListaBolleElettronica();
}
