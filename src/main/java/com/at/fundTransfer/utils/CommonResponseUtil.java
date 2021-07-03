package com.at.fundTransfer.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponseUtil {

	public static ResponseEntity<Object> getSuccessResponse(String key, Object value, String token) {

		Map<String, Object> commonResponse = new HashMap<>();

		commonResponse.put("code", 200);
		commonResponse.put("message", "success");
		commonResponse.put(key, value);

		return new ResponseEntity<Object>(commonResponse, new HttpHeaders(), HttpStatus.OK);
	}

	public static ResponseEntity<Object> getFailResponse(String token, String customMsg, Integer customCode,
			HttpStatus message) {

		Map<String, Object> commonResponse = new HashMap<>();

		commonResponse.put("code", customCode);
		commonResponse.put("message", customMsg);

		return new ResponseEntity<Object>(commonResponse, new HttpHeaders(), message);

	}

	public enum messageStatus {
		INSERT_SUCCESS(1, "INSERT_SUCCESS"), INSERT_ERROR(3, "INSERT_ERROR"), UPDATE_SUCCESS(2, "UPDATE_SUCCESS"),
		UPDATE_ERROR(4, "UPDATE_ERROR"), SESSION_CLEAR(5, "SESSION_CLEAR"), ALREADY_EXIST(6, "ALREADY_EXIST"),
		DELETE_SUCCESS(7, "DELETE_SUCCESS"), DELETE_ERROR(8, "DELETE_ERROR"), SUCCESS(200, "SUCCESS"),
		DATA_NOT_FOUND(404, "DATA_NOT_FOUND"), UNAUTHORIZED(401, "UNAUTHORIZED");

		private int messageCode;
		private String message;

		private messageStatus(int messageCode, String message) {

			this.messageCode = messageCode;
			this.message = message;
		}

		public int getMessageCode() {
			return messageCode;
		}

		public String getMessage() {
			return message;
		}

	}

}
