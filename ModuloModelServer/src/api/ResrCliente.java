package api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Abbigliamento;
import model.Alimentari;
import utility.Venditore;

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
	public Response acquistaabbigliamento(Abbigliamento oggetto) {
		//Abbigliamento temp=ejb.cercastockabbigliamentoperID(ogetto)
		//if temp.getquantita=>ogetto.getquantita
		//temp.setquantita(temp.getquantita-ogetto.getquantita)
		//ejb.modificaAbbigliamento(temp)
		//return Response.status(Response.Status.OK).build() ;
		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
		return null;
	}

}
