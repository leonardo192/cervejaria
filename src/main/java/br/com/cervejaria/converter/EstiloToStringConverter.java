package br.com.cervejaria.converter;

import org.springframework.core.convert.converter.Converter;

import br.com.cervejaria.entity.EstiloCervejaEntity;

public class EstiloToStringConverter implements Converter<String, EstiloCervejaEntity>{

	@Override
	public EstiloCervejaEntity convert(String codigo) {

		if (!org.springframework.util.StringUtils.isEmpty(codigo)) {
			EstiloCervejaEntity estiloCerveja = new EstiloCervejaEntity();
			estiloCerveja.setId(Long.valueOf(codigo));
			return estiloCerveja;
		}
		return null;
	}

}
