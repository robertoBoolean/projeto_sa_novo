package br.com.senai.dao;

import br.com.senai.Aluno;
import br.com.senai.GradeHorario;
import br.com.senai.Guarita;
import br.com.senai.SituacaoGuarita;
import br.com.senai.Turma;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class EntradaDao {

    private final AlunoDao alunoDao = new AlunoDao();
    private final TurmaDao turmaDao = new TurmaDao();
    private final GradeHorarioDao gradeHorarioDao = new GradeHorarioDao();

    public SituacaoGuarita realizarEntrada(String matricula) {
        Date dataAtual = new Date();
        Aluno aluno = alunoDao.getByMatricula(matricula);
        if (aluno == null) {
            return SituacaoGuarita.MATRICULA_NAO_ENCONTRADA;
        }

//        apos refatoração no modelo da turma descomentar a linha abaixo
//        Turma turma = turmaDao.getById(aluno.getTurma().getId());
        Turma turma = turmaDao.getById(Integer.parseInt(aluno.getTurma()));
        GradeHorario gradeHorario = gradeHorarioDao.buscarByTurma(turma);
        Guarita guaritaComEntrada = buscarEntrada(aluno.getId());
        if ((gradeHorario.getHr_inicio().before(dataAtual) || gradeHorario.getHr_inicio().equals(dataAtual))
                && (gradeHorario.getHr_fim().after(dataAtual) || gradeHorario.getHr_fim().equals(dataAtual))) {
            if (guaritaComEntrada != null) {
                if (guaritaComEntrada.getHoraEntrada() != null && guaritaComEntrada.getHoraSaida() != null) {
                    return SituacaoGuarita.DOIS_REGISTRO;
                }
            }
            if (guaritaComEntrada == null) {
                Guarita novoRegistro = new Guarita();
                novoRegistro.setAluno(aluno);
                novoRegistro.setHoraEntrada(dataAtual);
                salvar(novoRegistro);
                return SituacaoGuarita.ENTRADA;
            } else {
                guaritaComEntrada.setHoraSaida(dataAtual);
                salvar(guaritaComEntrada);
                return SituacaoGuarita.SAIDA;
            }
        } else {
            return SituacaoGuarita.FORA_HORARIO;
        }
    }

    private Guarita buscarEntrada(Integer alunoId) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoId);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Guarita> lista = session.createCriteria(Guarita.class).
                add(Restrictions.eq("aluno", aluno)).list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }

    private Guarita salvar(Guarita guarita) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(guarita);
        session.getTransaction().commit();
        return guarita;
    }
}
