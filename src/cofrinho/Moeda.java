package cofrinho;

public abstract class Moeda {

    private double valor;

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    protected Moeda() {
    }

    double converter() {
        return 0;
    }

    public void info() {
    }
}
