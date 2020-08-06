package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Abbigliamento;
import model.Alimentari;
import model.Elettronica;

@Path("/cliente")
public class ResrCliente {

	@GET
	@Path("/listareparti")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listareparti() {
		//reparti=ejb.getlistareparti
		//return Response.status(Response.Status.OK).entity(reparti).build() ;	
		return null;
	}
	@GET
	@Path("/listareparti/abbigliamento")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getabbigliamento() {
		//list<Abbigliamento> lista=ejb.getlistaabbigliamento
		//return Response.status(Response.Status.OK).entity(lista).build() ;	
		return null;
	}
	@GET
	@Path("/listareparti/alimentari")
	@Produces(MediaType.APPLICATION_JSON)
	public Response alimentari() {
		//list<alimentari> lista=ejb.getlistaalimentari
		//return Response.status(Response.Status.OK).entity(lista).build() ;	
		return null;
	}
	@GET
	@Path("/listareparti/elettronica")
	@Produces(MediaType.APPLICATION_JSON)
	public Response elettronica() {
		//list<elettronica> lista=ejb.getlistaelettronica
		//return Response.status(Response.Status.OK).entity(lista).build() ;	
		return null;
	}
	@POST
	@Path("/acqusita")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquista(HashMap<Integer,ArrayList> mappa) {
		for (Integer i : mappa.keySet())//cicla la mappa
			for (Object s : mappa.get(i))//cicliamo ogni reparto tutta la arraylist verifichiamo 
				if (s instanceof Alimentari) {
				//Alimento temp=ejb.cercastockalimentoperID(s)
				//if temp.getquantita=>s.getquantita
			       	//temp.setquantita(temp.getquantita-s.getquantita)
				    //flag=	
				}else if (s instanceof Alimentari) {

				}else if (s instanceof Elettronica) {

				}
		//e sono di numero sufficente all'acquisto totale e copiamo il risultato in una mappa speculare
		//SE non è disponibile flagghiamo come NON disponibile l'oggetto che faremo ritornare
		return null;



	}
	//vorrei fare una sola chiamata di acquisto
	@POST
	@Path("/acqusitaAlimento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaalimento(Alimentari oggetto) {
		//Alimento temp=ejb.cercastockalimentoperID(ogetto)
		//if temp.getquantita=>ogetto.getquantita
		//temp.setquantita(temp.getquantita-ogetto.getquantita)
		//ejb.modificaAlimentari(temp)
		//
		//return Response.status(Response.Status.OK).build() ;
		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
		return null;
	}
	@POST
	@Path("/acqusitaAlimento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaabbigliamento(Abbigliamento oggetto) {
		//Abbigliamento temp=ejb.cercastockabbigliamentoperID(ogetto)
		//if temp.getquantita=>ogetto.getquantita
		//temp.setquantita(temp.getquantita-ogetto.getquantita)
		//ejb.modificaAbbigliamento(temp)
		//return Response.status(Response.Status.OK).build() ;
		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
		return null;
	}
	@POST
	@Path("/acqusitaAlimento")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response acquistaElettronica(Elettronica oggetto) {
		//Elettronica temp=ejb.cercastockElettronicaperID(ogetto)
		//if temp.getquantita=>ogetto.getquantita
		//temp.setquantita(temp.getquantita-ogetto.getquantita)
		//ejb.modificaElettronica(temp)
		//return Response.status(Response.Status.OK).build() ;
		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
		return null;
	}

}
