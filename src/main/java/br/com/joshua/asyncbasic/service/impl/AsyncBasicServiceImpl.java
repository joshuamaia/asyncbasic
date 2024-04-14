package br.com.joshua.asyncbasic.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.joshua.asyncbasic.service.AsyncBasicService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncBasicServiceImpl implements AsyncBasicService {

	@Override
	@Async
	public void asynchronousTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime start = LocalDateTime.now();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalDateTime end = LocalDateTime.now();
		log.info("asynchronousTest: " + start.format(formatter) + " - " + end.format(formatter));
	}

	@Override
	public void notAsynchronousTest() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime start = LocalDateTime.now();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalDateTime end = LocalDateTime.now();
		log.info("notAsynchronousTest: " + start.format(formatter) + " - " + end.format(formatter));
	}

}
