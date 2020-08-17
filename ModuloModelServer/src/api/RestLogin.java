package api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ejb_accountcrud.IAccountCrud;
import model.Account;

@Path("/login")
public class RestLogin {
	
	@EJB
	IAccountCrud ac;
	
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Account account) {
		if(ac.getAccount(account.getUsername(), account.getPassword())!= null) {
			return Response.status(Response.Status.OK).entity(account).build() ;
		}
		else {
			return Response.status(Response.Status.FORBIDDEN).build() ;
		}
	}
	
	

}
