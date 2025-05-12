// Trabalho de Estruturas de Dados 

import java.util.ArrayList;
import java.util.Random;

public class App {

    public static String gerarPalavraAleatoria(int tamanhoMin, int tamanhoMax) {
        Random random = new Random();
        int tamanho = random.nextInt(tamanhoMax - tamanhoMin + 1) + tamanhoMin;
        StringBuilder palavra = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            // Gera um caractere aleatório entre 'a' (97) e 'z' (122)
            char letra = (char) (random.nextInt(26) + 97);
            palavra.append(letra);
        }
        return palavra.toString();
    
    
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        int indice = Math.abs(palavra.hashCode()) % tam;
        return tabelaHash[indice].contains(palavra);
    }

    public static void main(String[] args) {
        // Exemplo de uso
        int tamanhoMin = 3;
        int tamanhoMax = 10;
        String palavraAleatoria = gerarPalavraAleatoria(tamanhoMin, tamanhoMax);
        System.out.println("Palavra aleatória gerada: " + palavraAleatoria);

        // Exemplo de tabela hash
        int tam = 10;
        @SuppressWarnings("unchecked")
        ArrayList<String>[] tabelaHash = (ArrayList<String>[]) new ArrayList[tam];
        for (int i = 0; i < tam; i++) {
            tabelaHash[i] = new ArrayList<>();
        }

        // Adicionando palavras à tabela hash
        tabelaHash[0].add("exemplo");
        tabelaHash[1].add("teste");
        tabelaHash[2].add("palavra");
        tabelaHash[3].add("java");

        // Buscando uma palavra na tabela hash

        String palavraParaBuscar = "teste";
        boolean encontrada = buscarPalavra(palavraParaBuscar, tabelaHash, tam);
        if (encontrada) {
            System.out.println("A palavra '" + palavraParaBuscar + "' foi encontrada na tabela hash.");
        } else {
            System.out.println("A palavra '" + palavraParaBuscar + "' não foi encontrada na tabela hash.");
        }

        // Buscando uma palavra que não está na tabela hash
        String palavraNaoEncontrada = "naoexiste";
        boolean naoEncontrada = buscarPalavra(palavraNaoEncontrada, tabelaHash, tam);
        if (naoEncontrada) {
            System.out.println("A palavra '" + palavraNaoEncontrada + "' foi encontrada na tabela hash.");
        } else {
            System.out.println("A palavra '" + palavraNaoEncontrada + "' não foi encontrada na tabela hash.");
        }


    }
}