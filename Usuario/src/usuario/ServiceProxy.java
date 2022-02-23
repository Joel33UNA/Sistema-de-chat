/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package usuario;

import protocol.Logic.Usuario;
import protocol.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.SwingUtilities;
import protocol.IService;
import protocol.Logic.Mensaje;
import usuario.presentation.principal.Controller;

public class ServiceProxy implements IService{
    private static IService theInstance;
    
    public static IService instance(){
        if (theInstance==null){ 
            theInstance=new ServiceProxy();
        }
        return theInstance;
    }
    
    Socket skt;    
    ObjectInputStream in;
    ObjectOutputStream out;
    Controller controller;

    public ServiceProxy() {           
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    private void connect() throws Exception{
        skt = new Socket(Protocol.SERVER,Protocol.PORT);
        out = new ObjectOutputStream(skt.getOutputStream() );
        in = new ObjectInputStream(skt.getInputStream());    
    }

    private void disconnect() throws Exception{
        skt.shutdownOutput();
        skt.close();
    }
    
    @Override
    public Usuario login(Usuario u) throws Exception{
        try {
            connect();
            out.writeInt(Protocol.LOGIN);
            out.writeObject(u);
            out.flush();
            int response = in.readInt();
            if (response==Protocol.ERROR_NO_ERROR){
                Usuario u1=(Usuario) in.readObject();
                this.start();
                return u1;
            }
            else {
                disconnect();
                throw new Exception("No remote user");
                
            }            
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }
    
    @Override
    public void logout(Usuario u) throws Exception{
        out.writeInt(Protocol.LOGOUT);
        out.writeObject(u);
        out.flush();
        this.stop();
        this.disconnect();
    }
    
    @Override
    public void comprobarEstado(Usuario u) throws Exception {
        out.writeInt(Protocol.COMP);
        out.writeObject(u);
        out.flush();
    }
    
    @Override
    public void post(Mensaje mensaje){
        try {      
            out.writeInt(Protocol.POST);
            out.writeObject(mensaje);
            out.flush();            
        } 
        catch (IOException ex) {
        }   
    }  
    
    // LISTENING FUNCTIONS
   boolean continuar = true;    
   public void start(){
        Thread t = new Thread(new Runnable(){
            public void run(){
                listen();
            }
        });
        continuar = true;
        t.start();
    }
    public void stop(){
        continuar=false;
    }
    
   public void listen(){
        int method;
        while (continuar) {
            try {
                method = in.readInt();
                switch(method){
                case Protocol.DELIVER: 
                    try {
                        Mensaje message=(Mensaje)in.readObject();
                        deliver(message);
                    } 
                    catch (ClassNotFoundException ex) {}
                    break;
                case Protocol.ON:
                    try {
                       Usuario usuario = (Usuario)in.readObject();
                       notificarON(usuario);
                    } catch (ClassNotFoundException ex) {}
                    break;
                case Protocol.OFF:
                    try {
                        Usuario usuario = (Usuario)in.readObject();
                        notificarOFF(usuario);
                    } catch (ClassNotFoundException ex) {}
                    break;
                }
                out.flush();
            } catch (IOException  ex) {
                continuar = false;
            }                        
        }
    }
    
   private void deliver( final Mensaje message ){
      SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               controller.deliver(message);
            }
         }
      );
   }
   
   private void notificarON(Usuario usuario){
       SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               controller.notificarON(usuario);
           }
       });
   }
   
   private void notificarOFF(Usuario usuario){
       SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               controller.notificarOFF(usuario);
           }
       });
   }
}
