
package controle;

import modelo.ModeloContrato;
import modelo.ModeloEvento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleContrato {
    ConectaBanco connEvento = new ConectaBanco();
    public void InserirContrato(ModeloContrato contrato){
        connEvento.conexao();
        try {
            PreparedStatement pst = connEvento.conn.prepareStatement("insert into contrato(atracao,eventonome,eventodata,valorcache) values (?,?,?,?)");
            pst.setString(1, contrato.getAtracao());
            pst.setString(2, contrato.getEventonome());
            pst.setString(3, contrato.getEventodata());
            pst.setString(4, contrato.getValorcache());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados armazenados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na inserção dos dados!\n ERRO!" +ex.getMessage());
        }
        
    }
}
