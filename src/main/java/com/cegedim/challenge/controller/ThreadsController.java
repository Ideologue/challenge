package com.cegedim.challenge.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cegedim.challenge.thread.Worker;

import lombok.extern.slf4j.Slf4j;

@RestController("ThreadsController")
@RequestMapping(value = { "/thread" })
@Slf4j
public class ThreadsController {

	@GetMapping
	private void runThreads() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		List<Thread> workers = Stream.generate(() -> new Thread(new Worker(countDownLatch))).limit(3)
				.collect(Collectors.toList());

		workers.forEach(Thread::start);
		log.info("the first 3 parallel thread ");
		countDownLatch.await();
		log.info("first 3 threads completed");

		CountDownLatch countDownLatch4th = new CountDownLatch(1);
		(new Thread(new Worker(countDownLatch4th))).start();
		log.info("the 4th threaaad started");
		countDownLatch4th.await();
		log.info("the 4th thread completed");
	}
}
