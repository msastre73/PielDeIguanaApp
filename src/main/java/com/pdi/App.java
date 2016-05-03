package com.pdi;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.messaging.BodyParts;
import com.backendless.messaging.MessageStatus;
import com.backendless.utils.ReflectionUtil;
import com.pdi.UI.CantidadesBaseVentana;
import com.pdi.UI.VentanaMaestra;
import com.pdi.negocio.entidades.finales.Caja;
import com.pdi.negocio.entidades.finales.CantidadesBase;
import com.pdi.negocio.entidades.finales.Cliente;
import com.pdi.negocio.entidades.finales.Evento;
import com.pdi.negocio.entidades.finales.PreciosBase;
import com.pdi.negocio.entidades.finales.VariablesCotizacion;
import java.awt.Label;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.reflect.misc.ReflectUtil;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
       Backendless.initApp(
                "436619EC-61C6-B46C-FFE8-1E486BA58900", //application-id 
                "5D2D087A-60F3-6191-FFE8-CFA168B0E000", //secret-key
                "v1" //version
        );

        /*final Cliente clienteMarcos = new Cliente();
        clienteMarcos.setNombre("Rogelio");
        clienteMarcos.setApellido("Sastre");
        clienteMarcos.setMail("pepito@gmail.com");
        clienteMarcos.setDescuento(0.5F);/*
        
        

        /*Backendless.Persistence.save(clienteMarcos, new AsyncCallback<Cliente>() {

            public void handleResponse(Cliente clienteGuardado) {

                String rta = "Cliente guardado con ID " + clienteGuardado.getObjectId();
                System.out.println(rta);
                clienteMarcos.setObjectId(clienteGuardado.getObjectId());
                clienteMarcos.setCreated(clienteGuardado.getCreated());
                clienteMarcos.setUpdated(clienteGuardado.getUpdated());

                Backendless.Persistence.of(Cliente.class).findById(clienteMarcos.getObjectId(),
                        new AsyncCallback<Cliente>() {

                            public void handleResponse(Cliente response) {
                                System.out.println("Obtuvimos el clienteMarcos " + response.getNombre());
                            }

                            public void handleFault(BackendlessFault fault) {
                                System.out.println("Error: " + fault.getDetail()
                                        + "\nMsj: " + fault.getMessage());
                            }
                        });
            }

            public void handleFault(BackendlessFault fault) {
                System.out.println("Error: " + fault.getDetail()
                        + "\nMsj: " + fault.getMessage());
            }
        });*/

        /*final Evento evento1 = new Evento();
        evento1.setCantidadDePersonas(100);
        evento1.setCosto(1500);
        evento1.setLugar("Buenos Aires");
        evento1.setResultado(8000);
        
        /*Backendless.Persistence.save(evento1, new AsyncCallback<Evento>() {

            public void handleResponse(Evento response) {
                String rta = "Evento guardado con ID: " + response.getObjectId();
                System.out.println(rta);
                
                evento1.setObjectId(response.getObjectId());
                evento1.setCreated(response.getCreated());
                evento1.setUpdated(response.getUpdated());
            }

            public void handleFault(BackendlessFault fault) {
               System.out.println("Error: " + fault.getDetail()
                                        + "\nMsj: " + fault.getMessage());
            }
        });*/
        /*final Evento evento2 = new Evento();
        evento2.setCantidadDePersonas(300);
        evento2.setCosto(200);
        evento2.setLugar("Iguazu");
        evento2.setResultado(7000);
        
        List<Evento> listaEventos = new ArrayList<Evento>();
        listaEventos.add(evento1);
        listaEventos.add(evento2);
        
        clienteMarcos.setEventos(listaEventos);
        
        Backendless.Persistence.save(clienteMarcos, new AsyncCallback<Cliente>() {

            public void handleResponse(Cliente clienteGuardado) {

                String rta = "Cliente guardado con ID " + clienteGuardado.getObjectId();
                System.out.println(rta);
                clienteMarcos.setObjectId(clienteGuardado.getObjectId());
                clienteMarcos.setCreated(clienteGuardado.getCreated());
                clienteMarcos.setUpdated(clienteGuardado.getUpdated());
                
                Backendless.Persistence.of(Cliente.class).remove(clienteGuardado, new AsyncCallback<Long>() {

                    public void handleResponse(Long response) {
                        System.out.println("Cliente eliminado.");
                    }

                    public void handleFault(BackendlessFault fault) {
                        System.out.println("Error: " + fault.getDetail()
                        + "\nMsj: " + fault.getMessage());
                    }
                });

            }

            public void handleFault(BackendlessFault fault) {
                System.out.println("Error: " + fault.getDetail()
                        + "\nMsj: " + fault.getMessage());
            }
        });*/
        //TestFrame v = new TestFrame();
        //v.setVisible(true);
       
        /*BodyParts cuerpo = new BodyParts(null, "Esta vez va con <b><i>adjuntoo</i></b>");
        String archivo = "PEPSICO - Plan de Negocios.pdf";
        ArrayList<String> adjunto = new ArrayList<String>();
        adjunto.add(archivo);
        
        
        Backendless.Messaging.sendEmail("Prueba con Adjunto", cuerpo,
                "marcossastre73@gmail.com", adjunto, new AsyncCallback<Void>() {

            public void handleResponse(Void t) {
                System.out.println("Mensaje enviado"); 
            }

            public void handleFault(BackendlessFault bf) {
                System.out.println("Error: " + bf.getMessage());  
            }
        });*/
        /*Caja caja = new Caja();
        caja.setMinOK(true);
        caja.setMinimo(0);
        caja.setSaldo(0);
        
        Backendless.Persistence.of(Caja.class).save(caja, new AsyncCallback<Caja>() {

           public void handleResponse(Caja t) {
               System.out.println("Caja Creada");
           }

           public void handleFault(BackendlessFault bf) {
               System.out.println("Error" + bf.getMessage());}
       });*/
                
        /*PreciosBase cbase = new PreciosBase();
        cbase.setCachaca(40);
        cbase.setVodka(38);
        cbase.setRonDorado(100);
        cbase.setRonBlanco(42.06F);
        cbase.setFernet(165);
        cbase.setGancia(48.86F);
        cbase.setWhisky(81.53F);
        cbase.setCampari(90.76F);
        cbase.setLicorKiwi(35);
        cbase.setLicorDurazno(35);
        cbase.setLimon(5);
        cbase.setLima(10);
        cbase.setMenta(50);
        cbase.setAzucar(85.35F);
        cbase.setGranadina(37.73F);
        cbase.setJugoNaranja(15.4F);
        cbase.setJugoManzana(15.4F);
        cbase.setPulpaFrutilla(37.61F);
        cbase.setPulpaAnana(37.61F);
        cbase.setPulpaDurazno(37.61F);
        cbase.setSprite(30.98F);
        cbase.setSoda(11.28F);
        cbase.setVasos(260);
        cbase.setRevolvedores(70);
        cbase.setSorbetes(60);
        cbase.setHielo(40);
        cbase.setBartenders(250);
        
        Backendless.Persistence.of(PreciosBase.class).save(cbase, new AsyncCallback<PreciosBase>() {

           public void handleResponse(PreciosBase t) {
               System.out.println("Precios BAse Creadas"); 
           }

           public void handleFault(BackendlessFault bf) {
               System.out.println("Error: " + bf.getMessage());
           }
       });*/
      /*  VariablesCotizacion var = new VariablesCotizacion();
        var.setGananciaFijo(2000);
        var.setGananciaVariable(0.1F);
        var.setTasaRecargo(0.03F);
        var.setFactorPromo(1.5F);
        var.setFleteLocal(300);
        var.setFleteAfuera(1000);
        
        Backendless.Persistence.of(VariablesCotizacion.class).save(var, new AsyncCallback<VariablesCotizacion>() {

           public void handleResponse(VariablesCotizacion t) {
               System.out.println("Variables creadas");}

           public void handleFault(BackendlessFault bf) {
               System.out.println("Error" + bf.getMessage());}
       });*/
       
       /*Field[] fields = CantidadesBase.class.getDeclaredFields();
       for(int i = 0; i < fields.length; i++){
           try {
               System.out.println(fields[i] + fields[i].get(VentanaMaestra.CANT_BASE).toString());
           } catch (IllegalArgumentException ex) {
               Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IllegalAccessException ex) {
               Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }*/
       
       
       
       
       /* Method[] methods = CantidadesBase.class.getMethods();
        for(int i = 0; i < methods.length; i++){
           System.out.println("Metodo " + i + ": " + methods[i]);
           
       }*/
       
        
       /*Field[] campos = CantidadesBaseVentana.class.getDeclaredFields();
       
        for (Field campo : campos) {
            
            System.out.println(campo);
            System.out.println("CLASE: " + campo.get(campo));
        }*/
       

        
        
    }
}
