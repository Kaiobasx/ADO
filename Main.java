import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaAtendimento filaLab = new FilaAtendimento();
        
        // --- CARGA INICIAL DE PACIENTES (Para não começar do zero) ---
        filaLab.enfileira(new Paciente("Seu Carlos", true));
        filaLab.enfileira(new Paciente("Dona Maria", true));
        filaLab.enfileira(new Paciente("Joao", false));
        filaLab.enfileira(new Paciente("Ana", false));
        System.out.println(">>> Sistema iniciado. Já existem " + filaLab.getQuantidadeAguardando() + " pacientes na fila. <<<");
        // -------------------------------------------------------------

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== TOTEM DO LABORATÓRIO ===");
            System.out.println("1 - Retirar Senha (Entrar na fila)");
            System.out.println("2 - Painel Médico: Chamar Próximo");
            System.out.println("3 - Exibir Fila Atual");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n>>> ERRO: Digite apenas o NÚMERO da opção. <<<");
                continue; 
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    String nome = scanner.nextLine();
                    
                    System.out.print("É atendimento PREFERENCIAL? (S/N): ");
                    String resposta = scanner.nextLine().toUpperCase();
                    boolean isPref = resposta.equals("S"); 
                    
                    // Pega o tamanho da fila ANTES da pessoa entrar para saber quantos estão na frente
                    int pessoasNaFrente = filaLab.getQuantidadeAguardando();
                    
                    Paciente novoPaciente = new Paciente(nome, isPref);
                    filaLab.enfileira(novoPaciente);
                    
                    System.out.println("\n>>> Senha gerada com sucesso! <<<");
                    System.out.println("Paciente: " + novoPaciente.toString());
                    
                    // Aviso de quantas pessoas estão na frente!
                    if (pessoasNaFrente == 0) {
                        System.out.println("Você é o próximo a ser atendido!");
                    } else {
                        System.out.println("Existem " + pessoasNaFrente + " pessoa(s) na sua frente.");
                    }
                    break;
                    
                case 2:
                    Paciente proximo = filaLab.chamarProximo();
                    if (proximo != null) {
                        System.out.println("\n>>> PAINEL: Chamando senha " + proximo.getSenhaFormatada() + " (" + proximo.getNome() + ") para a sala de coleta! <<<");
                    } else {
                        System.out.println("\n>>> A fila está vazia. Ninguém aguardando. <<<");
                    }
                    break;
                    
                case 3:
                    System.out.println("\nStatus atual da fila (" + filaLab.getQuantidadeAguardando() + " aguardando):");
                    if (filaLab.estaVazia()) {
                        System.out.println("Fila vazia.");
                    } else {
                        System.out.println(filaLab.toString());
                    }
                    break;
                    
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
    }
}