package com.liwei.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liwei17788
 * @date 2019/4/1519:11
 */
public class ThreadTest {
	private static Queue<String> myQueue = new ArrayBlockingQueue <>(10);
	private static Integer size = 10;
	private static String beanPrefix = "liwei_";
	private static Integer i  = 0;

	/**
	 * 消费者
	 */
	private static class Consumer implements Runnable {

		@Override
		public void run() {
			try {
				if (myQueue.size() <= 0) {
					wait();
				} else {
					String header = myQueue.poll();
					System.out.println(Thread.currentThread().getName()+"线程，消费了"+header+";目前队列还有"+myQueue.size());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Consumer is error:"+e.getMessage());
			}
		}
	}

	/**
	 * 生产者
	 */
	private static class Producer implements Runnable {

		@Override
		public void run() {
			try {
				if (myQueue.size() == size) {
					wait();
				} else {
					String bean = beanPrefix + i++;
					boolean result = myQueue.offer(bean);
					System.out.println(Thread.currentThread().getName()+"线程，生产了"+bean+";目前队列还有"+myQueue.size());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Producer is error:"+e.getMessage());
			}

		}
	}

	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		Thread threadConsumer = new Thread(consumer);
		threadConsumer.start();
		Producer producer = new Producer();
		Thread threadProducer = new Thread(producer);
		threadProducer.start();

	}
}
