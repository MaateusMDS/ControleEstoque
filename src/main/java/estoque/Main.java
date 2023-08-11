package estoque;

import estoque.model.Produto;
import estoque.repository.Repository;
import estoque.repository.RepositoryProduto;
import jakarta.persistence.Persistence;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
                var escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção: \n" +
                        "1 - Cadastrar produto \n" +
                        "2 - Listar produtos \n" +
                        "3 - Buscar produto \n" +
                        "4 - Atualizar produto \n" +
                        "5 - Remover produto \n" +
                        "6 - Sair"));

                if (escolha == 1) {
                    var nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                    var descricao = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                    var preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
                    var produto = new Produto(nome, descricao, preco);
                    RepositoryProduto.salvarProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                } else if (escolha == 2) {
                    var produtos = RepositoryProduto.listarProdutos();
                    produtos.forEach(Produto::toModal);

                } else if (escolha == 3) {
                    var id = Long.parseLong(JOptionPane.showInputDialog("Digite o id do produto: "));
                    var produto = RepositoryProduto.buscarProduto(id);
                    produto.toModal();
                } else if (escolha == 4) {
                    var id = Long.parseLong(JOptionPane.showInputDialog("Digite o id do produto: "));
                    var produto = RepositoryProduto.buscarProduto(id);
                    var nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                    var descricao = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                    var preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
                    produto.setNome(nome);
                    produto.setDescricao(descricao);
                    produto.setPreco(preco);
                    RepositoryProduto.atualizarProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                } else if (escolha == 5) {
                    var id = Long.parseLong(JOptionPane.showInputDialog("Digite o id do produto: "));
                    RepositoryProduto.removerProduto(id);
                } else if (escolha == 6) {
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}