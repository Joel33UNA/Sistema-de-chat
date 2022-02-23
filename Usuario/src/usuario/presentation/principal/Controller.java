/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/


package usuario.presentation.principal;

import java.util.ArrayList;
import protocol.Logic.Contacto;
import protocol.Logic.Mensaje;
import usuario.Sesion;
import protocol.Logic.Usuario;
import protocol.Logic.XMLPersister;
import usuario.ServiceProxy;

public class Controller {
    Model model;
    View view;
    ServiceProxy localService;

    
    public Controller(Model model, View view){
        this.view = view;
        this.model = model;
        localService = (ServiceProxy)ServiceProxy.instance();
        localService.setController(this);
        view.setController(this);
        view.setModel(model);
    }

    public void agregarContacto(Contacto contacto) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId(contacto.getId());
        if (model.current.equals(usuario))
            throw new Exception();
        ServiceProxy.instance().comprobarEstado(usuario);
        model.getCurrent().agregarContacto(contacto);
        model.setContactos(model.getCurrent().getContactos());
        model.commit();
    }
    
    public void filtrarContacto(Contacto contacto) {
        model.setContactos(model.getCurrent().filtrarContacto(contacto));
        model.commit();
    }
    
    public void filtrarMensajes(int selectedIndex) {
        Contacto contacto = model.current.getContacto(selectedIndex);
        ArrayList<Mensaje> mensajes = contacto.getMensajes();
        model.setMensajes(mensajes);
        model.commit();
    }
    
    public void post(Contacto contacto){
        String message = view.getMensaje().getText();
        Mensaje mensaje = new Mensaje(message, contacto.getId(), model.getCurrent().getId());
        ServiceProxy.instance().post(mensaje);
        contacto.addMensaje(mensaje);
        model.setMensajes(contacto.getMensajes());
        model.commit();
    }
    
    public void login(Usuario typed) throws Exception {
        Usuario logged = ServiceProxy.instance().login(typed);   
        model.setCurrent(logged);
        try{
            XMLPersister.instancia().setPath(logged.getId() + ".xml");
            Usuario recuperado = XMLPersister.instancia().load();
            logged.setContactos(recuperado.getContactos());
            model.setContactos(recuperado.getContactos());
        }
        catch(Exception e){}
        for (Contacto contacto : logged.getContactos()){
            Usuario nuevo = new Usuario();
            nuevo.setId(contacto.getId());
            ServiceProxy.instance().comprobarEstado(nuevo);
        }
        this.hide();
        this.show();
        model.commit();
    }
    
    public void logOut(){
        Sesion.instance().removeAttribute(Sesion.USER_ATTRIBUTE);
        try{
            ServiceProxy.instance().logout(model.getCurrent());
        }
        catch(Exception e){}
        try{
            XMLPersister.instancia().setPath(model.current.getId() + ".xml");
            XMLPersister.instancia().store(model.current);
        }
        catch(Exception e){
            System.out.println(e.getCause());
        }
        model.setCurrent(null);
        model.commit();        
        this.show();
    }
    
    public void deliver(Mensaje message) {
        Contacto contacto = model.getCurrent().getContactoString(message.getEmisor());
        if (contacto != null) {
            contacto.addMensaje(message);
        }
        model.commit();
    }
    
    public void notificarON(Usuario usuario){
        Contacto contacto = model.current.getContactoID(usuario);
        if (contacto != null) contacto.setEstado(true);
        model.commit();
    }
    
    public void notificarOFF(Usuario usuario){
        Contacto contacto = model.current.getContactoID(usuario);
        if (contacto != null)
            contacto.setEstado(false);
        model.commit();
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void show(){
        view.setVisible(true);
    }
    
    public void exit(){
        System.exit(0);
    }
}