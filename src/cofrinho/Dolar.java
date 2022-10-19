package cofrinho;

public class Dolar extends Moeda{

    @Override
    double converter() {
        return getValor()*5;
    }

    @Override
    public void info() {
        System.out.println("Dolar : "+getValor());
    }
}
