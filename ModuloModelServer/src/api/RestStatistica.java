package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ejb_bollaCrud.Ibolla;
import ejb_fatturaCrud.Ifattura;
import ejb_repartiCrud.Ireparti;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;
import model.Fattura;
import model.Reparti;

@Path("/statistica")
public class RestStatistica {
	@EJB
	Ibolla x;
	@EJB
	Ifattura f;
	@EJB
	Ireparti y;
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public void test() {
		System.out.println("funziona");
		
	}
	@GET
	@Path("/reparti/{id}")//per test sticazzi
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallreparti(@PathParam("id") int id) {
		Reparti temp=y.prendiRepartiperID(id);
		return Response.status(Response.Status.OK).entity(temp).build();
		
	}
	@GET
	@Path("/acquisti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getallacquisti() {// :D non ricordo quale sia la corretta Lista LIFO ¯\_(ツ)_/¯
		List<BollaacquistoAlimenti> listalim=x.prendiListaBolleAlimenti();
		List<BollaacquistoElettronica> listaele=x.prendiListaBolleElettronica();
		List<BollaacquistoAbbigliamento> listaabb=x.prendiListaBolleAbbigliamento();
		HashMap<Integer,List> mappaAcquisti = new HashMap<Integer,List>();
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
		List<BollaacquistoAlimenti> lista=x.prendiListaBolleAlimenti();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiAbbigliamento() {
	    List<BollaacquistoAbbigliamento>lista=x.prendiListaBolleAbbigliamento();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	@GET
	@Path("/acquistiElettronica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getacquistiElettronica() { 
		List<BollaacquistoElettronica>lista=x.prendiListaBolleElettronica();
		Collections.reverse(lista);
		return Response.status(Response.Status.OK).entity(lista).build();
	}
	///i return dei PLUS tra vendita e acquisto attuale
	@GET
	@Path("/fatturatoAlimentari")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoAlimentari() {
		List<BollaacquistoAlimenti> lista=x.prendiListaBolleAlimenti();
		double costo=00.00;
		double lordo=00.00;
		for (BollaacquistoAlimenti o:lista) {
			costo=costo+o.getPrTotale();
		}
		List<Fattura> fatturealimenti=f.scaricatuttefatture();
		for (Fattura o:fatturealimenti) {
			if(o.getReparti().getId()==2)lordo=lordo+o.getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
	@GET
	@Path("/fatturatoAbbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoAbbigliamento() {
		List<BollaacquistoAbbigliamento> lista=x.prendiListaBolleAbbigliamento();
		double costo=00.00;
		double lordo=00.00;
		for (BollaacquistoAbbigliamento o:lista) {
			costo=costo+o.getPrTotale();
		}
		List<Fattura> fatturealimenti=f.scaricatuttefatture();
		for (Fattura o:fatturealimenti) {
			if(o.getReparti().getId()==1)lordo=lordo+o.getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
	@GET
	@Path("/fatturatoElettronica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getfatturatoElettronica() {
		List<BollaacquistoElettronica> lista=x.prendiListaBolleElettronica();
		double costo=00.00;
		double lordo=00.00;	
		for (BollaacquistoElettronica o:lista) {
			costo=costo+o.getPrTotale();
		}
		List<Fattura> fatturealimenti=f.scaricatuttefatture();
		for (Fattura o:fatturealimenti) {
			if(o.getReparti().getId()==3)lordo=lordo+o.getPrezzo();
		}
		double fatturatonetto= (double) (lordo - costo); 
		return Response.status(Response.Status.OK).entity(fatturatonetto).build();
	}
}
