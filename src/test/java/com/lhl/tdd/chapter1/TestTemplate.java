package com.lhl.tdd.chapter1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lunhengle on 16-5-9.
 */
public class TestTemplate {
    private Template template;//所有测试的夹具

    @Before
    public void setUp() throws Exception {
        template = new Template("${one},${two},${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception {
        this.assertTemplateEvaluatesTo("1,2,3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "whatever");
        this.assertTemplateEvaluatesTo("1,2,3");
    }

    /**
     * 公有化的比较方法.
     * @param expected 期望值
     */
    private void assertTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }
}
