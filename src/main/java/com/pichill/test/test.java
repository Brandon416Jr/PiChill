package com.pichill.test;

import java.io.File;

public class test {
	private static void main(String[] args) {
		File file = new File("payment_conf.xml");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		
	}
}
