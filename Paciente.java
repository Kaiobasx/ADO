public class Paciente {
    
    // Essa variável "static" pertence à classe toda. 
    // Ela começa em 1 e vai aumentando, garantindo que a senha nunca se repita
    private static int geradorDeSenha = 1; 
    
    private int numeroSenha;
    private String nome;
    private boolean preferencial;

    public Paciente(String nome, boolean preferencial) {
        this.nome = nome;
        this.preferencial = preferencial;
        
        // O paciente recebe o número atual do gerador, e depois o gerador soma +1
        this.numeroSenha = geradorDeSenha++; 
    }

    public String getNome() {
        return nome;
    }

    public boolean isPreferencial() {
        return preferencial;
    }
    
    // Um método para deixar a senha bonita!
    public String getSenhaFormatada() {
        if (this.preferencial) {
            return "P-" + this.numeroSenha;
        } else {
            return "N-" + this.numeroSenha;
        }
    }

    @Override
    public String toString() {
        // Agora, quando imprime, vai aparecer: [P-1] João (Preferencial)
        return "[" + getSenhaFormatada() + "] " + this.nome + (this.preferencial ? " (Preferencial)" : " (Normal)");
    }
}