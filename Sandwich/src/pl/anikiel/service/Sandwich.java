package pl.anikiel.service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Sandwich {

	public static final String CHLEB = "chleb";

	public static String getSandwichUsingRegex(String input) {

		Matcher matcher = Pattern.compile("chleb(.*)chleb").matcher(input);

		if (matcher.find()) {
			return matcher.group(1);
		}

		return "";
	}

	public static String getSandwichUsingIndexOf(String input) {
		int firstIndex = input.indexOf(CHLEB);
		int lastIndex = input.lastIndexOf(CHLEB);

		if (lastIndex > firstIndex) {
			return input.substring(firstIndex + CHLEB.length(), lastIndex);
		}

		return "";
	}

	public static String getSandwichUsingSplit(String input) {
		String[] ingredients = input.split(CHLEB, -1);

		if (ingredients.length >= 3) {
			String[] ingredientsInside = Arrays.copyOfRange(ingredients, 1, ingredients.length - 1);
			return Arrays.stream(ingredientsInside).collect(Collectors.joining(CHLEB));
		}

		return "";
	}

}
