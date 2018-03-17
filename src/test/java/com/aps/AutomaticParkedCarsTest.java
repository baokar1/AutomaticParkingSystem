package com.aps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class AutomaticParkedCarsTest {

    @Test
    public void parses_end_position_input1() throws Exception {
        String input = "5,5:RFLFRFLF";

        AutomaticParkedCars cars = new AutomaticParkedCars(input);

        assertThat(cars.getPositions().size(), is(9));

        assertThat(cars.getEndPosition().getVerticalAxis(), is(7));
        assertThat(cars.getEndPosition().getHorizontalAxis(), is(7));
    }

    @Test
    public void parses_end_position_input2() throws Exception {
        String input = "5,5:FLFLFFRFFF";

        AutomaticParkedCars cars = new AutomaticParkedCars(input);

        assertThat(cars.getPositions().size(), is(11));

        assertThat(cars.getEndPosition().getVerticalAxis(), is(4));
        assertThat(cars.getEndPosition().getHorizontalAxis(), is(1));
    }

    @Test
    public void parses_end_position_input3() throws Exception {
        String input = "6,6:FFLFFLFFLFF";

        AutomaticParkedCars cars = new AutomaticParkedCars(input);

        assertThat(cars.getPositions().size(), is(12));

        assertThat(cars.getEndPosition().getVerticalAxis(), is(6));
        assertThat(cars.getEndPosition().getHorizontalAxis(), is(6));
    }
}
