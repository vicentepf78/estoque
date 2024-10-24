package br.com.vpf8.dados;

import br.com.vpf8.estoque.movimento.MovimentoEstoque;
import br.com.vpf8.estoque.movimento.OperacaoEnum;
import br.com.vpf8.estoque.movimento.TipoClienteEnum;
import br.com.vpf8.estoque.movimento.TipoOperacaoEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class MovimentoEstoqueCollection {

    private static final List<MovimentoEstoque> movimentoEstoques = new ArrayList<MovimentoEstoque>();

    private MovimentoEstoqueCollection() {
    }

    public static void criarMovimentoEstoque() {
        movimentoEstoques.addAll(
                List.of(
                        MovimentoEstoque.with(BigDecimal.valueOf(1), LocalDateTime.of(2024, 10, 10, 9, 15), "Arroz 1kg", OperacaoEnum.COMPRA, TipoOperacaoEnum.ADICIONA, "GUSTAVO", TipoClienteEnum.ASSOCIADO, BigDecimal.valueOf(10), BigDecimal.valueOf(200.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(2), LocalDateTime.of(2024, 10, 10, 17, 35), "Feijão 1kg", OperacaoEnum.COMPRA, TipoOperacaoEnum.ADICIONA, "GUSTAVO", TipoClienteEnum.ASSOCIADO, BigDecimal.valueOf(10), BigDecimal.valueOf(250.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(3), LocalDateTime.of(2024, 10, 10, 18, 0), "Carne Bovina", OperacaoEnum.COMPRA, TipoOperacaoEnum.ADICIONA, "GUSTAVO", TipoClienteEnum.ASSOCIADO, BigDecimal.valueOf(20), BigDecimal.valueOf(500.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(4), LocalDateTime.of(2024, 10, 11, 9, 58), "Feijão 1kg", OperacaoEnum.VENDA, TipoOperacaoEnum.SUBTRAI, "MARTA", TipoClienteEnum.ASSOCIADO, BigDecimal.valueOf(2), BigDecimal.valueOf(5.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(5), LocalDateTime.of(2024, 10, 11, 12, 15), "Arroz 1kg", OperacaoEnum.VENDA, TipoOperacaoEnum.SUBTRAI, "MARTA", TipoClienteEnum.ASSOCIADO, BigDecimal.valueOf(5), BigDecimal.valueOf(15.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(6), LocalDateTime.of(2024, 10, 11, 12, 30), "Carne Bovina", OperacaoEnum.VENDA, TipoOperacaoEnum.SUBTRAI, "GUILHERME", TipoClienteEnum.TERCEIRO, BigDecimal.valueOf(5), BigDecimal.valueOf(20.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(7), LocalDateTime.of(2024, 10, 11, 14, 45), "Carne Bovina", OperacaoEnum.VENDA, TipoOperacaoEnum.SUBTRAI, "ELIANE", TipoClienteEnum.TERCEIRO, BigDecimal.valueOf(4), BigDecimal.valueOf(17.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(8), LocalDateTime.of(2024, 10, 12, 11, 45), "Carne Bovina", OperacaoEnum.COMPRA, TipoOperacaoEnum.ADICIONA, "ELIANE", TipoClienteEnum.TERCEIRO, BigDecimal.valueOf(40), BigDecimal.valueOf(1300.00)),
                        MovimentoEstoque.with(BigDecimal.valueOf(9), LocalDateTime.of(2024, 10, 12, 12, 0), "Arroz 1kg", OperacaoEnum.VENDA, TipoOperacaoEnum.SUBTRAI, "ELIANE", TipoClienteEnum.TERCEIRO, BigDecimal.valueOf(5), BigDecimal.valueOf(25))
                )
        );

    }

    public static List<MovimentoEstoque> getMovimentoEstoques() {
        return movimentoEstoques;
    }

}

