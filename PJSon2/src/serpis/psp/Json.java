package serpis.psp;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class Json  
{

public static void main (String [] args)
{
	busqueda("15","22");
}
public static String busqueda(String longitud,String latitud)
{
	String devuelve="";	
	HtttpClient comunicacion=new DefaultHttpClient(); 
	HttpGet peticion=new HttpGet("http://maps.googleapis.com/maps/api/geocode/json?"+"latlng="+latitud+","+longitud+"&sensor=false");
	peticion.setHeader("content-type","application/json");
	HttpResponse respuesta=comunicacion.execute(peticion);
	String respuestaCad=EntityUtils.toString(respuesta.getEntity());
	JSONObject respuestaJSON=new JSONObject(respuestaCad);
	JSONObject resultJSON=respuestaJSON.getJSONArray("results");
	String direccion="SIN DATOS";
	if(resultJSON.length()>0)
	{
		direccion=resultJSON.getJSONObject(0).getString("formatted_address");
	}
	devuelve="Direccion: "+direccion;
	
	return devuelve;
	}
}
