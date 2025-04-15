package com.beom.reactive;

import reactor.core.publisher.Mono;

public class HelloReactor {
    public static void main(String[] args) {
        Mono.just("Hello World!")
                .subscribe(System.out::print);
    }
}
