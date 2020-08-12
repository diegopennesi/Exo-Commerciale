package ejb_alimentariCrud;

import java.util.List;

import javax.ejb.Local;
import model.Alimentari;
import model.BollaacquistoAlimenti;

@Local
public interface Ialimentari {
	
	public boolean inseriscialimento(Alimentari al);
	public void cancellaalimento(Alimentari al);
	public void modificaalimento(Alimentari al);
	public Alimentari cercaalimentoperid(Alimentari al);
	public List<Alimentari> prendiLista();
	public void inseriscibolla(BollaacquistoAlimenti bolla);
}
