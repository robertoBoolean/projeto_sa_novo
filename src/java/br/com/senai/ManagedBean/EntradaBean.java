package br.com.senai.ManagedBean;

import br.com.senai.SituacaoGuarita;
import br.com.senai.dao.EntradaDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "entradaBean")
@SessionScoped
public class EntradaBean implements Serializable {

    private EntradaDao entradaDao = new EntradaDao();
    private String matricula;

    public void realizarEntrada() {
        SituacaoGuarita guarita = entradaDao.realizarEntrada(getMatricula());
        saveMessage(guarita);
        matricula = null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void saveMessage(SituacaoGuarita situacaoGuarita) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (situacaoGuarita.equals(SituacaoGuarita.ENTRADA)) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Entrada registrada!"));
        }
        if (situacaoGuarita.equals(SituacaoGuarita.SAIDA)) {
            context.addMessage(null, new FacesMessage("Sucesso!", "Saida registrada!"));
        }
        if (situacaoGuarita.equals(SituacaoGuarita.FORA_HORARIO)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!", "Horário não permitido!"));
        }
        if (situacaoGuarita.equals(SituacaoGuarita.MATRICULA_NAO_ENCONTRADA)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Matricula não encontrada"));
        }
        if (situacaoGuarita.equals(SituacaoGuarita.DOIS_REGISTRO)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso!", "O Aluno informado ja possui dois registros no dia de hoje!"));
        }

    }

}
