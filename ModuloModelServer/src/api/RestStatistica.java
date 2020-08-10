package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ejb_bollaCrud.Ibolla;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;

@Path("/statistica")
public class RestStatistica {
	@EJB
	Ibolla x;
	
	@GET
	@Path("/acquisti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallacquisti() {
		List<BollaacquistoAlimenti> listalim=x.prendiListaBolleAlimenti();
		List<BollaacquistoElettronica> listaele=x.prendiListaBolleElettronica();
		List<BollaacquistoAbbigliamento> listaabb=x.prendiListaBolleAbbigliamento();
		HashMap<Integer,List> mappaAcquisti = new HashMap<Integer,List>();
		mappaAcquisti.put(1, listalim);
		return null;
	}
}
