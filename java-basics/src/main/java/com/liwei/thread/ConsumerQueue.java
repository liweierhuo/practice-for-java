package com.liwei.thread;

import java.util.concurrent.BlockingQueue;

/**
 * @author liwei17788
 * @date 2019/4/1519:54
 */
public class ConsumerQueue implements Runnable{
	private final BlockingQueue conQueue;

	public ConsumerQueue(BlockingQueue conQueue) {
		this .conQueue =conQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++) {
			try {
				System. out .println("消费者消费的苹果编号为 ：" +conQueue.take());
				//在这里sleep是为了看的更加清楚些
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
