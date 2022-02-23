package server;

import protocol.Logic.Usuario;
import protocol.Protocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import protocol.Logic.Mensaje;
import server.Logic.Service;

public class Worker {
    public Socket skt;
    public ObjectInputStream in;
    public ObjectOutputStream out;
    public Usuario usuario;

    public Worker(Socket skt, ObjectInputStream in, ObjectOutputStream out, Usuario usuario) {
        this.skt=skt;
        this.in=in;
        this.out=out;
        this.usuario=usuario;
    }

    boolean continuar;    
    public void start(){
        try {
            System.out.println("Worker atendiendo peticiones...");
            Thread t = new Thread(new Runnable(){
                public void run(){
                    listen();
                }
            });
            continuar = true;
            t.start();
        } catch (Exception ex) {  
        }
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
                case Protocol.LOGOUT:
                    try {
                        Service.instance().logout(usuario);
                    } catch (Exception ex) {}
                    stop();
                    break;                 
                case Protocol.POST:
                    try {
                        Mensaje nuevoM = (Mensaje)in.readObject();
                        Service.instance().post(nuevoM);
                    } catch (ClassNotFoundException ex) {}
                    break;  
                case Protocol.COMP:
                    Usuario nuevoU = new Usuario();
                    try {
                        nuevoU = (Usuario)in.readObject();
                        Service.instance().comprobarEstado(nuevoU);
                    }
                    catch (ClassNotFoundException ex) {} 
                    catch (Exception ex) {
                        notificarOFF(nuevoU);
                    }
                    break;
                }
                out.flush();
            } catch (IOException  ex) {
                continuar = false;
            }                        
        }
    }
    
    public void deliver(Mensaje message){
        try {
            out.writeInt(Protocol.DELIVER);
            out.writeObject(message);
            out.flush();
        } 
        catch (IOException ex) {}
    }
    
    public void notificarON(Usuario u){
        try {
            out.writeInt(Protocol.ON);
            out.writeObject(u);
            out.flush();
        } catch (IOException ex) {}
    }
    
    public void notificarOFF(Usuario u){
        try{
            out.writeInt(Protocol.OFF);
            out.writeObject(u);
            out.flush();
        } catch(IOException ex){}
    }
}
