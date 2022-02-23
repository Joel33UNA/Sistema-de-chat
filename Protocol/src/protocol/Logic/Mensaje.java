/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package protocol.Logic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Mensaje implements Serializable {
    @XmlID
    String fecha;
    
    String mensaje;
    String contacto;
    String emisor;
    
    public Mensaje(String mensaje, String contacto, String emisor) {
        Date date = new Date();
        this.fecha = new SimpleDateFormat("HH:mm:ss").format(date);
        this.mensaje = mensaje;
        this.contacto = contacto;
        this.emisor = emisor;
    }
    
    public Mensaje(){
        this.fecha = "";
        this.mensaje = "";
        this.contacto = "";
        this.emisor = "";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }
    
    
    
    @Override
    public String toString(){
        return ("<" + emisor + ">" + ": " + mensaje + " | " + fecha);
    }
}
