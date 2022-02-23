/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package server;

import protocol.Protocol;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import protocol.Logic.Usuario;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import protocol.Logic.Mensaje;
import server.Logic.Service;

public class Server {
    ServerSocket srv;
    List<Worker> workers; 
    
    public Server() {
        try {
            srv = new ServerSocket(Protocol.PORT);
            workers =  Collections.synchronizedList(new ArrayList<Worker>());
        } 
        catch (IOException ex) {}
    }
    
    public void run(){
        Service localService = (Service)(Service.instance());
        localService.setServer(this);
        boolean continuar = true;
        while (continuar) {
            try {
                Socket skt = srv.accept();
                ObjectInputStream in = new ObjectInputStream(skt.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(skt.getOutputStream() );
                try {
                    int method = in.readInt();                   
                    Usuario user=(Usuario)in.readObject();                          
                    try {
                        user=Service.instance().login(user);
                        out.writeInt(Protocol.ERROR_NO_ERROR);
                        out.writeObject(user);
                        out.flush();
                        notificarON(user);
                        Worker worker = new Worker(skt,in,out,user); 
                        workers.add(worker);                      
                        worker.start();                            
                    } catch (Exception ex) {
                       out.writeInt(Protocol.ERROR_LOGIN);
                       out.flush();
                    }                          
                } 
                catch (ClassNotFoundException ex) {}                

            } 
            catch (IOException ex) {}
        }
    }
    
    public void deliver(Mensaje mensaje){
        String contacto = mensaje.getContacto();
        for(Worker wk:workers){
            if (contacto.equals(wk.usuario.getId()))
                wk.deliver(mensaje);
        }        
    } 

    public void remove(Usuario u){
        for(Worker wk:workers) {
            if(wk.usuario.equals(u)){
                workers.remove(wk);
                try { wk.skt.close();} catch (IOException ex) {}
                break;
            }
        }
    }
    
    public void notificarON(Usuario u){
        for (Worker wk : workers)
            if (!wk.usuario.equals(u))
                wk.notificarON(u);
    }
    
    public void notificarOFF(Usuario u){
        for (Worker wk : workers)
            if(!wk.usuario.equals(u))
                wk.notificarOFF(u);
    }
    
    public void comprobacionON(Usuario u) throws Exception {
        for (Worker wk : workers)
            if (wk.usuario.equals(u))
                return;
        throw new Exception();
    }
}