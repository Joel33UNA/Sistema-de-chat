/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package usuario.presentation.principal;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import protocol.Logic.Contacto;
import protocol.Logic.Usuario;
import protocol.Logic.Mensaje;

public class Model extends Observable {
    Usuario current;
    ArrayList<Contacto> contactos;
    ArrayList<Mensaje> mensajes;
    
    public Model(){
        this.current = null;
        this.contactos = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }
    
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }
    
    public ArrayList<Contacto> getContactos(){
        return contactos;
    }
    
    public void setContactos(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }
    
    public ArrayList<Mensaje> getMensajes(){
        return mensajes;
    }
    
    public void setMensajes(ArrayList<Mensaje> mensajes){
        this.mensajes = mensajes;
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();        
    }    
}
