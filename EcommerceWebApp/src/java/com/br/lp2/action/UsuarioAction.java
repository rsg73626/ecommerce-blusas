/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.EnderecoDAO;
import com.br.lp2.dao.UsuarioDAO;
import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import java.text.SimpleDateFormat;

/**
 *
 * @author Beatriz
 */
public class UsuarioAction extends ActionSupport {

    public String insert() {
        String back = null;
        try {
            
            
            Usuario usuario = new Usuario();
            usuario.setNome(getRequest().getParameter("nome"));
            usuario.setSobrenome(getRequest().getParameter("sobrenome"));
            usuario.setCpf(getRequest().getParameter("cpf"));
            usuario.setUsuario(getRequest().getParameter("usuario"));
            usuario.setSenha(getRequest().getParameter("senha"));
            usuario.setTipo(Tipo.values()[Integer.parseInt(getRequest().getParameter("tipo"))]);
            usuario.setDt_nascimento(new SimpleDateFormat("yyyy-MM-dd").parse(getRequest().getParameter("dt_nascimento")));
            
            Endereco endereco = new Endereco();
            endereco.setBairro(getRequest().getParameter("bairro"));
            endereco.setCep(getRequest().getParameter("cep"));
            endereco.setCidade(getRequest().getParameter("cidade"));
            endereco.setEstado(getRequest().getParameter("estado"));
            endereco.setRua(getRequest().getParameter("rua"));
            endereco.setId_endereco(new EnderecoDAO().insertWithPKReturn(endereco));
            
            usuario.setEndereco(endereco);
            new UsuarioDAO().insert(usuario);
        } catch (Exception e) {

        }
        return back;
    }

}