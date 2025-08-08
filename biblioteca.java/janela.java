import javax.swing.*;
public class janela{
    public static void main(String[] args){
        JFrame janela = new JFrame ("janela");

        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);


    }
}