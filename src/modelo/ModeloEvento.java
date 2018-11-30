/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.sql.Date;
import javafx.scene.chart.PieChart;

public class ModeloEvento {
    private String nome;
    private String data;
    private String local;
    private String numero_pessoas;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data.toUpperCase();
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local.toUpperCase();
    }

    /**
     * @return the numero_pessoas
     */
    public String getNumero_pessoas() {
        return numero_pessoas;
    }

    /**
     * @param numero_pessoas the numero_pessoas to set
     */
    public void setNumero_pessoas(String numero_pessoas) {
        this.numero_pessoas = numero_pessoas.toUpperCase();
    }

    
    
    
}
