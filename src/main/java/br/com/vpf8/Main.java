package br.com.vpf8;

import br.com.vpf8.dados.MovimentoEstoqueCollection;
import br.com.vpf8.estoque.movimento.MovimentoEstoque;
import br.com.vpf8.estoque.movimento.OperacaoEnum;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        MovimentoEstoqueCollection.criarMovimentoEstoque();
        List<MovimentoEstoque> movimentoEstoques = MovimentoEstoqueCollection.getMovimentoEstoques();
//        forEach(movimentoEstoques);
//        mapMovimentoNegativoSortedDataMovimento(movimentoEstoques);
//        filterOperacaoVendaSortedDataMovimento(movimentoEstoques);
//        groupingBy(movimentoEstoques);
//        partitioningBy(movimentoEstoques);
        fornecedorAcumulacaoCombinacao(movimentoEstoques);
    }

    private static void fornecedorAcumulacaoCombinacao(List<MovimentoEstoque> movimentoEstoques) {
        Map<String, BigDecimal> stringBigDecimalMap = movimentoEstoques.stream()
                .collect(Collectors.toMap(mov -> DateTimeFormatter.ofPattern("yyyy-MM-dd").format(mov.getDataMovimento()),
                        MovimentoEstoque::valorMovimento,
                        BigDecimal::add
                ));

        System.out.println(stringBigDecimalMap);
    }

    private static void partitioningBy(List<MovimentoEstoque> movimentoEstoques) {
        Map<Boolean, List<MovimentoEstoque>> booleanListMap = movimentoEstoques.stream()
                .collect(Collectors.partitioningBy(mov -> mov.getOperacao().equals(OperacaoEnum.VENDA)));

        System.out.println(booleanListMap);
    }

    private static void groupingBy(List<MovimentoEstoque> movimentoEstoques) {
        Map<String, List<MovimentoEstoque>> listMap = movimentoEstoques.stream()
                .filter(item -> item.getOperacao().compareTo(OperacaoEnum.VENDA) == 0)
                .collect(Collectors.groupingBy(mov -> mov.getProduto() + " - " + mov.getDataMovimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        System.out.println(listMap);
    }

    private static void filterOperacaoVendaSortedDataMovimento(List<MovimentoEstoque> movimentoEstoques) {
        List<MovimentoEstoque> movimentoEstoqueList = movimentoEstoques.stream()
                .filter(item -> item.getOperacao().compareTo(OperacaoEnum.VENDA) == 0)
                .sorted(Comparator.comparing(MovimentoEstoque::getDataMovimento))
                .toList();

        movimentoEstoqueList
                .forEach(System.out::println);

    }

    private static void mapMovimentoNegativoSortedDataMovimento(List<MovimentoEstoque> movimentoEstoques) {
        List<MovimentoEstoque> movimentoEstoqueList = movimentoEstoques.stream()
                .map(MovimentoEstoque::movimentoNegativo)
                .sorted(Comparator.comparing(MovimentoEstoque::getDataMovimento))
                .toList();

        movimentoEstoqueList
                .forEach(System.out::println);
    }

    private static void forEach(List<MovimentoEstoque> movimentoEstoques) {
        movimentoEstoques.stream().forEach(System.out::println);
    }


    private static BigDecimal calcular(MovimentoEstoque mov) {
        String data = String.valueOf(mov.getDataMovimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        BigDecimal soma = mov.getQuantidade();
        if (String.valueOf(mov.getDataMovimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))).equals(mov.getDataMovimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
            BigDecimal quantidade = mov.getQuantidade();
            if (mov.getOperacao().equals(OperacaoEnum.VENDA)) {
                quantidade = quantidade.negate();
            }
            soma = soma.add(quantidade);
        } else {
            soma = mov.getQuantidade();
        }
        return soma;
    }


}

class SaldoEstoque {
    private String data;
    private BigDecimal quantidade;
    private BigDecimal valor;

    private SaldoEstoque(final String data, final BigDecimal quantidade, final BigDecimal valor) {
        this.data = data;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public static SaldoEstoque newSaldoEstoque(final String data, final BigDecimal quantidade, final BigDecimal valor) {
        return new SaldoEstoque(data, quantidade, valor);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "SaldoEstoque{" +
                "data=" + data +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}