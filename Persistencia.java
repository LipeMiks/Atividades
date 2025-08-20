import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    public static void salvarCompras(List<Game> games) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("compras.txt"))) {
            for (Game g : games) {
                pw.println(g.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> carregarCompras() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("compras.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}
