/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.ProdutoDAO;
import com.br.lp2.model.javabeans.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41583469
 */
public class ProdutoAction extends ActionSupport {

    public String insert() {
        String back = null;
        try {
            Produto produto = new Produto();
            produto.setCor(this.getRequest().getParameter("cor"));
            produto.setDescricao(this.getRequest().getParameter("descricao"));
            produto.setPreco(Double.parseDouble(this.getRequest().getParameter("preco")));
            produto.setTamanho(this.getRequest().getParameter("tamanho").charAt(0));
            try {
                Boolean resp = new ProdutoDAO().insert(produto);
                if (resp) {
                    back = "WEB-INF/jsp/produto/insertido.jsp";
                } else {
                    back = "erro";
                }
            } catch (Exception e) {
                Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
            }
            this.getRequest().setAttribute("produto", produto);
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }

        return back;
    }
}