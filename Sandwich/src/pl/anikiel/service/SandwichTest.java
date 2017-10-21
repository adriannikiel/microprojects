package pl.anikiel.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.Assert;

@RunWith(JUnit4.class)
public class SandwichTest {

	@Test
	public void testEmptyString() {
		String testedSandwich = "";
		String expectedResult = "";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testSimpleSandwich() {
		String testedSandwich = "chlebserchleb";
		String expectedResult = "ser";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testDirtySandwich() {
		String testedSandwich = "xxchlebserchlebyy";
		String expectedResult = "ser";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testDoubleChlebSandwich() {
		String testedSandwich = "chlebchlebserchlebchleb";
		String expectedResult = "chlebserchleb";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testOddNumberOfChlebSandwich() {
		String testedSandwich = "chlebchlebserchleb";
		String expectedResult = "chlebser";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testEmptySandwich() {
		String testedSandwich = "chlebchleb";
		String expectedResult = "";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

	@Test
	public void testBrokenSandwich() {
		String testedSandwich = "chleb";
		String expectedResult = "";

		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingRegex(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingIndexOf(testedSandwich));
		Assert.assertEquals(expectedResult, Sandwich.getSandwichUsingSplit(testedSandwich));
	}

}
