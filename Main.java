import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Perguntar saldo
        String valorStr = JOptionPane.showInputDialog(null,
                "Digite o valor que deseja gastar (ex: 200.00):",
                "Valor de Compra", JOptionPane.QUESTION_MESSAGE);

        if (valorStr == null || valorStr.isEmpty())
            return;
        BigDecimal saldoInicial = new BigDecimal(valorStr);

        // Catálogo
        List<Game> catalogo = new ArrayList<>();
        catalogo.add(new Game("FIFA 24", precoAleatorio(random), "Esporte", 0,
                new Desenvolvedor("EA Sports", "Electronic Arts")));
        catalogo.add(
                new Game("GTA V", precoAleatorio(random), "Ação", 18, new Desenvolvedor("Rockstar", "Rockstar Games")));
        catalogo.add(new Game("Minecraft", precoAleatorio(random), "Aventura", 0,
                new Desenvolvedor("Markus Persson", "Mojang")));
        catalogo.add(
                new Game("The Witcher 3", precoAleatorio(random), "RPG", 18, new Desenvolvedor("CDPR", "CD Projekt")));
        catalogo.add(new Game("Stardew Valley", precoAleatorio(random), "Simulação", 0,
                new Desenvolvedor("ConcernedApe", "Indie")));

        // Aplicar desconto em RPG
        for (Game g : catalogo) {
            if (g.getCategoria().equalsIgnoreCase("RPG")) {
                g.setPreco(g.aplicarDesconto(20).doubleValue()); // 20% desconto
            }
        }

        // Filtro de categoria
        String filtroCategoria = JOptionPane.showInputDialog("Digite a categoria para filtrar (ou vazio):");
        List<Game> filtrados = catalogo.stream()
                .filter(g -> filtroCategoria.isEmpty() || g.getCategoria().equalsIgnoreCase(filtroCategoria))
                .toList();

        // Criar cliente
        Cliente cliente = new Cliente("Lipe", "lipe@email.com", saldoInicial);
        cliente.comprarMaximo(filtrados);

        // Avaliar os jogos comprados
        for (Game g : cliente.getGamesComprados()) {
            String nota = JOptionPane.showInputDialog("Avalie " + g.getNome() + " (1 a 5):");
            if (nota != null && !nota.isEmpty()) {
                g.setAvaliacao(Integer.parseInt(nota));
            }
        }

        // Exibir resumo
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Jogos comprados:\n");
        cliente.getGamesComprados().forEach(g -> sb.append(" - ").append(g).append("\n"));

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(area), "Resumo", JOptionPane.INFORMATION_MESSAGE);

        // Salvar compras
        Persistencia.salvarCompras(cliente.getGamesComprados());
    }

    private static double precoAleatorio(Random random) {
        return 20 + (150 - 20) * random.nextDouble();
    }
}
