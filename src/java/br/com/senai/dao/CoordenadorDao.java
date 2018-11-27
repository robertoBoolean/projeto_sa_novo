package br.com.senai.dao;

import br.com.senai.Coordenador;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class CoordenadorDao {
    
    public Coordenador salvar (Coordenador coordenador){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(coordenador);
        session.getTransaction().commit();
        return coordenador;
    }
       
    public List<Coordenador> getAll(){
        List<Coordenador> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from Coordenador").list();
        return lista;
    }
        public Coordenador getById(Integer id) {
        Coordenador coordenador = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        coordenador = (Coordenador) session.get(Coordenador.class, id);
        session.getTransaction().commit();
        return coordenador;
    }

    public void excluir(Coordenador coordenador) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(coordenador);
        session.getTransaction().commit();
    }
    
}
