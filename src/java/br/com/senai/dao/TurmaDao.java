
package br.com.senai.dao;

import br.com.senai.Periodo;
import br.com.senai.Turma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

public class TurmaDao {
    
public  Turma salvarTurma (Turma turma){
    if(turma.getId() != null){
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.getTransaction().begin();
    session.saveOrUpdate(turma);
    session.getTransaction().commit();
    } else {
     Session session = HibernateUtil.getSessionFactory().openSession();
    session.getTransaction().begin();
    session.merge(turma);
    session.getTransaction().commit();
    }
    return turma;
}
    public void excluirTurma (Turma turma){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(turma);
        session.getTransaction().commit();
    }
    public List<Turma> getAllTurma(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = session.createCriteria(Turma.class);
        return crit.list();
    }
   public List<Periodo> getAllPeriodos(){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Criteria crit = session.createCriteria(Periodo.class);
       return crit.list();
   }

}

