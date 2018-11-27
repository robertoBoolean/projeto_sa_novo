package br.com.senai.ManagedBean;

import br.com.senai.Coordenador;
import br.com.senai.dao.CoordenadorDao;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
    
@ManagedBean(name = "coordenadorBean")
@SessionScoped
public class CoordenadorBean implements Serializable{
    private Coordenador coordenador = new Coordenador();
    private CoordenadorDao CoordenadorDao = new CoordenadorDao();
    private List<Coordenador> coordenadores = CoordenadorDao.getAll();
    
    public String adicionarCoordenador(){
        CoordenadorDao.salvar(coordenador);
        coordenador = new Coordenador();
        coordenadores = CoordenadorDao.getAll();
        return "gerenciar-coordenadores.xhtml";
    }
    
     public String cancelarCoordenador(){
        coordenador = new Coordenador();
        return "gerenciar-coordenadores.xhtml";
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public List<Coordenador> getCoordenadores() {
        return coordenadores;
    }

    public void setCoordenadores(List<Coordenador> coordenadores) {
        this.coordenadores = coordenadores;
    }

     
    public String editCoordenador(){
        return "editar-coordenadores.xhtml";
    }
    public String excluirCoordenador(){
        CoordenadorDao.excluir(coordenador);
        coordenadores = CoordenadorDao.getAll();
        coordenador = new Coordenador();
        return "gerenciar-coordenadores.xhtml";
    }
    
}

