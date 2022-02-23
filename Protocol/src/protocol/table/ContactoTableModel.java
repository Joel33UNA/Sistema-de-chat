/*
UNIVERSIDAD NACIONAL DE COSTA RICA
EIF-206  -  PROGRAMACIÓN III
ESTUDIANTE: JOEL ZAMORA Y DIEGO JIMÉNEZ
PROFESOR: JOSE SÁNCHEZ SALAZAR
*/

package protocol.table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import protocol.Logic.Contacto;

public class ContactoTableModel extends AbstractTableModel implements TableModel {
    String[] atributos = {"Nombre", "ID", "Estado"};
    ArrayList<Contacto> contactos;
    
    public ContactoTableModel(ArrayList<Contacto> contactos){
        this.contactos = contactos;
    }

    @Override
    public int getRowCount() {
        return contactos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return atributos[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contacto contacto = contactos.get(rowIndex);
        switch(columnIndex){
            case 0: return contacto.getNombre();
            case 1: return contacto.getId();
            case 2: if (contacto.getEstado())
                        return "Conectado.";
                    return "Desconectado.";
            default: return null;
        }
    }
}
