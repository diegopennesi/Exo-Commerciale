package ejb_repartiCrud;

import java.util.List;
import javax.ejb.Local;
import model.Reparti;

@Local
public interface Ireparti {
	public List<Reparti> prendiReparti();
}
