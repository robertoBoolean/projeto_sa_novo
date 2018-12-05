package br.com.senai;

import java.io.Serializable;
/*import java.util.Date;*/
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
/**
 * 
 * @author Jose 
 * @author Leticia
 * @author Renato
 * @version 2.1
 * @since java 7.0
 * @see Aluno    
 * @see GradeHorario
 * Classe de Entidade Turma, onde são instaciados os valores.
 * 
 */


@Entity
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @ManyToOne
    GradeHorario gradeHorario;
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public GradeHorario getGradeHorario() {
        return gradeHorario;
    }

    public void setGradeHorario(GradeHorario gradeHorario) {
        this.gradeHorario = gradeHorario;
    }
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }
        
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}