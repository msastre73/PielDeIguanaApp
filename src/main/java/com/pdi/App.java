package com.pdi;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.messaging.BodyParts;
import com.backendless.messaging.MessageStatus;
import com.pdi.negocio.entidades.finales.Caja;
import com.pdi.negocio.entidades.finales.Cliente;
import com.pdi.negocio.entidades.finales.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
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
                
        
    }
}
