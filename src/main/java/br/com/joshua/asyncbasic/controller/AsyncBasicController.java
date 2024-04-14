package br.com.joshua.asyncbasic.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joshua.asyncbasic.service.AsyncBasicService;

@RestController
@RequestMapping("/async-basic")
public class AsyncBasicController {

	public record AsyncResponse(String start, String end, String methodName) {
	}

	private final AsyncBasicService asyncBasicService;

	public AsyncBasicController(AsyncBasicService asyncBasicService) {
		this.asyncBasicService = asyncBasicService;
	}

	@GetMapping("not-async")
	public ResponseEntity<AsyncResponse> notAsynchronousTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime start = LocalDateTime.now();
		asyncBasicService.notAsynchronousTest();
		LocalDateTime end = LocalDateTime.now();
		return ResponseEntity.ok(new AsyncResponse(start.format(formatter), end.format(formatter), "notAsynchronousTest"));
	}
	
	@GetMapping("async")
	public ResponseEntity<AsyncResponse> asynchronousTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime start = LocalDateTime.now();
		asyncBasicService.asynchronousTest();
		LocalDateTime end = LocalDateTime.now();
		return ResponseEntity.ok(new AsyncResponse(start.format(formatter), end.format(formatter), "asynchronousTest"));
	}

}
