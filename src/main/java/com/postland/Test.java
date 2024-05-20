package com.postland;

import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.postland.PostlandBackEndApplication;

public class Test {
	
	
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("admin123"));
	}
}
