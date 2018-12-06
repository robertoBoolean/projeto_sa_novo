package br.com.senai.ManagedBean;

import br.com.senai.Coordenador;
import br.com.senai.dao.CoordenadorDao;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "coordenadorBean")
@SessionScoped
public class CoordenadorBean implements Serializable {

    private Coordenador coordenador = new Coordenador();
    private CoordenadorDao CoordenadorDao = new CoordenadorDao();
    private List<Coordenador> coordenadores = CoordenadorDao.getAll();

    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String adicionarCoordenador() {
        CoordenadorDao.salvar(coordenador);
        coordenador = new Coordenador();
        coordenadores = CoordenadorDao.getAll();
        return "gerenciar-coordenadores.xhtml";
    }

    public String cancelarCoordenador() {
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

    public String editCoordenador() {
        return "editar-coordenadores.xhtml";
    }

    public String excluirCoordenador() {
        CoordenadorDao.excluir(coordenador);
        coordenadores = CoordenadorDao.getAll();
        coordenador = new Coordenador();
        return "gerenciar-coordenadores.xhtml";
    }

    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        for (Coordenador coordenacao : coordenadores) {
            if (usuario != null && usuario.equals(coordenacao.getUsuario()) && senha != null && senha.equals(coordenacao.getSenha())) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", usuario);
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "Credenciais incorretas");
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }
}
