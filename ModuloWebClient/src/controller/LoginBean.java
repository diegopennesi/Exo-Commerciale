package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.google.gson.Gson;
import model.Account;
import utility.Universal_HTTPREQUEST;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginbean",eager=true)
@RequestScoped
public class LoginBean implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 6146784484686975074L;
    public LoginBean() {
    }
	@ManagedProperty("#{utentebean}")
	private UtenteBean utentebean;
	@PostConstruct
	public void init() {
		
	}
    private Account account = new Account();

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    
    public UtenteBean getUtentebean() {
		return utentebean;
	}
	public void setUtentebean(UtenteBean utentebean) {
		this.utentebean = utentebean;
	}
	public String logIn() throws IOException {
        Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();
        FacesContext context =  FacesContext.getCurrentInstance();
        String percorso= "http://localhost:8080/ModuloWebClientNuovo/rest/login/log-in";
        Gson g = new Gson();
        context.getExternalContext().getSessionMap().put("account",account);
        String out=g.toJson(account, Account.class);
        HttpURLConnection con = httprequest.HTTPSENDJSON(percorso, out,"POST");
        String result=httprequest.HTTPREADJSON(con);
        account=g.fromJson(result, Account.class);
        con.getErrorStream();
        utentebean.setAc(account);
        if(con.getResponseCode()==204) {
            con.disconnect();
            return "registrazione";
        }else  if (con.getResponseCode()!=200) {
            throw new RuntimeException("Failed : HTTP error code : "
                        + con.getResponseCode());
        }else {

        return "account";
        }
        }
    }
