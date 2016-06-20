package org.pojo.tester.field.collections.map;

import org.junit.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;


public class TreeMapValueChangerTest {

    @Test
    public void Should_Return_Null_When_Value_Is_Not_Null() {
        // given
        final TreeMap<String, String> value = new TreeMap<>();
        final Class<? extends TreeMap> type = value.getClass();

        final TreeMapValueChanger valueChanger = new TreeMapValueChanger();

        // when
        final TreeMap<?, ?> result = valueChanger.increaseValue(value, type);

        // then
        assertThat(result).isNull();
    }

    @Test
    public void Should_Return_Any_Instance_When_Value_Is_Null() {
        // given
        final TreeMap<String, String> value = null;
        final Class<TreeMap> type = TreeMap.class;

        final TreeMapValueChanger valueChanger = new TreeMapValueChanger();

        // when
        final TreeMap<?, ?> result = valueChanger.increaseValue(value, type);

        // then
        assertThat(result).isInstanceOf(type);
    }
}
