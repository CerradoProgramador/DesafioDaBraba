import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nomeCliente = "Pedro Pires Mangueira";
        String tipoCliente = "Corrente";
        double saldoCliente = 2500;
        double opcao = 0;

        String menuInicial = """
                ***************************
                Dados Iniciais do Cliente
                
                Nome:          %s
                Tipo conta:    %s
                Saldo Inicial: %.2f
                ***************************
                """.formatted(nomeCliente, tipoCliente, saldoCliente);

        System.out.println(menuInicial);

        String opcoesMenuInicial = """
                ***************************
                
                1 - Consultar Saldos
                2 - Transferir Valor
                3 - Receber Valor
                4 - Sair
                
                """;



        Scanner leitura = new Scanner(System.in);

        while (opcao != 4 ) {
            System.out.println(opcoesMenuInicial);
            opcao = leitura.nextInt();
            if (opcao == 1) {
                System.out.println("O seu saldo é de " + saldoCliente);
            }else if (opcao == 2){
                System.out.println("Digite o valor que deseja transferir");
                double valor = leitura.nextDouble();
                if (valor > saldoCliente){
                    System.out.println("O valor que deseja transferir é maior que o saldo da sua conta");
                    break;
                } else{
                    System.out.println("Deseja imprimir sua notinha Sim(1) ou Não(2)");
                    int notinha = leitura.nextInt();
                    if (notinha == 1){
                        System.out.println("Imprimindo Notinha");
                    }
                    saldoCliente -= valor;
                    System.out.println(String.format(
                            """
                                    Muito obrigado pela transfêrencia.
                                    Foi removido %.2f da sua conta
                                    """, valor
                    ));
                }
            }else if (opcao == 3) {
                System.out.println("Esse é o seu PIX-CHAVE-RANDOM" +
                        "-AS-1-3-13JKAKDA13D" +
                        " Agora Digite o Valor que vai receber!" +
                        "");
                double LeituraQR = leitura.nextDouble();
                System.out.println(String.format("O valor que deseja receber é este valor? %.2f ", LeituraQR));
                System.out.println("Para aceitar o valor digite (1) e para negar (2)");
                String confirmeValor  = leitura.next();
                if (!confirmeValor.equals("1")) {
                    System.out.println("A negociação será negada e o dinheiro vai ser devolvido a conta remetente.");
                }
                System.out.println(String.format("PIX Transferido de João da Costa no valor de %.2f foi adicionado a sua Conta", LeituraQR));
                saldoCliente += LeituraQR;
            } else if (opcao != 4) {
                System.out.println("Opção Finalizada");
            }
        }
    }
}