package br.com.senai.ManagedBean;

import br.com.senai.Aluno;
import br.com.senai.dao.AlunoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Eduardo
 * @author Rafael
 * @author Roberto
 * @version 1.0
 * @since Java 5.0
 */

@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable{
    private Aluno aluno = new Aluno();
    private AlunoDao alunoDao = new AlunoDao();
    private List<Aluno> alunos = alunoDao.getAll();
    
    /**
     * @author Rafael S
     * filtroAlunos é utilizado para a seleção de alunos da tabela para aplicar a função liberar na tela de liberação
     **/
    private List<Aluno> filtroAlunos;

    public List<Aluno> getFiltroAlunos() {
        return filtroAlunos;
    }

    public void setFiltroAlunos(List<Aluno> filtroAlunos) {
        this.filtroAlunos = filtroAlunos;
    }
    
    public String adicionarAluno(){
        
        alunoDao.salvar(aluno);
        aluno = new Aluno();
        alunos = alunoDao.getAll();
        return "gerenciar-alunos.xhtml";
    }
    public String cancelarAluno(){
        aluno = new Aluno();
        return "gerenciar-alunos.xhtml";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    public String editAluno(){
        return "editar-alunos.xhtml";
    }
    public String excluirAluno(){
        alunoDao.excluir(aluno);
        alunos = alunoDao.getAll();
        aluno = new Aluno();
        return "gerenciar-alunos.xhtml";
    }
    
}
