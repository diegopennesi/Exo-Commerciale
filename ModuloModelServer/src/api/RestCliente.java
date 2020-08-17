package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb_abbigliamentoCrud.Iabbigliamento;
import ejb_accountcrud.IAccountCrud;
import ejb_alimentariCrud.Ialimentari;
import ejb_connessioni.Iconnessioni;
import ejb_elettronicaCrud.Ielettronica;
import ejb_fatturaCrud.Ifattura;
import ejb_utenteCrud.IutenteDTO;
import ejb_utenteCrud.Iutenti;
import model.Abbigliamento;
import model.Account;
import model.Alimentari;
import model.Elettronica;
import model.Fattura;
import model.Utente;
import modelDTO.UtenteDTO;
import utility.FatturaBuilder;
import utility.Log;

@Path("/clientela")
public class RestCliente {
	@EJB
	Ialimentari al;
	@EJB
	Iabbigliamento ab;
	@EJB
	Ielettronica el;
	@EJB
	Ifattura fa;
	@EJB
	IAccountCrud ac;
	@EJB
	Iutenti ut;
	@EJB
	IutenteDTO Idto;


	@GET
	@Path("test")
	@Produces(MediaType.APPLICATION_JSON)
	public void test() {
		System.out.println("funziona");

	}

		@GET
		@Path("/InserisciAccount")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response inserisciProfilo(Account a) {
		    ac.inserisciAccount(a);
			return Response.status(Response.Status.OK).entity(a).build() ;
		}

	@PUT
	@Path("/InserisciUtente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response creaUtente(UtenteDTO utenteDTO) {
		Utente utente= new Utente();
		utente=Idto.DtoTOUtente(utenteDTO);
		ut.inserisciutente(utente);
		return Response.status(Response.Status.OK).build() ;
	}

	
	@GET
	@Path("prendiutente/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cercautente(@PathParam("id") int id) {
		Utente temp = new Utente();
		temp.setId(id);
		temp=ut.cercautenteperid(temp);
		return Response.status(200).entity(temp).build() ;
	}
	@GET
	@Path("prendiaccount/{id}")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cercaaccount(@PathParam("id") int id) {
		Account temp=new Account();
		temp=ac.getAccountById(id);
		return Response.status(200).entity(temp).build() ;
	}
	//	
	//	@GET
	//	@Path("/listareparti/abbigliamento")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response getabbigliamento() {
	//		List<Abbigliamento> lista=ab.prendiLista();
	//		return Response.status(Response.Status.OK).entity(lista).build() ;	
	//	}
	//	@GET
	//	@Path("/listareparti/alimentari")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response alimentari() {
	//		List<Alimentari> lista=al.prendiLista();
	//		return Response.status(Response.Status.OK).entity(lista).build() ;	
	//	}
	//	@GET
	//	@Path("/listareparti/elettronica")
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response elettronica() {
	//		List<Elettronica> lista=el.prendilista();
	//		return Response.status(Response.Status.OK).entity(lista).build() ;		
	//	}
	//	
	//	@POST
	//	@Path("/acqusita")
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response acquista(HashMap<Integer,ArrayList> mappa,Account acco) {
	//		boolean flag=true;
	//		Log log=new Log();
	//		for (Integer i : mappa.keySet()) {//cicla la mappa
	//			for (Object s : mappa.get(i)) {//cicliamo ogni reparto tutta la arraylist verifichiamo 
	//				if (s instanceof Alimentari) {
	//					Alimentari temp=al.cercaalimentoperid((Alimentari)s);
	//					if (temp.getQuantita()>=((Alimentari)s).getQuantita()) {
	//					}else {
	//						flag = false;
	//						((Alimentari) s).setDisponibilita(false);	
	//					}
	//				}else if (s instanceof Abbigliamento) {
	//					Abbigliamento temp=ab.cercaabbigliamentoperid((Abbigliamento) s);
	//					if(temp.getQuantita()>=((Abbigliamento)s).getQuantita()) {
	//					}else {
	//						flag = false;
	//						((Abbigliamento) s).setDisponibilita(false);
	//					}
	//				}else if (s instanceof Elettronica) {
	//					Elettronica temp=el.cercaelettronicaperid((Elettronica) s);
	//					if (temp.getQuantita()>=((Elettronica)s).getQuantita()) {
	//					}else {
	//						flag = false;
	//						((Elettronica) s).setDisponibilita(false);	
	//					}
	//				}
	//			}
	//		}
	//		if (flag == false) {//facciamo tornare la mappa con alcuni oggetti non disponibili per farli togliere dal front
	//			return Response.status(Response.Status.BAD_REQUEST).entity(mappa).build();
	//		}else if (flag == true) {
	//			int id_scontrino=1 + (int) (Math.random() * (5L - 1L));
	//			for (Integer i : mappa.keySet()) {//cicla la mappa
	//				for (Object s : mappa.get(i)) {
	//					if (s instanceof Alimentari) {
	//						Alimentari temp=al.cercaalimentoperid((Alimentari)s);
	//						if (temp.getQuantita()>=((Alimentari)s).getQuantita()) {
	//							al.modificaalimento((Alimentari) s);
	//							fa.inseriscifattura(new FatturaBuilder().fatturaBuilder(acco, s, id_scontrino, 10));
	//							log.acquisto(acco, s);
	//						}
	//					}else if (s instanceof Abbigliamento) {
	//						Abbigliamento temp=ab.cercaabbigliamentoperid((Abbigliamento) s);
	//						if(temp.getQuantita()>=((Abbigliamento)s).getQuantita()) {
	//							ab.modificaabbigliamento((Abbigliamento) s);
	//							fa.inseriscifattura(new FatturaBuilder().fatturaBuilder(acco, s, id_scontrino, 22));
	//							log.acquisto(acco, s);
	//						}
	//					}else if (s instanceof Elettronica) {
	//						Elettronica temp=el.cercaelettronicaperid((Elettronica) s);
	//						if (temp.getQuantita()>=((Elettronica)s).getQuantita()) {
	//							el.modificaelettronica((Elettronica) s);
	//							fa.inseriscifattura(new FatturaBuilder().fatturaBuilder(acco, s, id_scontrino, 22));
	//							log.acquisto(acco, s);
	//						}
	//					}
	//				}
	//			}
	//		}
	//		return Response.status(Response.Status.OK).entity("Acquisti eseguiti con successo").build();
	//	}
	////	@POST
	////	@Path("/acqusitaAlimento")
	////	@Consumes(MediaType.APPLICATION_JSON)
	////	@Produces(MediaType.APPLICATION_JSON)
	////	public Response acquistaalimento(Alimentari oggetto) {
	////		//Alimento temp=ejb.cercastockalimentoperID(ogetto)
	////		//if temp.getquantita=>ogetto.getquantita
	////		//temp.setquantita(temp.getquantita-ogetto.getquantita)
	////		//ejb.modificaAlimentari(temp)
	////		//
	////		//return Response.status(Response.Status.OK).build() ;
	////		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
	////		return null;
	////	}
	////	@POST
	////	@Path("/acqusitaAlimento")
	////	@Consumes(MediaType.APPLICATION_JSON)
	////	@Produces(MediaType.APPLICATION_JSON)
	////	public Response acquistaabbigliamento(Abbigliamento oggetto) {
	////		//Abbigliamento temp=ejb.cercastockabbigliamentoperID(ogetto)
	////		//if temp.getquantita=>ogetto.getquantita
	////		//temp.setquantita(temp.getquantita-ogetto.getquantita)
	////		//ejb.modificaAbbigliamento(temp)
	////		//return Response.status(Response.Status.OK).build() ;
	////		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
	////		return null;
	////	}
	////	@POST
	////	@Path("/acqusitaAlimento")
	////	@Consumes(MediaType.APPLICATION_JSON)
	////	@Produces(MediaType.APPLICATION_JSON)
	////	public Response acquistaElettronica(Elettronica oggetto) {
	////		//Elettronica temp=ejb.cercastockElettronicaperID(ogetto)
	////		//if temp.getquantita=>ogetto.getquantita
	////		//temp.setquantita(temp.getquantita-ogetto.getquantita)
	////		//ejb.modificaElettronica(temp)
	////		//return Response.status(Response.Status.OK).build() ;
	////		//return Response.status(Response.Status.REQUESTED_RANGE_NOT_SATISFIABLE).entity("non abbastanza stok").build();
	////		return null;
	////	}
	////
	//	@POST
	//	@Path("/aggiungifondi")
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	@Produces(MediaType.APPLICATION_JSON)
	//	public Response acquistacredito(Account a) {
	//		Account temp = ac.getAccount(a.getUsername(), a.getPassword());
	//		temp.setPortafoglio(a.getPortafoglio());
	//		ac.updateAccount(a);
	//		return Response.status(Response.Status.OK).entity("Saldo aggiornato con successo").build();
	//	}
	//	@GET
	//	@Path("/login")
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response login(Account a) {
	//		Account temp=ac.getAccount(a.getUsername(), a.getPassword());
	//		if (temp.getUsername().equals(a.getUsername()) && temp.getPassword().equals(a.getPassword())) {
	//			Log log = new Log();
	//			log.loggerlogin(a);
	//			return Response.status(Response.Status.OK).entity(temp).build();
	//		}
	//		return Response.status(Response.Status.BAD_REQUEST).entity("Account non trovato").build();
	//	}
	//	@GET
	//	@Path("/tuttiacquistiutente")
	//	@Consumes(MediaType.APPLICATION_JSON)
	//	public Response tuttiacquistiutente(Account a) {
	//		List<Fattura> lista=fa.cercafatturaperIdUtente(a);
	//		Collections.reverse(lista);
	//		return Response.status(Response.Status.OK).entity(lista).build();
	//	}

}
