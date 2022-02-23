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
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable {
    String id;
    String clave;
    String nombre;
    ArrayList<Contacto> contactos;
    
    public Usuario(String id, String clave, String nombre) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.contactos = new ArrayList<>();
    }
    
    public Usuario() {
        this.id = "";
        this.clave = "";
        this.nombre = "";
        this.contactos = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getClave() {
        return this.clave;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    
    public void agregarContacto(Contacto nuevo) throws Exception {
        for (Contacto contacto : contactos){
            if (contacto.equals(nuevo))
                throw new Exception();
        }
        contactos.add(nuevo);
    }
    
    public Contacto getContacto(int index) {
        return contactos.get(index);
    }
    
    public Contacto getContactoID(Usuario usuario){
        for (Contacto recuperado : contactos)
            if(recuperado.getId().equals(usuario.getId()))
                return recuperado;
        return null;
    }
    
    public Contacto getContactoString(String contacto){
        for (Contacto recuperado : contactos)
            if (recuperado.getId().equals(contacto))
                return recuperado;
        return null;
    }
    
    public ArrayList<Contacto> filtrarContacto(Contacto contacto){
        ArrayList<Contacto> nuevo = new ArrayList<>();
        for (Contacto recuperado : contactos){
            if (recuperado.getNombre().contains(contacto.getNombre()))
                nuevo.add(recuperado);
        }
        return nuevo;
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return (nombre + " <" + id + ">");
    }
}
