package estoque.repository;

import estoque.model.Produto;

import javax.swing.*;
import java.util.List;

public class RepositoryProduto extends Repository {

    public static Produto salvarProduto(Produto produto) {
        try {
            manager.getTransaction().begin();
            manager.persist(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        return produto;
    }

    public static Produto buscarProduto(Long id) {
        return manager.find(Produto.class, id);
    }

    public static List<Produto> listarProdutos() {
        return manager.createQuery("FROM " + Produto.class.getName()).getResultList();
    }

    public static Produto atualizarProduto(Produto produto) {
        try {
            manager.getTransaction().begin();
            manager.merge(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
        return produto;
    }

    public static void removerProduto(Long id) {
        try {
            var produto = buscarProduto(id);
            if (produto != null) {
                manager.getTransaction().begin();
                manager.remove(produto);
                manager.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            }
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }
}
