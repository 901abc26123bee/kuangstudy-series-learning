package com.wong.thread;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}
