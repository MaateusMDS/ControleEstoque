package estoque.model;

import jakarta.persistence.*;

import javax.swing.*;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO")
    @Column(name = "ID_PRODUTO")
    private Long id;
    @Column(name = "NM_PRODUTO")
    private String nome;
    @Column(name = "DS_PRODUTO")
    private String descricao;
    @Column(name = "VL_PRODUTO")
    private double preco;

    public Produto() {
    }

    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    public void toModal() {

        var decimalFromat = new DecimalFormat("#.00");

        JOptionPane.showMessageDialog(null, "Nome: " + this.nome + "\n" +
                "Descrição: " + this.descricao + "\n" +
                "Preço: " + decimalFromat.format(this.preco) + "\n", "Produto - " + this.nome, INFORMATION_MESSAGE);
    }
}
