/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package server.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import protocol.Logic.Usuario;

public class UsuarioDao {
    public Usuario read(String id, String clave) throws Exception{
        String sql="select * from Usuario where id=? and clave=?";
        PreparedStatement stm = Database.instance().prepareStatement(sql);
        stm.setString(1, id);
        stm.setString(2, clave);
        ResultSet rs =  Database.instance().executeQuery(stm);           
        if (rs.next()) {
            return from(rs);
        }
        else{
            throw new Exception ("Usuario no Existe");
        }
    }

    public Usuario from (ResultSet rs){
        try {
            Usuario r= new Usuario();
            r.setId(rs.getString("id"));
            r.setClave(rs.getString("clave")); 
            r.setNombre(rs.getString("nombre"));
            return r;
        } catch (SQLException ex) {
            return null;
        }
    }
}
