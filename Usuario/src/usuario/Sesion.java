/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package usuario;

import java.util.HashMap;

public class Sesion {
    private static Sesion theInstance;
    
    public static Sesion instance(){
        if (theInstance==null){ 
            theInstance=new Sesion();
        }
        return theInstance;
    }    
    
    HashMap<String,Object> attributes;

    private Sesion() {
        attributes = new HashMap();
    }
    
    public Object getAttribute(String attribute){
        return attributes.get(attribute);
    }
    
    public void setAttibute(String attribute, Object value){
        attributes.put(attribute, value);
    }
    
    public void removeAttribute(String attribute){
        attributes.remove(attribute);
    }
    
    public static String USER_ATTRIBUTE="user";
}
