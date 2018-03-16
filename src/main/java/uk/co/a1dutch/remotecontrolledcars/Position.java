package uk.co.a1dutch.remotecontrolledcars;

/**
 * A position is the vertical, horizontal and direction.
 */
public class Position {

	private int vertical = -1;
	private int horizontal = -1;
	private Direction direction = Direction.North;

	public Position(int vertical, int horizontal) {
		this.vertical = vertical;
		this.horizontal = horizontal;
	}

	public Position(Position parent) {
		this.vertical = parent.getVerticalAxis();
		this.horizontal = parent.getHorizontalAxis();
		this.direction = parent.getDirection();
	}

	public int getVerticalAxis() {
		return vertical;
	}

	public int getHorizontalAxis() {
		return horizontal;
	}

	public Direction getDirection() {
		return direction;
	}

	/**
	 * Increments the positions horizontal or vertical position depending on the
	 * direction.
	 */
	void forward() {
		if (direction == Direction.South) {
			vertical--;
		} else if (direction == Direction.North) {
			vertical++;
		} else if (direction == Direction.West) {
			horizontal--;
		} else {
			// direction == Direction.East
			horizontal++;
		}
	}

	/**
	 * Rotates the direction by 90 degrees anti-clockwise.
	 */
	void left() {
		direction = Direction.values()[direction.ordinal() == 0 ? 3 : direction.ordinal() - 1];
	}

	/**
	 * Rotates the direction by 90 degrees clockwise.
	 */
	void right() {
		direction = Direction.values()[direction.ordinal() == 3 ? 0 : direction.ordinal() + 1];
	}

}
