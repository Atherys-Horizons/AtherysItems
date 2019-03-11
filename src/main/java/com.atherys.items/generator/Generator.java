package com.atherys.items.generator;

import java.util.function.Supplier;

@FunctionalInterface
public interface Generator<T> extends Supplier<T> {
}
