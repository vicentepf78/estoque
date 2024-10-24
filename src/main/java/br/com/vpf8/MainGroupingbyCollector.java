package br.com.vpf8;

import br.com.vpf8.groupingby.collector.BlogPost;
import br.com.vpf8.groupingby.collector.BlogPostType;
import br.com.vpf8.groupingby.collector.Tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainGroupingbyCollector {

    private static final List<BlogPost> posts = Arrays.asList(new BlogPost("News item 1", "Author 1", BlogPostType.NEWS, 15), new BlogPost("Tech review 1", "Author 2", BlogPostType.REVIEW, 5),
            new BlogPost("Programming guide", "Author 1", BlogPostType.GUIDE, 20), new BlogPost("News item 2", "Author 2", BlogPostType.NEWS, 35), new BlogPost("Tech review 2", "Author 1", BlogPostType.REVIEW, 15));


    public static void main(String[] args) {

        //2.2. Agrupamento Simples por uma Única Coluna
//        agrupamentoSimplesPorUmaUnicaColuna();

        //2.3. groupingBy com um tipo de chave de mapa complexo
        // Para agrupar usando dois campos como chaves, podemos usar a classe Pair fornecida nos pacotes javafx.util  ou  org.apache.commons.lang3.tuple  .
//        groupingByComUmTipoDeChaveDeMapaComplexo();

        //Similarmente, podemos usar a classe Tuple definida antes, essa classe pode ser facilmente generalizada para incluir mais campos conforme necessário. O exemplo anterior usando uma instância Tuple será:
        groupingByComClasseTuple();

        //Agora é muito simples agrupar o BlotPost na lista por tipo, autor e curtidas usando a instância do registro :
//        groupingByComRecordAuthPostTypesLikes();


        //2.4. Modificando o tipo de valor do mapa retornado



    }

    private static void groupingByComRecordAuthPostTypesLikes() {
        Map<BlogPost.AuthPostTypesLikes, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new BlogPost.AuthPostTypesLikes(post.getAuthor(), post.getType(), post.getLikes())));

        postsPerTypeAndAuthor.entrySet().stream()
                .map(entry -> "Chave -> " + entry.getKey() + ", Valores -> " + entry.getValue())
                .forEach(System.out::println);
    }

    private static void groupingByComClasseTuple() {
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));

        postsPerTypeAndAuthor.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("Chave -> " + entry.getKey());
                    System.out.println("Valores -> " + entry.getValue());
                });
    }

    private static void groupingByComUmTipoDeChaveDeMapaComplexo() {
        Map<Pair<BlogPostType, String>, List<BlogPost>> postsPerTypeAndAuthor = posts.stream()
                .collect(Collectors.groupingBy(post -> new ImmutablePair(post.getType(), post.getAuthor())));

        postsPerTypeAndAuthor.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("Chave : " + entry.getKey());
                    System.out.println("Valores : " + entry.getValue());
                });
    }

    private static void agrupamentoSimplesPorUmaUnicaColuna() {
        Map<BlogPostType, List<BlogPost>> blogPostTypeListMap = posts.stream()
                .collect(Collectors.groupingBy(BlogPost::getType));

        System.out.println(blogPostTypeListMap);
    }
}
