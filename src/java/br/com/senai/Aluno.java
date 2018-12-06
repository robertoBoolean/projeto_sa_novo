package br.com.senai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Eduardo
 * @author Rafael
 * @author Roberto
 * @version 1.0
 * @since Java 5.0
 */
@Entity
public class Aluno implements Serializable{
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String matricula;
    private Date nascimento;
    private String turma;
    
    @JoinColumn(name = "turma_id")
    @ManyToOne
    private Turma turmaR;
    
    @OneToMany(mappedBy = "aluno")
    private List<Guarita> guaritas = new ArrayList<>();

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public List<Guarita> getGuaritas() {
        return guaritas;
    }

    public void setGuaritas(List<Guarita> guaritas) {
        this.guaritas = guaritas;
    }

    public Turma getTurmaR() {
        return turmaR;
    }

    public void setTurmaR(Turma turmaR) {
        this.turmaR = turmaR;
    }
    
    
  
}
