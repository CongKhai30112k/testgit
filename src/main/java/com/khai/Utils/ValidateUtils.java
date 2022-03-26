package com.khai.Utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidateUtils {

	public boolean isNotBlank(String param) {
		if(param!=null && !param.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	public boolean isNotBlank(List<String> param) {
		if(param!=null && !param.isEmpty()) {
			return true;
		}
		return false;
	}
}
