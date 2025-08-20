import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Game {
    private String nome;
    private BigDecimal preco;
    private String categoria;
    private int classificacaoEtaria;
    private int avaliacao; // 1 a 5 estrelas
    private Desenvolvedor dev;

    private static final Locale PT_BR = new Locale("pt", "BR");
    private static final NumberFormat MOEDA = NumberFormat.getCurrencyInstance(PT_BR);

    public Game(String nome, double preco, String categoria, int classificacaoEtaria, Desenvolvedor dev) {
        this.nome = nome;
        this.preco = BigDecimal.valueOf(preco);
        this.categoria = categoria;
        this.classificacaoEtaria = classificacaoEtaria;
        this.dev = dev;
        this.avaliacao = 0; // padrão: sem avaliação
    }

    public String getNome() { return nome; }
    public BigDecimal getPreco() { return preco; }
    public String getCategoria() { return categoria; }
    public int getClassificacaoEtaria() { return classificacaoEtaria; }
    public Desenvolvedor getDev() { return dev; }

    public void setPreco(double valor) {
        if (valor >= 0) this.preco = BigDecimal.valueOf(valor);
    }

    // Avaliação
    public void setAvaliacao(int avaliacao) {
        if (avaliacao >= 1 && avaliacao <= 5) this.avaliacao = avaliacao;
    }

    public String getAvaliacaoEstrelas() {
        return "★".repeat(avaliacao) + "☆".repeat(5 - avaliacao);
    }

    // Desconto
    public BigDecimal aplicarDesconto(double percentual) {
        if (percentual < 0 || percentual > 100) return preco;
        BigDecimal desconto = preco.multiply(BigDecimal.valueOf(percentual / 100.0));
        return preco.subtract(desconto);
    }

    @Override
    public String toString() {
        return String.format("%s — %s (%s, %d+) | Dev: %s | Avaliação: %s",
                nome, MOEDA.format(preco), categoria, classificacaoEtaria,
                dev != null ? dev.toString() : "N/A",
                getAvaliacaoEstrelas());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
