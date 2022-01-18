package br.com.ecommerce.leatherShop.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 2, max = 15)
    private String blusa;

    @NotNull
    @Size(min = 2, max = 15)
    private String camiseta;

    @NotNull
    @Size(min = 2, max = 15)
    private String calca;

    @NotNull
    @Size(min = 2, max = 15)
    private String jaqueta;

    @NotNull
    @Size(min = 2, max = 15)
    private String sapato;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlusa() {
        return blusa;
    }

    public void setBlusa(String blusa) {
        this.blusa = blusa;
    }

    public String getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(String camiseta) {
        this.camiseta = camiseta;
    }

    public String getCalca() {
        return calca;
    }

    public void setCalca(String calca) {
        this.calca = calca;
    }

    public String getJaqueta() {
        return jaqueta;
    }

    public void setJaqueta(String jaqueta) {
        this.jaqueta = jaqueta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSapato() {
        return sapato;
    }

    public void setSapato(String sapato) {
        this.sapato = sapato;
    }


}

