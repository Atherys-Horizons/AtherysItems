package com.atherys.items.generator.name;

import com.atherys.items.generator.AbstractGenerator;

import java.util.List;

public class PooledNameGenerator extends AbstractGenerator<String> {

    private List<String> prefixes;

    private List<String> names;

    private List<String> postfixes;

    public PooledNameGenerator(List<String> prefixes, List<String> names, List<String> postfixes) {
        this.prefixes = prefixes;
        this.names = names;
        this.postfixes = postfixes;
    }

    public String getRandomPrefix() {
        return prefixes.parallelStream()
                .skip((long) (prefixes.size() * getRandom().nextDouble()))
                .findFirst()
                .orElse(null);
    }

    public String getRandomName() {
        return names.parallelStream()
                .skip((long) (names.size() * getRandom().nextDouble()))
                .findFirst()
                .orElse(null);
    }

    public String getRandomPostfix() {
        return postfixes.parallelStream()
                .skip((long) (postfixes.size() * getRandom().nextDouble()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String get() {
        return getRandomPrefix() + " " + getRandomName() + " " + getRandomPostfix();
    }
}
