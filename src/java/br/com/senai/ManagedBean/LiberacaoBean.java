/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.ManagedBean;

import br.com.senai.Liberacao;
import br.com.senai.dao.LiberacaoDao;
import java.util.List;

/**
 *
 * @author Rafael Segalla
 * @author Giulia Menezes
 * @author Ricardo Rossi
 */
public class LiberacaoBean {
    private Liberacao liberacao = new Liberacao();
    private LiberacaoDao liberacaoDao = new LiberacaoDao();
    private List<Liberacao> liberacoes = liberacaoDao.getAll();
    
    public String cancelarLiberacao(){
        liberacao = new Liberacao();
        return "autorizar-entrada-saida.xhtml";
    }
    
    public String adicionarAluno(){
        
        liberacaoDao.salvar(liberacao);
        liberacao = new Liberacao();
        liberacoes = liberacaoDao.getAll();
        return "autorizar-entrada-saida.xhtml";
    }

    public Liberacao getLiberacao() {
        return liberacao;
    }

    public void setLiberacao(Liberacao liberacao) {
        this.liberacao = liberacao;
    }

    public LiberacaoDao getLiberacaoDao() {
        return liberacaoDao;
    }

    public void setLiberacaoDao(LiberacaoDao liberacaoDao) {
        this.liberacaoDao = liberacaoDao;
    }

    public List<Liberacao> getLiberacoes() {
        return liberacoes;
    }

    public void setLiberacoes(List<Liberacao> liberacoes) {
        this.liberacoes = liberacoes;
    }
     
     
}
