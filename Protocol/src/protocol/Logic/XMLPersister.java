/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTES: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package protocol.Logic;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLPersister {
    private String path;
    private static XMLPersister instancia;
    
    public static XMLPersister instancia(){
        if (instancia == null){ 
            instancia = new XMLPersister();
        }
        return instancia;
    }

    private XMLPersister() {
        this.path = "";
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public Usuario load() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Usuario result  = (Usuario) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    
    public void store(Usuario d) throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(d, os);
        os.flush();
        os.close();
    }
}
