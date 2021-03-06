package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import model.Abbigliamento;
import model.Alimentari;
import model.BollaacquistoAbbigliamento;
import model.BollaacquistoAlimenti;
import model.BollaacquistoElettronica;
import model.Elettronica;

public class BollaBuilder {
//vorrei per� ottimizzare facendo un solo metodo, ma lo faremo dopo	
	public BollaacquistoAbbigliamento BollaAbb_Builder(BollaacquistoAbbigliamento bolla, Object stock,String fornitore) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		bolla.setNomeFV(fornitore);
		bolla.setCodiceAcquisto(1l + (long) (Math.random() * (100000000L - 1L)));	
		bolla.setDataAcquisto(simpleDateFormat.format(calendar.getTime()));
		bolla.setStock(String.valueOf(((Abbigliamento) stock).getQuantita()) + " "+ ((Abbigliamento) stock).getNome());
		bolla.setPrTotale(((Abbigliamento) stock).getPrezzo());
		double temp=(double)((Abbigliamento) stock).getPrezzo()/((Abbigliamento) stock).getQuantita();
		bolla.setPrUnitario(((double)Math.round(temp*100)/100));
		bolla.setAbbigliamento((Abbigliamento)stock);
		return bolla;	
	}
	public BollaacquistoAlimenti BollaAli_Builder(BollaacquistoAlimenti bolla, Object stock,String fornitore) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		bolla.setNomeFV(fornitore);
		bolla.setCodiceAcquisto(1l + (long) (Math.random() * (100000000L - 1L)));	
		bolla.setDataAcquisto(simpleDateFormat.format(calendar.getTime()));
		bolla.setStock(String.valueOf(((Alimentari) stock).getQuantita()) + " "+ ((Alimentari) stock).getNome());
		bolla.setPrTotale(((Alimentari) stock).getPrezzo());
		double temp=(double)((Alimentari) stock).getPrezzo()/((Alimentari) stock).getQuantita();
		bolla.setPrUnitario(((double)Math.round(temp*100)/100));
		bolla.setAlimenti((Alimentari) stock);
		return bolla;	
	}
	public BollaacquistoElettronica BollaEle_Builder(BollaacquistoElettronica bolla, Object stock,String fornitore) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		bolla.setNomeFV(fornitore);
		bolla.setCodiceAcquisto(1l + (long) (Math.random() * (100000000L - 1L)));	
		bolla.setDataAcquisto(simpleDateFormat.format(calendar.getTime()));
		bolla.setStock(String.valueOf(((Elettronica) stock).getQuantita()) + " "+ ((Elettronica) stock).getNome());
		bolla.setPrTotale(((Elettronica) stock).getPrezzo());
		double temp=(double)((Elettronica) stock).getPrezzo()/((Elettronica) stock).getQuantita();
		bolla.setPrUnitario(((double)Math.round(temp*100)/100));
		bolla.setElettronica((Elettronica) stock);
		return bolla;	
	}

	
	
}