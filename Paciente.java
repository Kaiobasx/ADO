public class Paciente {
    
    private static int geradorDeSenha = 1; 
    
    private int numeroSenha;
    private String nome;
    private boolean preferencial;

    public Paciente(String nome, boolean preferencial) {
        this.nome = nome;
        this.preferencial = preferencial;
        
        this.numeroSenha = geradorDeSenha++; 
    }

    public String getNome() {
        return nome;
    }

    public boolean isPreferencial() {
        return preferencial;
    }
    
    public String getSenhaFormatada() {
        if (this.preferencial) {
            return "P-" + this.numeroSenha;
        } else {
            return "N-" + this.numeroSenha;
        }
    }

    @Override
    public String toString() {
        return "[" + getSenhaFormatada() + "] " + this.nome + (this.preferencial ? " (Preferencial)" : " (Normal)");
    }
}