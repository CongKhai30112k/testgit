package com.khai.Utils;

import java.util.Map;

public class MapUtils {

	public static <T> T getObject(Map<String, Object> parameter, String key, Class<T> tclass) {
		Object obj = parameter.get(key);
		return parameter.containsKey(key) ? tclass.cast(obj) : null;

	}
}
