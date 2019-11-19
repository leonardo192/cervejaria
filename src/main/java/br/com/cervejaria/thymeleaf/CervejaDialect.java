package br.com.cervejaria.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class CervejaDialect extends AbstractProcessorDialect {

	
	public  CervejaDialect() {
		super( "cervejaria",  "cerveja", StandardDialect.PROCESSOR_PRECEDENCE);
	}
	
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processor = new HashSet<>();
		processor.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		return processor;
	}

}
