package protocol;

import protocol.Logic.Mensaje;
import protocol.Logic.Usuario;

public interface IService {
    public Usuario login(Usuario u) throws Exception;
    public void logout(Usuario u) throws Exception;
    public void comprobarEstado(Usuario u) throws Exception;
    public void post(Mensaje mensaje);
}
