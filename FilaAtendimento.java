public class FilaAtendimento extends Fila<Paciente> {
    
    private int contPreferencialAtendidos = 0;

    @Override
    public void enfileira(Paciente p) {
        if (!p.isPreferencial()) {
            super.enfileira(p); 
        } else {
            int posicao = 0;
            for (int i = 0; i < this.tamanho(); i++) {
                if (!this.obter(i).isPreferencial()) {
                    break; 
                }
                posicao++;
            }
            super.adiciona(posicao, p);
        }
    }

    private int buscarIndicePrimeiroNormal() {
        for (int i = 0; i < this.tamanho(); i++) {
            if (!this.obter(i).isPreferencial()) {
                return i; 
            }
        }
        return -1; 
    }

    public Paciente chamarProximo() {
        if (this.estaVazia()) {
            return null; 
        }

        Paciente primeiroDaFila = this.espiar();

        if (contPreferencialAtendidos >= 3 || !primeiroDaFila.isPreferencial()) {
            
            int posNormal = buscarIndicePrimeiroNormal();
            
            if (posNormal != -1) {
                Paciente pacienteNormal = this.obter(posNormal);
                this.remove(posNormal); 
                this.contPreferencialAtendidos = 0; 
                return pacienteNormal;
            } else {
                this.contPreferencialAtendidos++;
                return this.desenfileira();
            }
            
        } else {
            this.contPreferencialAtendidos++;
            return this.desenfileira();
        }
    }

    public int getQuantidadeAguardando() {
        return this.tamanho();
    }
}