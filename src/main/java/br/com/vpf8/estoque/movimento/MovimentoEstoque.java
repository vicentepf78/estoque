package br.com.vpf8.estoque.movimento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MovimentoEstoque {

    private final BigDecimal idMovimentoEstoque;
    private final LocalDateTime dataMovimento;
    private final String produto;
    private final OperacaoEnum operacao;
    private final TipoOperacaoEnum tipoOperacao;
    private final String cliente;
    private final TipoClienteEnum tipoCliente;
    private BigDecimal quantidade;
    private final BigDecimal valor;

    private MovimentoEstoque(final BigDecimal idMovimentoEstoque,
                             final LocalDateTime dataMovimento,
                             final String produto,
                             final OperacaoEnum operacao,
                             final TipoOperacaoEnum tipoOperacao,
                             final String cliente,
                             final TipoClienteEnum tipoCliente,
                             final BigDecimal quantidade,
                             final BigDecimal valor) {
        this.idMovimentoEstoque = idMovimentoEstoque;
        this.dataMovimento = dataMovimento;
        this.produto = produto;
        this.operacao = operacao;
        this.tipoOperacao = tipoOperacao;
        this.cliente = cliente;
        this.tipoCliente = tipoCliente;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public static MovimentoEstoque newMovimentoEstoque(final String produto,
                                                       final OperacaoEnum operacao,
                                                       final TipoOperacaoEnum tipoOperacao,
                                                       final String cliente,
                                                       final TipoClienteEnum tipoCliente,
                                                       final BigDecimal quantidade,
                                                       final BigDecimal valor) {
        return new MovimentoEstoque(
                MovimentoEstoqueID.unique().getValue(),
                LocalDateTime.now(),
                produto,
                operacao,
                tipoOperacao,
                cliente,
                tipoCliente,
                quantidade,
                valor);
    }

    public static MovimentoEstoque with(final BigDecimal idMovimentoEstoque,
                                        final LocalDateTime dataMovimento,
                                        final String produto,
                                        final OperacaoEnum operacao,
                                        final TipoOperacaoEnum tipoOperacao,
                                        final String cliente,
                                        final TipoClienteEnum tipoCliente,
                                        final BigDecimal quantidade,
                                        final BigDecimal valor) {

        return new MovimentoEstoque(
                idMovimentoEstoque,
                dataMovimento,
                produto,
                operacao,
                tipoOperacao,
                cliente,
                tipoCliente,
                quantidade,
                valor);
    }


    public BigDecimal getIdMovimentoEstoque() {
        return idMovimentoEstoque;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public String getProduto() {
        return produto;
    }

    public OperacaoEnum getOperacao() {
        return operacao;
    }

    public TipoOperacaoEnum getTipoOperacao() {
        return tipoOperacao;
    }

    public String getCliente() {
        return cliente;
    }

    public TipoClienteEnum getTipoCliente() {
        return tipoCliente;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal newQuantidade) {
        quantidade = newQuantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal valorMovimento() {
        if (this.getTipoOperacao().equals(TipoOperacaoEnum.SUBTRAI)) {
            return this.getQuantidade().negate();
        } else {
            return this.getQuantidade();
        }
    }

    public MovimentoEstoque movimentoNegativo() {
        if (Objects.nonNull(this.getTipoOperacao()) && this.getTipoOperacao().compareTo(TipoOperacaoEnum.SUBTRAI) == 0)
            setQuantidade(this.getQuantidade().negate());

        return this;
    }


    @Override
    public String toString() {
        return "MovimentoEstoque{" +
                "idMovimentoEstoque=" + idMovimentoEstoque +
                ", dataMovimento=" + dataMovimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +
//                ", produto='" + produto + '\'' +
//                ", operacao=" + operacao +
                ", tipoOperacao=" + tipoOperacao +
                ", cliente='" + cliente + '\'' +
//                ", tipoCliente=" + tipoCliente +
                ", quantidade=" + quantidade +
//                ", valor=" + valor +
                '}';
    }
}
