package utilitarios;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConectaBanco {
    public Statement stm;//public para acessar em outras classes
    public ResultSet rs;//public para acessar em outras classes
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    private final String caminho = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl";
    private final String usuario = "x";
    private final String senha = "x";
    public Connection conn;//public para acessar em outras classes
    
    public void conexao(){ // metodo responsavel por realizar a conexao com o banco oracle
        try {
            System.setProperty("jdbc.Drivers",driver);// seta a propriedade do driver de conexao
            conn = DriverManager.getConnection(caminho,usuario,senha);// realiza conexao
            //JOptionPane.showMessageDialog(null, "conectado com sucesso");
        } catch (SQLException ex) { // caso de "ruim" na conexao entra aqui
            JOptionPane.showMessageDialog(null, "erro de conexao!\n ");
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
   public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs =  stm.executeQuery(sql);  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL!\n "+e.getMessage());
        }
        
}
    
    public void desconecta(){// esse metodo serve para desconectar o banco
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Desconectado com sucesso!\n ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao fechar a conexao!\n ");
        }
    }
    
}
