package ess.model;

import org.springframework.core.convert.converter.Converter;


public class StringToRoleConverter implements Converter<String, Role> {

	@Override
	public Role convert(String source) {
		if (source != null && !source.isEmpty() ) {
			try {
				return Role.valueOf(source.trim().toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
