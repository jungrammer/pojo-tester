package org.pojo.tester.instantiator;


import java.util.stream.Stream;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Executable;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static test.TestHelper.getDefaultDisplayName;

@RunWith(JUnitPlatform.class)
public class ArrayInstantiatorTest {

    @TestFactory
    public Stream<DynamicTest> Should_Create_Array_By_Class() {
        return Stream.of(Integer[].class,
                         Byte[].class,
                         Character[].class,
                         Double[].class,
                         Float[].class,
                         Integer[].class,
                         Long[].class,
                         Short[].class,
                         boolean[].class,
                         byte[].class,
                         char[].class,
                         double[].class,
                         float[].class,
                         int[].class,
                         long[].class,
                         short[].class)
                     .map(value -> dynamicTest(getDefaultDisplayName(value), Should_Create_Array(value)));
    }

    public Executable Should_Create_Array(final Class<?> classToInstantiate) {
        return () -> {
            // given
            final ArrayInstantiator instantiator = new ArrayInstantiator(classToInstantiate);

            // when
            final Object result = instantiator.instantiate();

            // then
            assertThat(result).isInstanceOf(classToInstantiate);
        };
    }

    @TestFactory
    public Stream<DynamicTest> Should_Create_Array_By_Qualified_Class_Name() {
        return Stream.of("[Ljava.lang.Integer;",
                         "[Ljava.lang.Byte;",
                         "[Ljava.lang.Character;",
                         "[Ljava.lang.Double;",
                         "[Ljava.lang.Float;",
                         "[Ljava.lang.Integer;",
                         "[Ljava.lang.Long;",
                         "[Ljava.lang.Short;",
                         "[Z",
                         "[B",
                         "[C",
                         "[D",
                         "[F",
                         "[I",
                         "[J",
                         "[S")
                     .map(value -> dynamicTest(getDefaultDisplayName(value), Should_Create_Array_By_Qualified_Class_Name(value)));
    }

    public Executable Should_Create_Array_By_Qualified_Class_Name(final String classToInstantiate) {
        return () -> {
            // given
            final ArrayInstantiator instantiator = new ArrayInstantiator(classToInstantiate);

            // when
            final String result = instantiator.instantiate()
                                              .getClass()
                                              .getName();

            // then
            assertThat(result).isEqualTo(classToInstantiate);
        };
    }

}
