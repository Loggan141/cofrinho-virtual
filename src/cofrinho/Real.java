package cofrinho;

public class Real extends Moeda{
    @Override
    double converter() {
        return getValor()*1;
    }

    @Override
    public void info() {
        System.out.println("Real : "+getValor());
    }
}
