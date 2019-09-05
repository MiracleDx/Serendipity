package com.serendipity.cloud.provider.webflux.common;

import com.sun.security.ntlm.Server;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * TimeHandler
 *
 * @author Dongx
 * Description:
 * Created in: 2019-08-26 15:34
 * Modified by:
 */
@Component
public class TimeHandler {
	
	public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
		return ok()
				.contentType(MediaType.TEXT_PLAIN)
				.body(Mono.just("Now is " + LocalDateTime.now()
						.format(DateTimeFormatter.ofPattern("HH:mm:ss"))), String.class);
	}
	
	public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
		return ok()
				.contentType(MediaType.TEXT_PLAIN)
				.body(Mono.just("Today is " + LocalDateTime.now()
						.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))), String.class);
	} 
	
	public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
		return ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(Flux.interval(Duration.ofSeconds(1))
					.map(l -> LocalDateTime.now()
							.format(DateTimeFormatter.ofPattern("HH:mm:ss"))), String.class);
	}
}
