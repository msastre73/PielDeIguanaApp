package com.pieldeiguana;

import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseObject;
import org.parse4j.callback.SaveCallback;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Parse.initialize("vlggVnYS02godcofnSC4limZG7XMOc5I4VMcSz0B", //App ID
                "uotLx4R6kPfs9PNLXnxDdzyAC7NiQmhaG4hL7BIL"); //REST API key
        
        
        
        
        ParseObject desdeJava = new ParseObject("DesdeJava");
        desdeJava.put("Nombre", "Marcos");
        desdeJava.put("Apellido", "Sastre");
        desdeJava.put("Edad", 23);
        desdeJava.saveInBackground(new SaveCallback() {

            @Override
            public void done(ParseException pe) {
                
                if(pe==null){
                System.out.println("Objeto guardado correctamente");
            }else{
                    System.out.println("Error:" + pe.toString());
                }
            
            }

                 
        });
    }
}
