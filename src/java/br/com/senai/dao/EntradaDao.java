package br.com.senai.dao;

import br.com.senai.Aluno;
import br.com.senai.Curso;
import br.com.senai.GradeHorario;
import br.com.senai.Guarita;
import br.com.senai.ManagedBean.CursoBean;
import java.time.LocalDate;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

public class EntradaDao {
    private AlunoDao alunoDao = new AlunoDao();
    
    public void realizarEntrada (String matricula) throws Exception{
        Aluno aluno = alunoDao.getByMatricula(matricula);
        if (aluno == null) {
            throw new Exception("aluno nao existente");
        }
        Guarita guaritaComEntrada = buscarEntrada(aluno.getId());
        GradeHorario gradeHorario = null;
        Date dataAtual = new Date();
        if (guaritaComEntrada != null) {
            if (guaritaComEntrada.getHoraEntrada() != null && guaritaComEntrada.getHoraSaida() != null) {
                throw new Exception("aluno ja entrou e saiu hoje");
            }
        }
        if (guaritaComEntrada == null) {
            Guarita novoRegistro = new Guarita();
            novoRegistro.setAluno(aluno);
            novoRegistro.setHoraEntrada(dataAtual);
            salvar(novoRegistro);
        } else {
            guaritaComEntrada.setHoraSaida(dataAtual);
            salvar(guaritaComEntrada);
        }
        
    }
    
    private Guarita buscarEntrada(Integer alunoId) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoId);
        Guarita guarita  = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Guarita> lista = session.createCriteria(Guarita.class).
               add(Restrictions.eq( "aluno", aluno)).list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);   
        }
    }
    
    private Guarita salvar (Guarita guarita){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(guarita);
        session.getTransaction().commit();
        return guarita;
    }
}
