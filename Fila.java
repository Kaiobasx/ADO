public class Fila<T> extends EstruturaEstatica<T> {

    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elemento) {
        this.adiciona(elemento);
    }

    public T espiar() {
        if (this.estaVazia()) {
            return null;
        }
        return this.obter(0);
    }

    public T desenfileira() {
        if (this.estaVazia()) {
            return null;
        }
        final int POS = 0; 
        T elementoASerRemovido = this.obter(POS);
        this.remove(POS); 
        return elementoASerRemovido;
    }
}