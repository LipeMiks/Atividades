public class Desenvolvedor {
    private String nome;
    private String empresa;

    public Desenvolvedor(String nome, String empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    public String getNome() { return nome; }
    public String getEmpresa() { return empresa; }

    @Override
    public String toString() {
        return nome + " (" + empresa + ")";
    }
}
