package api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import model.Abbigliamento;
import model.Alimentari;
import model.Elettronica;



@Path("/venditore")
public class RestImplementation {
	
	@GET
	@Path("/acqusita")
	@Produces(MediaType.APPLICATION_JSON)
	public Response scaricaMappa() {
	HashMap<Integer,ArrayList> mappa = new HashMap<Integer,ArrayList>();
	ArrayList<Abbigliamento> ab= new ArrayList<Abbigliamento>();
	ArrayList<Elettronica> el= new ArrayList<Elettronica>();
	ArrayList<Alimentari> al= new ArrayList<Alimentari>();
	mappa.put(1, ab);
	mappa.put(2, el);
	mappa.put(3, al);
	ab.add(new Abbigliamento("Cappello rosso","Unica","rosso","un semplice cappello rosso, resiste ai salti",5));
	ab.add(new Abbigliamento("Maglia Verde","XL","Verde","Una maglia verde, adatta all'avventura",3));
	ab.add(new Abbigliamento("Tuta blu","M","Blu","Una Salopette blu, per chi corre tra i palazzi e lancia limoni",2));
	//( ͡° ͜ʖ ͡°) fate voi per test altri oggetti nelle liste alimenti ed elettronica
	//qui ho fatto tornare un POJO strasformato in JSON in oggetto
	//possiamo usare il response.status per verificare se sei cliente o se sei Finanziere
	return Response.status(Response.Status.OK).entity(mappa).build() ;	
	}
	
	
	
	
	
	
	
	@POST
	@Path("/concludiacqusito")
	@Produces(MediaType.APPLICATION_JSON)
	public String acquistaStock(Object Stock) {//Entrerà un oggetto dello stock
		return null;	
	}
}
