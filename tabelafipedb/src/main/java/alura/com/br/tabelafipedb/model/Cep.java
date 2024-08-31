package alura.com.br.tabelafipedb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cep")
public class Cep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;
    public Cep(){}
    public Cep(PassarCep passarCep) {
        this.cep = passarCep.cep();
        this.bairro = passarCep.bairro();
        this.ddd = passarCep.ddd();
        this.uf = passarCep.uf();
        this.localidade = passarCep.localidade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ddd='" + ddd + '\'';
    }
}
