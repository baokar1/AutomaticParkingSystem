package uk.co.a1dutch.remotecontrolledcars;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteControlledCars {

	private static final int GRID_SIZE = 15;

	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	private static final String INPUT_REGULAR_EXPRESSION = "([0-9]|1[0-5]),([0-9]|1[0-5]):([FLR]+)";

	private List<Position> positions = new ArrayList<Position>();

	public RemoteControlledCars(String input) {
		parsePositions(input);
		checkVerticalBounds();
		checkHorizontalBounds();
	}

	private void parsePositions(String input) {
		Matcher matcher = Pattern.compile(INPUT_REGULAR_EXPRESSION).matcher(input);

		if (!matcher.matches()) {
			throw new InvalidInputFormat(input, INPUT_REGULAR_EXPRESSION);
		}

		int vertical = Integer.parseInt(matcher.group(1));
		int horizontal = Integer.parseInt(matcher.group(2));

		Position startPosition = new Position(vertical, horizontal);

		positions.add(startPosition);

		Position currentPosition = new Position(startPosition);
		String moves = matcher.group(3);
		for (int i = 0; i < moves.length(); i++) {
			currentPosition = new Position(currentPosition);
			char move = moves.charAt(i);

			if (move == LEFT) {
				currentPosition.left();
			} else if (move == RIGHT) {
				currentPosition.right();
			} else {
				currentPosition.forward();
			}
			positions.add(currentPosition);
		}
	}

	private void checkHorizontalBounds() {
		Position endPosition = getEndPosition();
		if (endPosition.getHorizontalAxis() > GRID_SIZE || endPosition.getHorizontalAxis() < 0) {
			throw new OutOfBoundsException(endPosition);
		}
	}

	private void checkVerticalBounds() {
		Position endPosition = getEndPosition();
		if (endPosition.getVerticalAxis() > GRID_SIZE || endPosition.getVerticalAxis() < 0) {
			throw new OutOfBoundsException(endPosition);
		}
	}

	/**
	 * Returns the Start Position.
	 */
	public Position getStartPosition() {
		return positions.get(0);
	}

	/**
	 * Returns the end position.
	 */
	public Position getEndPosition() {
		return positions.get(positions.size() - 1);
	}

	/**
	 * Returns a list of positions containing the following:
	 *
	 * <ul>
	 * <li>the start position</li>
	 * <li>any intermediary positions</li>
	 * <li>the end position</li>
	 * </ul>
	 */
	public List<Position> getPositions() {
		return positions;
	}

	public static void main(String[] args) {
		if (args == null || args.length == 0 || args.length > 1) {
			System.out.println("Usage uk.co.a1dutch.remotecontrolledcars.RemoteControlledCars <input>");
			System.out.println("\tinput must match the following regular expression: " + INPUT_REGULAR_EXPRESSION);
			return;
		}
		RemoteControlledCars cars = new RemoteControlledCars(args[0]);

		System.out.println("Car started at  : " + cars.getStartPosition().getVerticalAxis() + ","
				+ cars.getStartPosition().getHorizontalAxis());
		System.out.println("Car finished at : " + cars.getEndPosition().getVerticalAxis() + ","
				+ cars.getEndPosition().getHorizontalAxis());
	}

}
