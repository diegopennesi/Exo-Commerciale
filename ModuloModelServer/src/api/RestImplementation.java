package api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Abbigliamento;
import model.Alimentari;
import model.Elettronica;



@Path("/venditore")
public class RestImplementation {
	
	@GET
	@Path("/acqusita")
	@Produces(MediaType.APPLICATION_JSON)
	public String scaricaMappa() {
	HashMap<Integer,ArrayList> mappa = new HashMap<Integer,ArrayList>();
	ArrayList<Abbigliamento> ab= new ArrayList<Abbigliamento>();
	ArrayList<Elettronica> el= new ArrayList<Elettronica>();
	ArrayList<Alimentari> al= new ArrayList<Alimentari>();

		
		return null;	
	}
	
	
	
	
	
	
	
	@POST
	@Path("/concludiacqusito")
	@Produces(MediaType.APPLICATION_JSON)
	public String acquistaStock(Object Stock) {//Entrerà un oggetto dello stock
		return null;	
	}
}
