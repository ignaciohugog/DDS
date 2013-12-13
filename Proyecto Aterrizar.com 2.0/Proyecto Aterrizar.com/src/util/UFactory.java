package util;

import java.util.Collection;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;

import domain.Aerolinea;

public class UFactory
{
	private static Hashtable<String, Object> instancias = new Hashtable<String, Object>();
	
	
	public static Object getInstancia(String objname)
	{	
		try
		{
			ResourceBundle rb = ResourceBundle.getBundle("ufactory");
			Object obj = null;

			//	Obtengo el value asociado a objname y lo separo en sClass y singleton
			String x = rb.getString(objname);
			int posPipe = x.indexOf('|');
			String sClass = x.substring(0, posPipe);
			boolean singleton = x.substring(posPipe+1).equals("true");
			
			if(singleton)
			{
				obj = instancias.get(objname);
				if (obj == null)
				{
					obj =  Class.forName(sClass).newInstance();
					instancias.put(objname, obj);
				}
				return obj;
			}
			
			
			obj = Class.forName(sClass).newInstance();
			return obj;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		
	}
	
	
	public static Collection<Aerolinea> getAerolineas()
	{
		Aerolinea unaAerolinea;
		
		ResourceBundle rb = ResourceBundle.getBundle("ufactory");
		String strAerolineas = rb.getString("AEROLINEAS");
		
		StringTokenizer st = new StringTokenizer(strAerolineas, "-");
		
		Collection<Aerolinea> aerolineas = new Vector<Aerolinea>();
		
		while(st.hasMoreElements())
		{
			String sClass = (String) st.nextElement();
			unaAerolinea = (Aerolinea) UFactory.getInstancia(sClass);
			aerolineas.add(unaAerolinea);
		}
		
		return aerolineas;
	}
}
