/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package server.Logic;

import server.Server;
import protocol.IService;
import protocol.Logic.Usuario;
import protocol.Logic.Mensaje;
import server.Data.UsuarioDao;

public class Service implements IService{
    static Service theInstance;
    
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    Server server;
    private UsuarioDao usuarioDao;    
    
    private Service() {
        usuarioDao = new UsuarioDao();        
    }
    
    public void setServer(Server server){
        this.server = server;
    }
    
    @Override
    public void post(Mensaje m){
        server.deliver(m);
    }

    @Override
    public Usuario login(Usuario u) throws Exception {
        return usuarioDao.read(u.getId(),u.getClave());
    }

    @Override
    public void logout(Usuario u) throws Exception {
        server.remove(u);
        server.notificarOFF(u);
    }

    @Override
    public void comprobarEstado(Usuario u) throws Exception {
        server.comprobacionON(u);
        server.notificarON(u);
    }

}