package com.example.demo.exception;

public class InvalidBirthdayException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// メッセージを受け取るコンストラクタ
	public InvalidBirthdayException(String message) {
		super(message);
	}

	// メッセージと原因（Throwable）を受け取るコンストラクタ
	public InvalidBirthdayException(String message, Throwable cause) {
		super(message, cause);
	}

}