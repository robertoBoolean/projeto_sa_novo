package br.com.senai.ManagedBean;

import br.com.senai.Aluno;
import br.com.senai.Curso;
import br.com.senai.dao.AlunoDao;
import br.com.senai.dao.CursoDao;
import br.com.senai.dao.EntradaDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Está classe é utilizade pelas telas para fazer o gerenciamento de Cursos onde chama o
 * @see CursoDao para realizar atividades no banco de dados
 * @author Aluno
 * @author Luis Henrique
 */
@ManagedBean(name = "cursoBean")
@SessionScoped
public class CursoBean implements Serializable{
    private Curso curso = new Curso();
    private CursoDao cursoDao = new CursoDao();
    private List<Curso> cursos = cursoDao.getAll();
    
    /**
     * Metodo para realizar o cancelamento de cadastro/edicao de Curso
     * @return String - retorna a tela de gerenciamento de curso
     * @see  CursoDao
     */
    public String cancelarCurso(){
        curso = new Curso();
        return "gerenciar-cursos.xhtml";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    /**
     * Metodo usada para entrar na tela de Edição de Curso
     * @return String - retorna a tela de edicao de curso
     */
    public String editCurso(){
        return "editar-cursos.xhtml";
    }
    
    /**
     * Metodo usado para Excluir um curso
     * @return String - retorna a tela de gerenciamento de curso
     */
    public String excluirCurso(){
        cursoDao.excluir(curso);
        cursos = cursoDao.getAll();
        curso = new Curso();
        return "gerenciar-cursos.xhtml";
    }
    
    /**
     * Metodo para adicionar um novo Curso
     * @return String - retorna a tela de gerenciamento de curso
     */
    public String adicionarCurso(){
        cursoDao.salvar(curso);
        curso = new Curso();
        cursos = cursoDao.getAll();
        return "gerenciar-cursos.xhtml";
    }
    
}
