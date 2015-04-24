package de.bertschneider.junitquickchecktest;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.Ctor;
import org.junit.Assume;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class TheorieComplexTypeTest {

    @Theory
    public void test_will_generate_complex_tye(
            @ForAll @From(Ctor.class) Message message) {
        assertThat(message, is(notNullValue()));
        assertThat(message.getId(), is(notNullValue()));
        assertThat(message.getCode(), is(notNullValue()));
        assertThat(message.getData(), is(notNullValue()));
    }

    @Theory
    public void data_is_set(
            @ForAll @From(Ctor.class) Message message) {
        Assume.assumeThat(message.getData(), hasSize(greaterThan(0)));

        String text = message.getData().stream().map(Data::getStuff).collect(Collectors.joining());

//		System.out.println(text);
        assertThat(text, is(not(isEmptyOrNullString())));
    }

}
