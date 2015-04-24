package de.bertschneider.junitquickchecktest;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.util.List;

import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;

@RunWith(Theories.class)
public class TheorieSimpleTypeTest {

	@Theory
	public void addition_produces_greater_result(
			@ForAll int firstNumber,
			@ForAll int secondNumber) {
		assertThat(firstNumber + secondNumber, allOf(greaterThan(firstNumber), greaterThan(secondNumber)));
	}

	@Theory
	public void concat_produces_extended_string(
			@ForAll String someString,
			@ForAll String otherString) {
//		System.out.println(someString + " - " + b);
		assertThat((someString + otherString).length(), is(someString.length() + otherString.length()));
	}
	
	@Theory
	public void addition_of_numbers_in_list_produces_result_greater_zero(
			@ForAll List<@InRange(minInt = Integer.MIN_VALUE, maxInt = Integer.MAX_VALUE) Integer> someNumbers) {
		assumeThat(someNumbers, hasSize(greaterThan(0)));
		assumeThat(someNumbers, everyItem(greaterThan(0)));

		int sum = someNumbers.stream().reduce(Math::addExact).get();

		assertThat(sum, is(greaterThan(0)));
	}
	
}
