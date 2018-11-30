
package controle;

import modelo.ModeloEvento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleEvento {
    ConectaBanco connEvento = new ConectaBanco();
    public void InserirEvento(ModeloEvento evento){
        connEvento.conexao();
        try {
            PreparedStatement pst = connEvento.conn.prepareStatement("insert into evento(nome,data,numeropessoas,local) values (?,?,?,?)");
            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getData());
            pst.setString(3, evento.getNumero_pessoas());
            pst.setString(4, evento.getLocal());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados armazenados com sucesso!");
            
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1){
                
            }
            JOptionPane.showMessageDialog(null, "Esse Evento já foi cadastrado com essa data anteriormente!\nSendo assim, você já o encontra dentro do sistema!");
        }
        
    }
}
