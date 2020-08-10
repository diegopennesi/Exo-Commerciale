package utility;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import model.Account;
import model.Alimentari;
public class Log {
	
	public void loggerlogin(Account a) {
		Logger logger = Logger.getLogger("MyLog");  
		FileHandler fh;
		try {
			fh = new FileHandler("C:\\Users\\Diego\\eclipse-workspace\\Exo-Commerciale\\ModuloModelServer\\LOG",true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);
			logger.info(a.getUsername() + "si è loggato");	
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loggerlogOff(Account a) {
		Logger logger = Logger.getLogger("MyLog");  
		FileHandler fh;
		try {
			fh = new FileHandler("C:\\Users\\Diego\\eclipse-workspace\\Exo-Commerciale\\ModuloModelServer\\LOG",true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);
			logger.info(a.getUsername() + "si è Sloggato");	
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void acquisto(Account a, Object Stock) {
		Logger logger = Logger.getLogger("logVendita");  
		FileHandler fh;
		try {
			fh = new FileHandler("C:\\Users\\Diego\\eclipse-workspace\\Exo-Commerciale\\ModuloModelServer\\LOG",true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);
			logger.info(a.getUsername()+" " + "ha acquistato"+" "+((Alimentari)Stock).getQuantita()+" "+ ((Alimentari)Stock).getNome());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
