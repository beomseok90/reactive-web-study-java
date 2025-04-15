package com.beom.reactive.section2;

import reactor.core.publisher.Mono;

public class HelloReactor {
    public static void main(String[] args) {
        Mono.just("Hello World!")
                .subscribe(System.out::print);
    }
}
