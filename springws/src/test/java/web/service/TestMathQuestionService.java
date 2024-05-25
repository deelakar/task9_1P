package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testTrueAdd() {
        Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
    }

    @Test
    public void testAddNumber1Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("", "2"));
    }

    @Test
    public void testAddNumber2Empty() {
        Assert.assertNull(MathQuestionService.q1Addition("1", ""));
    }

    @Test
    public void testAddBothEmpty() {
        Assert.assertNull(MathQuestionService.q1Addition("", ""));
    }

    @Test
    public void testAddInvalidNumber1() {
        Assert.assertNull(MathQuestionService.q1Addition("a", "2"));
    }

    @Test
    public void testAddInvalidNumber2() {
        Assert.assertNull(MathQuestionService.q1Addition("1", "b"));
    }

    @Test
    public void testTrueSubtraction() {
        Assert.assertEquals(MathQuestionService.q2Subtraction("5", "3"), 2, 0);
    }

    @Test
    public void testSubtractNumber1Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
    }

    @Test
    public void testSubtractNumber2Empty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", ""));
    }

    @Test
    public void testSubtractBothEmpty() {
        Assert.assertNull(MathQuestionService.q2Subtraction("", ""));
    }

    @Test
    public void testSubtractInvalidNumber1() {
        Assert.assertNull(MathQuestionService.q2Subtraction("a", "2"));
    }

    @Test
    public void testSubtractInvalidNumber2() {
        Assert.assertNull(MathQuestionService.q2Subtraction("5", "b"));
    }
}
