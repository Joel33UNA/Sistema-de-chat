/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package protocol.Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contacto implements Serializable {
    @XmlID
    String id;
    
    String nombre;
    boolean estado;
    
    ArrayList<Mensaje> mensajes;
    
    public Contacto(String nombre, String id){
        this.nombre = nombre;
        this.id = id;
        this.estado = false;
        this.mensajes = new ArrayList<>();
    }
    
    public Contacto(){
        this.nombre = "";
        this.id = "";
        this.estado = false;
        this.mensajes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
    
    public void addMensaje(Mensaje mensaje){
        this.mensajes.add(mensaje);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String actividad = "desconectado";
        if (estado) actividad = "conectado";
        return ("Nombre: " + nombre + "         " + "ID: " + id + "         " + "Estado: " + actividad);
    }
}
