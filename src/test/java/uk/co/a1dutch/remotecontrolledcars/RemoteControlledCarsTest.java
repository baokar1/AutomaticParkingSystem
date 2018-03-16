package uk.co.a1dutch.remotecontrolledcars;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RemoteControlledCarsTest {

	@Test(expected = InvalidInputFormat.class)
	public void invalid_input_format() throws Exception {
		String input = "55RFLFRFLF";

		new RemoteControlledCars(input);
	}

	@Test(expected = InvalidInputFormat.class)
	public void invalid_start_position() throws Exception {
		String input = "16,16:RFLFRFLF";

		new RemoteControlledCars(input);
	}

	@Test
	public void parses_start_position() throws Exception {
		String input = "5,5:RFLFRFLF";

		RemoteControlledCars cars = new RemoteControlledCars(input);

		assertThat(cars.getStartPosition().getVerticalAxis(), is(5));
		assertThat(cars.getStartPosition().getHorizontalAxis(), is(5));
		assertThat(cars.getStartPosition().getDirection(), is(Direction.North));
	}

	@Test
	public void parses_end_position() throws Exception {
		String input = "5,5:RFLFRFLF";

		RemoteControlledCars cars = new RemoteControlledCars(input);

		assertThat(cars.getPositions().size(), is(9));

		assertThat(cars.getEndPosition().getVerticalAxis(), is(7));
		assertThat(cars.getEndPosition().getHorizontalAxis(), is(7));
		assertThat(cars.getEndPosition().getDirection(), is(Direction.North));
	}

	@Test(expected = OutOfBoundsException.class)
	public void moves_out_of_bounds_north() throws Exception {
		String input = "15,0:F";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfBoundsException.class)
	public void moves_out_of_bounds_south() throws Exception {
		String input = "0,0:RRF";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfBoundsException.class)
	public void moves_out_of_bounds_east() throws Exception {
		String input = "0,15:RF";

		new RemoteControlledCars(input);
	}

	@Test(expected = OutOfBoundsException.class)
	public void moves_out_of_bounds_west() throws Exception {
		String input = "0,0:LF";

		new RemoteControlledCars(input);
	}

	@Test
	public void test_vectors() throws Exception {
		testVector("5,5:RFLFRFLF", 9, 5, 5, 7, 7, Direction.North);
		testVector("6,6:FFLFFLFFLFF", 12, 6, 6, 6, 6, Direction.East);
		testVector("5,5:FLFLFFRFFF", 11, 5, 5, 4, 1, Direction.West);

		testVector("5,5:FFFFF", 6, 5, 5, 10, 5, Direction.North);
		testVector("0,0:RRRR", 5, 0, 0, 0, 0, Direction.North);
	}

	private void testVector(String input, int positions, int startVerticalAxis, int startHorizontalAxis,
			int endVerticalAxis, int endHorizontalAxis, Direction endDirection) {
		RemoteControlledCars cars = new RemoteControlledCars(input);

		assertThat(cars.getPositions().size(), is(positions));

		assertThat(cars.getStartPosition().getVerticalAxis(), is(startVerticalAxis));
		assertThat(cars.getStartPosition().getHorizontalAxis(), is(startHorizontalAxis));
		assertThat(cars.getStartPosition().getDirection(), is(Direction.North));

		assertThat(cars.getEndPosition().getVerticalAxis(), is(endVerticalAxis));
		assertThat(cars.getEndPosition().getHorizontalAxis(), is(endHorizontalAxis));
		assertThat(cars.getEndPosition().getDirection(), is(endDirection));
	}

}
