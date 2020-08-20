package api;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb_abbigliamentoCrud.Iabbigliamento;
import ejb_alimentariCrud.Ialimentari;
import ejb_elettronicaCrud.Ielettronica;
import ejb_repartiCrud.Ireparti;
import model.Abbigliamento;
import model.Alimentari;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;
import model.Elettronica;
import utility.BollaBuilder;
import utility.Venditore;



@Path("/venditore")
public class RestVenditore {
	
	
	@EJB
	Ialimentari al;
	@EJB
	Iabbigliamento ab;
	@EJB
	Ielettronica el;
	@EJB
	Ireparti rep;
	
	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public void test() {
		System.out.println("funziona");
		
	}
	@GET
	@Path("/acqusita")
	@Produces(MediaType.APPLICATION_JSON)
	public Response scaricaMappa() {
	HashMap<Integer,ArrayList> mappa = Venditore.getIstance().getLista();
	return Response.status(Response.Status.OK).entity(mappa).build() ;	
	}
	@GET
	@Path("/concludiacquistoAbbigliamento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaStock(Abbigliamento stock) {
		BollaacquistoAbbigliamento boAb= new BollaacquistoAbbigliamento();
		BollaBuilder builder = new BollaBuilder();
		stock.setReparti(rep.prendiRepartiperID(1));
		boAb=builder.BollaAbb_Builder(boAb, stock, "M.A.S.");
		double temp=(double)boAb.getPrUnitario()*1.81;//1.81 valore empirico di "guadagno" la fumetteria dove 
		stock.setPrezzo((double)Math.round(temp*100)/100); //bazzico dice che usa questo numero per calcolare 
		ab.inserisciabbigliamento(stock);					//il guadagano gia con iva calcolata
		ab.inseriscibolla(boAb);
		return Response.status(Response.Status.OK).build() ;
	}
	@GET
	@Path("/concludiacquistoAlimentari")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaStock(Alimentari stock) {
		BollaacquistoAlimenti boAA= new BollaacquistoAlimenti();
		BollaBuilder builder = new BollaBuilder();
		stock.setReparti(rep.prendiRepartiperID(2));
		boAA=builder.BollaAli_Builder(boAA, stock, "GRos");
		double temp=(double)boAA.getPrUnitario()*1.81;
		stock.setPrezzo((double)Math.round(temp*100)/100);
		al.inseriscialimento(stock);
		al.inseriscibolla(boAA);
		return Response.status(Response.Status.OK).build() ;
	}
	@GET
	@Path("/concludiacquistoElettronica")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaStock(Elettronica stock) {
		BollaacquistoElettronica boEl= new BollaacquistoElettronica();
		BollaBuilder builder = new BollaBuilder();
		stock.setReparti(rep.prendiRepartiperID(3));
		boEl=builder.BollaEle_Builder(boEl, stock, "SiliconValleySupermaket");
		double temp=(double)boEl.getPrUnitario()*1.81;
		stock.setPrezzo((double)Math.round(temp*100)/100);
		el.inseriscielettronica(stock);
		el.inseriscibolla(boEl);
		return Response.status(Response.Status.OK).build() ;
	}
}
