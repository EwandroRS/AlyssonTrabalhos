import java.util.*;

public class FeiraDeLivros {
    private static TreeSet<Livro> livros = new TreeSet<>();
    private static TreeMap<String, TreeSet<String>> autores = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            System.out.print("Título do livro: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor do livro: ");
            String autor = scanner.nextLine();

            System.out.print("Ano de publicação: ");
            int ano = Integer.parseInt(scanner.nextLine());

            Livro livro = new Livro(titulo, autor, ano);
            livros.add(livro);

            autores.putIfAbsent(autor, new TreeSet<>());
            autores.get(autor).add(titulo);

            System.out.print("Deseja adicionar outro livro? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        // Exibir todos os livros
        System.out.println("\nTodos os livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }

        // Exibir autores e seus livros
        System.out.println("\nAutores e seus livros:");
        for (Map.Entry<String, TreeSet<String>> entry : autores.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String titulo : entry.getValue()) {
                System.out.println("- " + titulo);
            }
        }

        scanner.close();
    }
}
