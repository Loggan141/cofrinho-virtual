package cofrinho;

import java.util.List;
import java.util.Scanner;

public class Cofrinho {
    Scanner scan = new Scanner(System.in);
    int op;
    int opMoeda;
    double valor;
    Real real = new Real();
    Dolar dolar = new Dolar();
    Euro euro = new Euro();
    public Cofrinho() {}

    private List<Moeda> moedas = List.of(real, dolar, euro);

    public void listagemMoeda() {
        for (Moeda m : moedas) {
            m.info();
        }
        System.out.println();
    }

    public void adicionar(Moeda moeda, double valor) {
        moeda.setValor(moeda.getValor() + valor);
        System.out.println("Valor adicionado com sucesso!\n");
    }

    public void remover(Moeda moeda, double valor) {
        moeda.setValor(moeda.getValor() - valor);
        System.out.println("Valor removido com sucesso!\n");
    }

    public void totalConvertido(List<Moeda> moedas) {
        double total = 0;
        for (Moeda m : moedas) {
            total += m.converter();
        }
        System.out.println("Total convertido em reais : " + total +"\n");
    }

    public void menu() {
        do {
            msgOpcoes();    //Opcoes padroes do cofrinho
            op = scan.nextInt();
            dentroOpcoes(op); //Onde esta a lógica das opcoes
        } while (op != 0);

        System.out.println("Obrigado por utilizar o cofrinho virtual do Loggan");
    }

    private void dentroOpcoes(int opcao) {
        try {
            switch (opcao) {

                case 1 -> {         //Adicionar valor a moeda que for escolhida
                    opcoesMoedas();
                    opMoeda = scan.nextInt();
                    validacaoOp(opMoeda);
                    valorInserir();
                    adicionar(moedas.get(opMoeda - 1), valor);
                }
                case 2 -> {         //Remover valor a moeda que for escolhida
                    opcoesMoedas();
                    opMoeda = scan.nextInt();
                    validacaoOp(opMoeda);
                    valorInserir();
                    remover(moedas.get(opMoeda - 1), valor);

                }

                case 3 ->           //Listar as moedas existentes
                        listagemMoeda();
                case 4 ->           //Converter todas as moedas
                        totalConvertido(moedas);
            }
        } catch (Exception e) {
            System.out.println("Opção inválida.");
        }
    }
    private void valorInserir() {
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();
    }

    public void validacaoOp(int opcao) {
        if (opcao < 1 || opcao > 3)
            throw new RuntimeException();
    }

    public static void msgOpcoes() {
        System.out.println("Cofrinho: ");
        System.out.println("1 - Adicionar Moeda");
        System.out.println("2 - Remover Moeda");
        System.out.println("3 - Listar Moedas");
        System.out.println("4 - Total convertido para real");
        System.out.println("0 - Encerrar");
    }

    public void opcoesMoedas() {
        System.out.println("Escolha a Moeda: ");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");
    }

}
