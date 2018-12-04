/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.dao;

import br.com.senai.Liberacao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Rafael Segalla
 * @author Giulia Menezes
 * @author Ricardo Rossi
 */
public class LiberacaoDao {
    
     /**
     * Salva ou atualiza uma liberacao no banco de dados
     * @param liberacao
     * @return liberacao
     */
    public Liberacao salvar (Liberacao liberacao){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(liberacao);
        session.getTransaction().commit();
        return liberacao;
    }
    
    /**
     * Retorna uma lista de todos as liberacoes
     * @return lista
     */
    public List<Liberacao> getAll(){
        List<Liberacao> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from Liberacao").list();
        return lista;
    }
    
    /**
     * Retorna uma liberacao, de acordo com o id recebido
     * @param id
     * @return liberacao
     */    
    public Liberacao getById(Integer id) {
        Liberacao liberacao = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        liberacao = (Liberacao) session.get(Liberacao.class, id);
        session.getTransaction().commit();
        return liberacao;
    }
    
}
