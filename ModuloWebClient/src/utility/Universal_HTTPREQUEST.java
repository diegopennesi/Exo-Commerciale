
	package utility;

	import java.io.BufferedInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.net.HttpURLConnection;
	import java.net.URL;

	import org.apache.commons.io.IOUtils;

	public class Universal_HTTPREQUEST {
		
		
		
		public HttpURLConnection HTTPSENDJSON(String urlAPI,String out) throws IOException {
			URL url = new URL(urlAPI);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setConnectTimeout(5000);
		    conn.setRequestProperty("Content-Type", "application/json");
		    conn.setDoOutput(true);
		    conn.setDoInput(true);
		    conn.setRequestMethod("PUT");
		    OutputStream os = conn.getOutputStream();
		    os.write(out.getBytes("UTF-8"));
		    os.close();
		    return conn;
		}
		
		public String HTTPREADJSON(HttpURLConnection conn) throws IOException {
			InputStream in = new BufferedInputStream(conn.getInputStream());
		    String result = IOUtils.toString(in, "UTF-8");//da mettere in un oggetto! serve creare un parsing in model account 
		    in.close();
		    return result;
		}

	}


