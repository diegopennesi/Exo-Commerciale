package api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb_alimentariCrud.Ialimentari;
import model.Abbigliamento;
import model.Alimentari;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;
import model.Elettronica;
import model.Reparti;
import utility.BollaBuilder;
import utility.Venditore;



@Path("/venditore")
public class RestVenditore {
	
	@EJB
	Ialimentari al;
	
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
			BollaacquistoAlimenti boAa= new BollaacquistoAlimenti();
			BollaBuilder builder = new BollaBuilder();
			boAa=builder.BollaAli_Builder(boAa, stock, "fornitore");
			al.inseriscibolla(boAa);
			((Alimentari) stock).setBollaAcquisto(boAa);
			al.inseriscialimento((Alimentari)stock);
		}
		else if(stock instanceof Abbigliamento){
			BollaacquistoAbbigliamento boAb= new BollaacquistoAbbigliamento();
			BollaBuilder builder = new BollaBuilder();
			boAb=builder.BollaAbb_Builder(boAb, stock, "fornitore");
			//EJB.INSERISCIBOLLA
			((Abbigliamento) stock).setBollaAcquisto(boAb);
			//EJB.INSERISCISTOCK
		}
		else if(stock instanceof Elettronica) {
			BollaacquistoElettronica boAe= new BollaacquistoElettronica();
			BollaBuilder builder = new BollaBuilder();
			boAe=builder.BollaEle_Builder(boAe, stock, "fornitore");
			//EJB.INSERISCIBOLLA
			((Elettronica) stock).setBollaAcquisto(boAe);
			//EJB.INSERISCISTOCK
		}
		return null;	
	}
}
