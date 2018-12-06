package br.com.senai.dao;

import br.com.senai.GradeHorario;
import br.com.senai.Turma;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GradeHorarioDao {
    public GradeHorario salvar(GradeHorario horario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(horario);
        session.getTransaction().commit();
        return horario;
    }
    public List<GradeHorario> getAll(){
        List<GradeHorario> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from GradeHorario").list();
        return lista;
    }
    public List<GradeHorario> getAllNomes(){
        List<GradeHorario> lista = new ArrayList();
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("nome from GradeHorario").list();
        return lista;
    }
    public GradeHorario getById(Integer id){
        GradeHorario gradeHorario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        gradeHorario = (GradeHorario) session.get(GradeHorario.class, id);
        session.getTransaction().commit();
        return gradeHorario;
    }
    public void excluir(GradeHorario horario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(horario);
        session.getTransaction().commit();
    }
    
    public GradeHorario buscarByTurma(Turma turma) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<GradeHorario> lista = session.createCriteria(GradeHorario.class).
               add(Restrictions.eq( "turma", turma)).list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
}
