package br.com.vpf8.estoque.movimento;

public enum TipoOperacaoEnum {
    ADICIONA("+"),
    SUBTRAI("-");

    private String operador;

    private TipoOperacaoEnum(final String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }
}
