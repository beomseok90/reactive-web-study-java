package com.beom.reactive.section4;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoExample {
    public static void main(String[] args) {
        Mono.empty()
            .subscribe(
                    data -> log.info("emitted data: {}", data),
                    throwable -> log.error("emitted onError.", throwable),
                    () -> log.info("emitted onComplete.")
            );
    }
}
