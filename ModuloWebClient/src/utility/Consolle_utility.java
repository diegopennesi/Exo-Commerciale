package utility;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ejb_alimentariCrud.Ialimentari;
import model.Alimentari;
@Stateless
public class Consolle_utility {
@EJB
static
Ialimentari x;
	
	public static void main(String[] args) {
		Alimentari al= new Alimentari();
		x.inseriscialimento(al);
		

	}

}
