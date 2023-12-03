package com.cafeshopmanage.utils;

import java.lang.reflect.Method;

public class MapperUtils {

	public static final void map(Object source, Object target) {
		Method[] methods = target.getClass().getDeclaredMethods();
		for (Method method : methods) {
			try {
				String methodName = method.getName();

				if (methodName.indexOf("set") == 0) {
					Class<?> paramType = method.getParameterTypes()[0];

					Method medhodGet = source.getClass().getMethod(methodName.replaceFirst("set", "get"));
					Object valueObject = medhodGet.invoke(source);
					if (valueObject == null) {
						continue;
					}
					String valueString = valueObject.toString();
					method.invoke(target, convertByType(valueString, paramType.getName()));
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	private static Object convertByType(String value, String type) throws Exception {
		if (type.toLowerCase().contains("string")) {
			return String.valueOf(value);
		} else if (type.toLowerCase().contains("double")) {
			return Double.valueOf(value);
		} else if (type.toLowerCase().contains("int")) {
			return Integer.parseInt(value);
		} else if (type.toLowerCase().contains("long")) {
			return Long.valueOf(value);
		} else if (type.toLowerCase().contains("boolean")) {
			return Boolean.valueOf(value);
		} else {
			throw new Exception("Hãy bổ sung type còn thiếu vào: " + type);
		}
	}
}
