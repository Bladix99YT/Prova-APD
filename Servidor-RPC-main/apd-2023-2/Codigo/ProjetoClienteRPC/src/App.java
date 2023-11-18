import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // DEFINE A URL DO SERVIDOR
        String urlServ = "http://localhost:8185"; // Ao invés de localhost, coloque o IP da máquina servidor se quiser fazer o papel apenas de cliente
        ClienteRPC rpc = new ClienteRPC(urlServ);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu de Operações:");
            System.out.println("1. Reajuste Salarial");
            System.out.println("2. Valor Carro");
            System.out.println("3. Consumo Combustivel");
            System.out.println("4. Sair");
            System.out.print("Escolha uma operação: ");

            int escolha = scanner.nextInt(); //Variável que armazena em memória a escolha da opção do menu

            if (escolha == 14) {
                System.out.println("Saindo do programa. Adeus!");
                break;
            }

            int x, y; // Variavéis que armazenam os numeros para os cálculos. 
            double resultado = 0; // Variavél que armazena o resultado dos cálculos este que contém o resultado dos cálculos no servidor RPC.

            switch (escolha) {
                case 1:
                    System.out.print("Digite o salário base: ");
                    x = scanner.nextInt();
                    System.out.print("Digite o percentual de aumento: ");
                    y = scanner.nextInt();
                    resultado = rpc.ReajusteSalarial(x, y);
                    break;
                case 2:
                    System.out.print("Digite o valor de fabrica: ");
                    x = scanner.nextInt();
                    System.out.print("Digite o total de impostos aplicados (fabrica e distribuidor): ");
                    y = scanner.nextInt();
                    resultado = rpc.ValorCarro(x, y);
                    
                    break;
                case 3:
                    System.out.print("Digite a distancia percorrida: ");
                    x = scanner.nextInt();
                    System.out.print("Digite os litros de combustivel abastecido: ");
                    y = scanner.nextInt();
                    resultado = rpc.ConsumoCombustivel(x, y);
                    break;
               
                default:
                    System.out.println("Opção inválida. Escolha novamente."); // caso nenhuma das opções selecionadas seja válida
            }

            System.out.println("Resultado: \n" + resultado); // Saida do terminal mais a váriavel de 
                                                                //cada resultado dependendo do calculo
        }                                                         // fica logo abaixo da operação.

        scanner.close();
    }
}
