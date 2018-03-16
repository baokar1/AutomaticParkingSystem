package uk.co.a1dutch.remotecontrolledcars;

/**
 * Exception to be thrown when the input format is invalid.
 */
@SuppressWarnings("serial")
public class InvalidInputFormat extends RuntimeException {
	public InvalidInputFormat(String input, String expression) {
		super(input + " does not meet the regular expression: " + expression);
	}
}
