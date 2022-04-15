public class PessoaFisica extends Cliente{
    
    String cpf;

    public PessoaFisica(String nome, String cpf){
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "{nome: " + this.getNome() + ", cpf: " + this.cpf + "}";
    }

    public String getCpf() {
        return cpf;
    }
}
