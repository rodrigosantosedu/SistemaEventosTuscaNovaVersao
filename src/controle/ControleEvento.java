
package controle;

import Modelo.ModeloEvento;
import javax.swing.JOptionPane;

public class ControleEvento {
    
    public void InserirEvento(ModeloEvento evento){
        JOptionPane.showMessageDialog(null, evento.getLocal());
    }
}
