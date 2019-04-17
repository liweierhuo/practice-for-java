package com.liwei.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author liwei17788
 * @date 2019/4/1519:53
 */
public class PublicBoxQueue {
	public static void main(String []args) {
		//定义了一个大小为5的盒子
		BlockingQueue publicBoxQueue= new LinkedBlockingQueue(3);


		Thread pro= new Thread(new ProducerQueue(publicBoxQueue));
		Thread con= new Thread(new ConsumerQueue(publicBoxQueue));
		pro.setPriority(Thread.MAX_PRIORITY);
		pro.start();
		con.start();
	}
}
