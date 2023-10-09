package ArchiVet.ventana.componente;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Render_Button_JTable extends DefaultTableCellRenderer{
    
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Seleccion, boolean Foco, int Fila, int Columna){
        if(value instanceof JButton){
            JButton btn = (JButton) value;
            if(Seleccion){
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        
        if(value instanceof JCheckBox){
            JCheckBox CH = (JCheckBox) value;
            return CH;
        }
        
        return super.getTableCellRendererComponent(table, value, Seleccion, Foco, Fila, Columna);
    }
    
}
