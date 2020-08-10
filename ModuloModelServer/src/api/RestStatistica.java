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
		ArrayList<BollaacquistoAlimenti> listalim=x.prendiListaBolleAlimenti();
		ArrayList<BollaacquistoElettronica> listaele=x.prendiListaBolleElettronica();
		ArrayList<BollaacquistoAbbigliamento> listaabb=x.prendiListaBolleAbbigliamento();
		HashMap<Integer,ArrayList> mappaAcquisti = new HashMap<Integer,ArrayList>();
		mappaAcquisti.put(1, listalim);
		mappaAcquisti.put(2, listaele);
		mappaAcquisti.put(3, listaabb);
		return Response.status(Response.Status.OK).entity(mappaAcquisti).build();
	}
	///i return dei 3 reparti singolarmente
	@GET
	@Path("/acquistiAlimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiAlimenti() {
		ArrayList<BollaacquistoAlimenti> lista=x.prendiListaBolleAlimenti();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiAbbigliamento() {
		ArrayList<BollaacquistoAbbigliamento>lista=x.prendiListaBolleAbbigliamento();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiElettronica() {
		ArrayList<BollaacquistoElettronica>lista=x.prendiListaBolleElettronica();
		return Response.status(Response.Status.OK).entity(lista).build();
	}
}
