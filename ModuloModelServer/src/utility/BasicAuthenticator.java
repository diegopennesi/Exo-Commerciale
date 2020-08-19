package utility;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import model.Account;

public final class BasicAuthenticator extends Authenticator {
	
	protected PasswordAuthentication getPasswordAuthentication() {
		Account a = new Account();
		return new PasswordAuthentication(a.getUsername(), a.getPassword().toCharArray());
	}
}
