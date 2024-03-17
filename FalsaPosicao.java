import java.util.Scanner;

public class FalsaPosicao {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o número equivalente a A:");
        double a = s.nextDouble();

        System.out.println("Digite o número equivalente a B:");
        double b = s.nextDouble();

        double precisao = 0.01;

        long starTime = System.nanoTime();

        double raiz = falsaPosicao(a, b, precisao);

        long endTime = System.nanoTime();

        double contagem = (endTime - starTime) / 1e9;

        if (!Double.isNaN(raiz)) {
            System.out.println("A raiz é aproximadamente: " + raiz);
        } else {
            System.out.println("Não foi possível encontrar a raiz com a precisão desejada.");
        }

        System.out.println("O tempo de execução: " + contagem  + " segundos" );
        s.close();
    }

    public static double funcao(double x) {
        return Math.pow(x, 5) + 2 * Math.pow(x, 3) + 2 * x + 1;
    }

    public static double falsaPosicao(double a, double b, double precisao) {
        if (funcao(a) * funcao(b) >= 0) {
            System.out.println("A função não muda de sinal nos pontos a e b.");
            return Double.NaN;
        }
    
        double c = 0.0;
        int maxIteracoes = 1000; 
        int iteracao = 0; 
    
        while (Math.abs(b - a) >= precisao && iteracao < maxIteracoes) {
            c = (a * funcao(b) - b * funcao(a)) / (funcao(b) - funcao(a));
    
            if (funcao(c) == 0.0) {
                return c;
            } else if (funcao(c) * funcao(a) < 0) {
                b = c;
            } else {
                a = c;
            }
            
            iteracao++;
        }
    
        return c;
    }
    
}