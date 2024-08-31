package br.com.alura.TabelaFipe.model;

import jakarta.persistence.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

@Entity
@Table(name = "veiculos")
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String valor;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private String combustivel;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    public Veiculos(){}
    public Veiculos(Veiculo veiculo) {
        this.valor = veiculo.valor();
        this.marca = veiculo.marca();
        this.modelo = veiculo.modelo();
        this.anoModelo = veiculo.anoModelo();
        this.combustivel = veiculo.combustivel();
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                '}';
    }
}
