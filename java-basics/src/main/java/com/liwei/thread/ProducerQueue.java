package com.liwei.thread;

import java.util.concurrent.BlockingQueue;

/**
 * @author liwei17788
 * @date 2019/4/1519:53
 */
public class ProducerQueue implements Runnable {
	private final BlockingQueue proQueue;

	public ProducerQueue(BlockingQueue proQueue) {
		this.proQueue =proQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i=0;i<10;i++) {
			try {
				//放入十个苹果编号 为1到10
				System. out .println("生产者生产的苹果编号为 : " +i);
				proQueue.put(i);
			} catch (InterruptedException  e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

	}
}
