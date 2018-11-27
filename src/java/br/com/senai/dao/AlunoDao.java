package br.com.senai.dao;

import br.com.senai.Aluno;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * 
 * @author Eduardo
 * @author Rafael
 * @author Roberto
 * @version 1.0
 * @since Java 5.0
 */

public class AlunoDao {
    /**
     * Salva ou atualiza um aluno no banco de dados
     * @param aluno
     * @return aluno
     */
    public Aluno salvar (Aluno aluno){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(aluno);
        session.getTransaction().commit();
        return aluno;
    }
    
    /**
     * Retorna uma lista de todos os alunos
     * @return lista
     */
    public List<Aluno> getAll(){
        List<Aluno> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from Aluno").list();
        return lista;
    }
    
    /**
     * Retorna um aluno, de acordo com o id recebido
     * @param id
     * @return aluno
     */    
    public Aluno getById(Integer id) {
        Aluno aluno = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        aluno = (Aluno) session.get(Aluno.class, id);
        session.getTransaction().commit();
        return aluno;
    }
    
    /**
     * Exclui um aluno buscando pelo id
     * @param aluno 
     */    
    public void excluir(Aluno aluno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(aluno);
        session.getTransaction().commit();
    }
}
