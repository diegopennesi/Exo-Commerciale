package api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import model.Abbigliamento;
import model.Alimentari;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.Elettronica;
import model.Reparti;
import utility.BollaBuilder;
import utility.Venditore;



@Path("/venditore")
public class RestImplementation {
	
	@GET
	@Path("/acqusita")
	@Produces(MediaType.APPLICATION_JSON)
	public Response scaricaMappa() {
	HashMap<Integer,ArrayList> mappa = Venditore.getIstance().getLista();
	return Response.status(Response.Status.OK).entity(mappa).build() ;	
	}

	@POST
	@Path("/concludiacqusito")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String acquistaStock(Object stock,Reparti reparti) {//Entrerà un oggetto dello stock
		if(stock instanceof Alimentari) {
			
		}
		else if(stock instanceof Abbigliamento){
			BollaacquistoAbbigliamento boAb= new BollaacquistoAbbigliamento();
			BollaBuilder builder = new BollaBuilder();
			boAb=builder.BollaAbb_Builder(boAb, stock, "test");
			//EJB.INSERISCIBOLLA
			((Abbigliamento) stock).setBollaAcquisto(boAb);
			//EJB.INSERISCISTOCK
		}
		else if(stock instanceof Elettronica) {
			
		}
		return null;	
	}
}
