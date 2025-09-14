/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.util.Date;

/**
 *
 * @author user
 */
public class Vendas {
 private int wam_idvenda;
    private int wam_idvendedor;
    private int wam_idcliente;
    private Double wam_valor;
    private Double wam_desconto;
    private Double wam_valorFinal;
    private Date wam_dataVenda;

    /**
     * @return the wam_idvenda
     */
    public int getWam_idvenda() {
        return wam_idvenda;
    }

    /**
     * @param wam_idvenda the wam_idvenda to set
     */
    public void setWam_idvenda(int wam_idvenda) {
        this.wam_idvenda = wam_idvenda;
    }

    /**
     * @return the wam_idvendedor
     */
    public int getWam_idvendedor() {
        return wam_idvendedor;
    }

    /**
     * @param wam_idvendedor the wam_idvendedor to set
     */
    public void setWam_idvendedor(int wam_idvendedor) {
        this.wam_idvendedor = wam_idvendedor;
    }

    /**
     * @return the wam_idcliente
     */
    public int getWam_idcliente() {
        return wam_idcliente;
    }

    /**
     * @param wam_idcliente the wam_idcliente to set
     */
    public void setWam_idcliente(int wam_idcliente) {
        this.wam_idcliente = wam_idcliente;
    }

    /**
     * @return the wam_valor
     */
    public Double getWam_valor() {
        return wam_valor;
    }

    /**
     * @param wam_valor the wam_valor to set
     */
    public void setWam_valor(Double wam_valor) {
        this.wam_valor = wam_valor;
    }

    /**
     * @return the wam_desconto
     */
    public Double getWam_desconto() {
        return wam_desconto;
    }

    /**
     * @param wam_desconto the wam_desconto to set
     */
    public void setWam_desconto(Double wam_desconto) {
        this.wam_desconto = wam_desconto;
    }

    /**
     * @return the wam_valorFinal
     */
    public Double getWam_valorFinal() {
        return wam_valorFinal;
    }

    /**
     * @param wam_valorFinal the wam_valorFinal to set
     */
    public void setWam_valorFinal(Double wam_valorFinal) {
        this.wam_valorFinal = wam_valorFinal;
    }

    /**
     * @return the wam_dataVenda
     */
    public Date getWam_dataVenda() {
        return wam_dataVenda;
    }

    /**
     * @param wam_dataVenda the wam_dataVenda to set
     */
    public void setWam_dataVenda(Date wam_dataVenda) {
        this.wam_dataVenda = wam_dataVenda;
    }
}
