package br.com.senai.dao;

import br.com.senai.Curso;
import br.com.senai.ManagedBean.CursoBean;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Aluno
 * @author Luis Henrique
 * Classe para realizar as Operações de Curso no Banco de Dados
 * @see CursoBean
 */
public class CursoDao {

    /**
     * Metodo para realizar a persistencia de um curso na base de dados
     * @param Curso - espera um curso para persistir
     * @return Curso - retorna o Curso ja salvo
     */
    public Curso salvar (Curso curso){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(curso);
        session.getTransaction().commit();
        return curso;
    }
    
    /**
     * Metodo para realizar a pesquisa de todos os curso
     * da base de dados
     * @return List - retorna uma lista de cursos
     */
    public List<Curso> getAll(){
        List<Curso> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from Curso").list();
        return lista;
    }
    
    /**
     * Metodo para realizar a busca de um Curso em especifico
     * pelo seu identificador unico
     * @param id - Espera um Numero de Codigo de Curso
     * @return Curso - Retorna o curso que sera buscado 
     * na base de dados
     */
    public Curso getById(Integer id) {
        Curso curso = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        curso = (Curso) session.get(Curso.class, id);
        session.getTransaction().commit();
        return curso;
    }

    /**
     * Metodo para realizar a exclusão de um Curso da base de dados
     * @param curso - Espera um curso como parametro
     */
    public void excluir(Curso curso) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(curso);
        session.getTransaction().commit();
    }
}
