package cofrinho;

public class Euro extends Moeda{
    @Override
    double converter() {
        return getValor() * 6;
    }
    @Override
    public void info() {
        System.out.println("Euro : "+getValor());
    }
}
