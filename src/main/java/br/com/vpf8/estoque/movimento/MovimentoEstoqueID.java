package br.com.vpf8.estoque.movimento;

import br.com.vpf8.common.Identifier;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;

public class MovimentoEstoqueID extends Identifier {

    private final BigDecimal value;
    private static final Random sequencial = new Random();

    private MovimentoEstoqueID(final BigDecimal value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static MovimentoEstoqueID unique() {
        return MovimentoEstoqueID.from(BigDecimal.valueOf(sequencial.nextLong()));
    }

    public static MovimentoEstoqueID from(final BigDecimal anId) {
        return new MovimentoEstoqueID(anId);
    }

    @Override
    public BigDecimal getValue() {
        return value.abs();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovimentoEstoqueID that)) return false;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}
