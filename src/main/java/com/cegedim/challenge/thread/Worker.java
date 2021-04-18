package com.cegedim.challenge.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable {

	private CountDownLatch countDownLatch;

	public Worker(CountDownLatch countDownLatch) {

		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// doSomeWork();
		log.info("count down");
		countDownLatch.countDown();
	}
}