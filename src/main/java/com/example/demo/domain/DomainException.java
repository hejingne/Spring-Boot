package com.example.demo.domain;

public class DomainException extends RuntimeException {
	public DomainException(String errorMsg) {
		super(errorMsg);
	}
}
