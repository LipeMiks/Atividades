import javax.swing.*;

public class SomaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Simples");
        JTextField campo1 = new JTextField(5);
        JTextField campo2 = new JTextField(5);

        JButton botaoSomar = new JButton("Somar");
        JButton botaoSubtrair = new JButton("Subtrair");
        JButton botaoMultiplicar = new JButton("Multiplicar");
        JButton botaoDividir = new JButton("Dividir");

        JLabel resultado = new JLabel("Resultado:      ");

        // Ações dos botões
        botaoSomar.addActionListener(e -> {
            int soma = Integer.parseInt(campo1.getText()) + Integer.parseInt(campo2.getText());
            resultado.setText("Resultado: " + soma);
        });

        botaoSubtrair.addActionListener(e -> {
            int subtracao = Integer.parseInt(campo1.getText()) - Integer.parseInt(campo2.getText());
            resultado.setText("Resultado: " + subtracao);
        });

        botaoMultiplicar.addActionListener(e -> {
            int multiplicacao = Integer.parseInt(campo1.getText()) * Integer.parseInt(campo2.getText());
            resultado.setText("Resultado: " + multiplicacao);
        });

        botaoDividir.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(campo1.getText());
                double num2 = Double.parseDouble(campo2.getText());
                if (num2 == 0) {
                    resultado.setText("Erro: divisão por zero");
                } else {
                    double divisao = num1 / num2;
                    resultado.setText("Resultado: " + divisao);
                }
            } catch (NumberFormatException ex) {
                resultado.setText("Entrada inválida");
            }
        });

        JPanel panel = new JPanel();
        panel.add(campo1);
        panel.add(campo2);
        panel.add(botaoSomar);
        panel.add(botaoSubtrair);
        panel.add(botaoMultiplicar);
        panel.add(botaoDividir);
        panel.add(resultado);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
