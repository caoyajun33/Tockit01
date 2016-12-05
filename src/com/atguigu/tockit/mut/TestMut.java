package com.atguigu.tockit.mut;

class number{
	private int i = 0;
	
	public void inc() throws Exception{
		while(i>0){
			wait();
		}
		System.out.println(Thread.currentThread().getName()+ ":"+ ++i);
		
		notifyAll();
	}
	
	public void dec() throws Exception{
		while(i==0){
			wait();
		}
		System.out.println(Thread.currentThread().getName()+ ":"+ --i);
		notifyAll();
	}
}

public class TestMut {
	public static void main(String[] args) throws Exception{
		final number nu = new number();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						nu.inc();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					
					try {
						nu.dec();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
