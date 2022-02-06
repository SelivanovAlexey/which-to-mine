package me.onedigit.whichtomine.common.mapping;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class Mapper<F, T> {
    private F from;
    private T to;

    @SuppressWarnings("rawtypes")
    private final Map<Function, BiConsumer> rules = new HashMap<>();

    protected Mapper<F, T> entities(@NonNull F entityFrom, @NonNull T entityTo) {
        from = entityFrom;
        to = entityTo;
        return this;
    }

    protected  <E> Mapper<F, T> rule(@NonNull Function<F, E> ruleFrom, @NonNull BiConsumer<T, E> ruleTo) {
        rules.putIfAbsent(ruleFrom, ruleTo);
        return this;
    }

    @SuppressWarnings("unchecked")
    @SneakyThrows
    public <E> T map() {
        rules.forEach((k, v) -> {
            E result = (E) k.apply(from);
            v.accept(to, result);
        });
        return to;
    }

    public <E> T map(@NonNull F from, @NonNull T to) {
        this.entities(from, to);
        return this.map();
    }
}
