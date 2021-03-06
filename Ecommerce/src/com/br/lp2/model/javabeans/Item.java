/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

/**
 *
 * @author Beatriz
 */
public class Item {

    private long id_item;
    private int qtd;
    private Produto produto;
    private Compra compra;
    private double valorTotal;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" + "qtd=" + qtd + ", produto=" + produto + ", compra=" + compra + '}';
    }

    public long getId_item() {
        return id_item;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
    private void calcValorTotal(){
        this.valorTotal = produto.getPreco() * qtd;
    }

    public double getValorTotal() {
        calcValorTotal();
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
