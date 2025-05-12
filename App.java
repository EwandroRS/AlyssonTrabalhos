import java.util.ArrayList;
import java.util.Random;

public class App {

    public static String gerarPalavraAleatoria(int tamanhoMin, int tamanhoMax) {
        Random random = new Random();
        int tamanho = random.nextInt(tamanhoMax - tamanhoMin + 1) + tamanhoMin;
        StringBuilder palavra = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            char letra = (char) (random.nextInt(26) + 97);
            palavra.append(letra);
        }
        return palavra.toString();
    }

    public static int funcaoHash(String palavra, int tam) {
        if (palavra == null || palavra.isEmpty()) {
            return 0;
        }
        return (palavra.toLowerCase().charAt(0) - 'a') % tam;
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        int indice = funcaoHash(palavra, tam);

        if (indice >= 0 && indice < tam && tabelaHash[indice] != null) {
            if (tabelaHash[indice].contains(palavra)) {
                System.out.println("Busca: Calculada categoria " + (char)('a' + indice) + " para a palavra '" + palavra + "'.");
                return true;
            } else {
                System.out.println("Busca: Calculada categoria " + (char)('a' + indice) + " para a palavra '" + palavra + "'. Palavra não encontrada nesta categoria.");
                return false;
            }
        } else {
            System.out.println("Busca: Calculada categoria " + (char)('a' + indice) + " para a palavra '" + palavra + "'. Categoria inválida.");
            return false;
        }
    }

    public static void main(String[] args) {
        int tamanhoMin = 3;
        int tamanhoMax = 10;
        String palavraAleatoria = gerarPalavraAleatoria(tamanhoMin, tamanhoMax);
        System.out.println("Palavra aleatória gerada: " + palavraAleatoria);

        int totalCategorias = 26;
        @SuppressWarnings("unchecked")
        ArrayList<String>[] tabelaHash = (ArrayList<String>[]) new ArrayList[totalCategorias];
        for (int i = 0; i < totalCategorias; i++) {
            tabelaHash[i] = new ArrayList<>();
        }

        Random random = new Random();
        String[] letras = "abcdefghijklmnopqrstuvwxyz".split("");
        for (String letra : letras) {
            for (int i = 0; i < 100; i++) {
                StringBuilder palavra = new StringBuilder(letra);
                int tamanhoPalavra = random.nextInt(tamanhoMax - 1) + 2;
                for (int j = 1; j < tamanhoPalavra; j++) {
                    palavra.append((char) (random.nextInt(26) + 97));
                }
                int indice = funcaoHash(palavra.toString(), totalCategorias);
                tabelaHash[indice].add(palavra.toString());
            }
        }

        String palavraBusca1 = "apple";
        if (buscarPalavra(palavraBusca1, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca1 + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca1 + "' não encontrada.");
        }

        String palavraBusca2 = "banana";
        if (buscarPalavra(palavraBusca2, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca2 + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca2 + "' não encontrada.");
        }

        String palavraNaoExistente = "xyzuvw";
        if (buscarPalavra(palavraNaoExistente, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraNaoExistente + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraNaoExistente + "' não encontrada.");
        }
    }
}
