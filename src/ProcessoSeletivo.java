
// André Sistema de Seleção de Candidatos 
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        System.out.println("Iniciando processo seletivo");

        avaliarCandidato(1500.0);
        avaliarCandidato(2100.0);
        avaliarCandidato(2300.0);

        System.out.println("\n-- Iniciando seleção de candidatos --");
        selecionarCandidatos();

        System.out.println("\n-- Imprimindo lista de selecionados --");
        imprimirCandidatos();

        String[] candidatos = { "Roberto", "Fernanda", "Mateus", "Juliana", "Paulo", "Mariana", "Thiago", "Beatriz",
                "Cláudia", "Marcelo" };
        for (String candidato : candidatos) {
            realizarContato(candidato);
        }
    }

    // Método que avalia o candidato com base no salário pretendido
    static void avaliarCandidato(double salarioPretendido) {
        double salarioVaga = 2000.0;
        if (salarioVaga > salarioPretendido) {
            System.out.println("Entrar em contato com o candidato.");
        } else if (salarioVaga == salarioPretendido) {
            System.out.println("Entrar em contato com o candidato com uma contraproposta.");
        } else {
            System.out.println("Aguardar outros candidatos.");
        }
    }

    // Método para seleção dos candidatos com base no salário pretendido
    static void selecionarCandidatos() {
        String[] listaCandidatos = { "Roberto", "Fernanda", "Mateus", "Juliana", "Paulo", "Mariana", "Thiago",
                "Beatriz", "Cláudia", "Marcelo" };
        int totalCandidatosSelecionados = 0;
        int indiceCandidato = 0;
        double salarioVaga = 2000.0;

        while (totalCandidatosSelecionados < 5 && indiceCandidato < listaCandidatos.length) {
            String candidato = listaCandidatos[indiceCandidato];
            double salarioPretendido = gerarSalarioPretendido();

            System.out.println("Candidato: " + candidato + " - Salário pretendido: " + salarioPretendido);

            if (salarioVaga >= salarioPretendido) {
                System.out.println(candidato + " foi selecionado para a vaga!");
                totalCandidatosSelecionados++;
            }

            indiceCandidato++;
        }
    }

    // Método para gerar um valor aleatório de salário pretendido
    static double gerarSalarioPretendido() {
        return ThreadLocalRandom.current().nextDouble(1500, 2500);
    }

    // Método que imprime a lista de candidatos
    static void imprimirCandidatos() {
        String[] listaCandidatos = { "Roberto", "Fernanda", "Mateus", "Juliana", "Paulo", "Mariana", "Thiago",
                "Beatriz", "Cláudia", "Marcelo" };
        System.out.println("Imprimindo a lista de candidatos:");

        for (int i = 0; i < listaCandidatos.length; i++) {
            System.out.println("Candidato nº " + (i + 1) + ": " + listaCandidatos[i]);
        }
    }

    // Método que simula uma tentativa de contato com o candidato
    static void realizarContato(String candidato) {
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = tentarContato();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativas++;
            } else {
                System.out.println("Contato realizado com sucesso!");
            }
        } while (continuarTentando && tentativas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " após " + tentativas + " tentativas.");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + " após " + tentativas + " tentativas.");
        }
    }

    // Método que simula a resposta ao contato (aleatório)
    static boolean tentarContato() {
        return new Random().nextInt(3) == 1; // Retorna verdadeiro 1/3 das vezes
    }
}
