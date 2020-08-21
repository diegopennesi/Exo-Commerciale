package api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

		@POST
		@Path("/log-in")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response login(Account a) {
			System.out.println(a.getUsername()+" "+a.getPassword() );
			try {
			Account temp=ac.getAccount(a.getUsername(), a.getPassword());
			if (temp.getUsername().equals(a.getUsername()) && temp.getPassword().equals(a.getPassword())) {
				return Response.status(Response.Status.OK).entity(temp).build();
			}
			}catch(NullPointerException e) {
				return Response.status(204).entity(new Account()).build();
			}	
			
			return Response.status(Response.Status.BAD_REQUEST).entity("Account non trovato").build();
			}
			

}
