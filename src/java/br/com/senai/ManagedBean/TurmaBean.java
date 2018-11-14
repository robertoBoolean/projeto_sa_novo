package br.com.senai.ManagedBean;

import br.com.senai.Periodo;
import br.com.senai.dao.TurmaDao;
import br.com.senai.Turma;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "turmaBean")
public class TurmaBean implements Serializable {

    private Turma turma = new Turma();

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String novaTurma() {
        turma = new Turma();
        return "editar-turma.xhtml";
    }

    public String salvarTurma() {
        TurmaDao dao = new TurmaDao();
        dao.salvarTurma(turma);
        return "gerenciar-turma.xhtml";

    }

    public String excluir() {
        TurmaDao dao = new TurmaDao();
        dao.excluirTurma(turma);
        return "gerenciar-turma.xhtml";
    }

    public List<Turma> getTurmas() {
        TurmaDao dao = new TurmaDao();
        return dao.getAllTurma();

    }

    public String listarTurma() {
        return "gerenciar-turma.xhtml";
    }

    public String editar() {
        return "editar-turma.xhtml";
    }

    public List<Periodo> getPeriodos() {
        return new TurmaDao().getAllPeriodos();
    }

    public String salvar() {
        TurmaDao dao = new TurmaDao();
        dao.salvarTurma(turma);
        return "gerenciar-turma.xhtml";
    }

}
