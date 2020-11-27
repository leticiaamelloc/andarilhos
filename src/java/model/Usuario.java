package model;

import enums.TipoUsuario;

public class Usuario extends Entity {

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Integer papel;
    private TipoUsuario tipo;
    private String cadastroAprovado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getPapel() {
        return papel;
    }

    public void setPapel(Integer papel) {
        this.papel = papel;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {

        this.tipo = tipo;
    }

    public String getCadastroAprovado() {
        return cadastroAprovado;
    }

    public void setCadastroAprovado(String cadastroAprovado) {
        this.cadastroAprovado = cadastroAprovado;
    }

}
