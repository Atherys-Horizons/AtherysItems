package com.atherys.items.generator;

import java.util.Random;

public abstract class AbstractGenerator<T> implements Generator<T> {

    private long seed;

    private Random random;

    protected AbstractGenerator(long seed) {
        this.seed = seed;
    }

    protected AbstractGenerator() {
        this.random = new Random();
    }

    protected Random getRandom() {
        if (this.random == null) {
            this.random = new Random(seed);
        }

        return random;
    }
}
