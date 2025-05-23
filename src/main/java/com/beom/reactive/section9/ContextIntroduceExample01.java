package com.beom.reactive.section9;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Context 개념 설명 예제 코드
 *  - contextWrite()으로 Context에 값을 쓸 수 있고, ContextView.get()을 통해서 Context에 저장된 값을 read 할 수 있다.
 *  - ContextView는 deferContextual() 또는 transformDeferredContextual()을 통해 제공된다.
 */
@Slf4j
public class ContextIntroduceExample01 {
    public static void main(String[] args) throws InterruptedException {
        String key = "message";
        Mono<String> mono = Mono.deferContextual(ctx ->
                        Mono.just("Hello" + " " + ctx.get(key)).doOnNext(data -> log.info("data: {}", data))
                )
                .subscribeOn(Schedulers.boundedElastic())
                .publishOn(Schedulers.parallel())
                .transformDeferredContextual((mono2, ctx) -> mono2.map(data -> data + " " + ctx.get(key)))
                .contextWrite(context -> context.put(key, "Reactor"));


        mono.subscribe(data -> log.info("onNext: {}", data));

        Thread.sleep(100L);
    }
}