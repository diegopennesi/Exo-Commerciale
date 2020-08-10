package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ejb_bollaCrud.Ibolla;
import ejb_fatturaCrud.Ifattura;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;
import model.Fattura;

@Path("/statistica")
public class RestStatistica {
	@EJB
	Ibolla x;
	@EJB
	Ifattura f;
	
	@GET
	@Path("/acquisti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallacquisti() {// :D non ricordo quale sia la corretta Lista LIFO ¯\_(ツ)_/¯
		ArrayList<BollaacquistoAlimenti> listalim=x.prendiListaBolleAlimenti();
		ArrayList<BollaacquistoElettronica> listaele=x.prendiListaBolleElettronica();
		ArrayList<BollaacquistoAbbigliamento> listaabb=x.prendiListaBolleAbbigliamento();
		HashMap<Integer,ArrayList> mappaAcquisti = new HashMap<Integer,ArrayList>();
		Collections.reverse(listalim);
		Collections.reverse(listaele);
		Collections.reverse(listaabb);
		mappaAcquisti.put(1, listalim);
		mappaAcquisti.put(2, listaele);
		mappaAcquisti.put(3, listaabb);
		return Response.status(Response.Status.OK).entity(mappaAcquisti).build();
	}
	///i return dei 3 BolleReparti singolarmente
	@GET
	@Path("/acquistiAlimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiAlimenti() {
		ArrayList<BollaacquistoAlimenti> lista=x.prendiListaBolleAlimenti();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiAbbigliamento() {
		ArrayList<BollaacquistoAbbigliamento>lista=x.prendiListaBolleAbbigliamento();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiElettronica() {
		ArrayList<BollaacquistoElettronica>lista=x.prendiListaBolleElettronica();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	///i return dei PLUS tra vendita e acquisto attuale
	@GET
	@Path("/fatturatoAlimentari")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoAlimentari() {
		ArrayList<BollaacquistoAlimenti> lista=x.prendiListaBolleAlimenti();
		double costo=00.00;
		double lordo=00.00;
		for (Object o:lista) {
			costo=costo+((BollaacquistoAlimenti)o).getPrTotale();
		}
		ArrayList<Fattura> fatturealimenti=(ArrayList<Fattura>) f.cercafatturaperReparto(1);
		for (Object o:fatturealimenti) {
			lordo=lordo+((Fattura)o).getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
	@GET
	@Path("/fatturatoAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoAbbigliamento() {
		ArrayList<BollaacquistoAbbigliamento> lista=x.prendiListaBolleAbbigliamento();
		double costo=00.00;
		double lordo=00.00;
		for (Object o:lista) {
			costo=costo+((BollaacquistoAbbigliamento)o).getPrTotale();
		}
		ArrayList<Fattura> fatturealimenti=(ArrayList<Fattura>) f.cercafatturaperReparto(2);
		for (Object o:fatturealimenti) {
			lordo=lordo+((Fattura)o).getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
	@GET
	@Path("/fatturatoAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoElettronica() {
		ArrayList<BollaacquistoElettronica> lista=x.prendiListaBolleElettronica();
		double costo=00.00;
		double lordo=00.00;
		for (Object o:lista) {
			costo=costo+((BollaacquistoElettronica)o).getPrTotale();
		}
		ArrayList<Fattura> fatturealimenti=(ArrayList<Fattura>) f.cercafatturaperReparto(3);
		for (Object o:fatturealimenti) {
			lordo=lordo+((Fattura)o).getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
}
