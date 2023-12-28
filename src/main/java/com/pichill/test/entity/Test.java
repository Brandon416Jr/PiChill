package com.pichill.test.entity;

import java.io.File;

public class Test {
	private static void main(String[] args) {
		File file = new File("payment_conf.xml");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
		
	}
}
