package de.bertschneider.junitquickchecktest;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class DataGenerator extends Generator<Data> {

	public DataGenerator() {
		super(Data.class);
	}

	private StringGenerator stringGenerator = new StringGenerator();
	
	@Override
	public Data generate(SourceOfRandomness rnd, GenerationStatus status) {
		return new Data(stringGenerator.generate(rnd, status));
	}
	
}