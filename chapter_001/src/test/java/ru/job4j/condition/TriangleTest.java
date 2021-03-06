package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 * Test for calculating area of triangle.
 *
 * @author Artem Bartenev (bartenev92@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
	/**
     * Test calculating triangle area.
     */
	@Test
	public void  calclculatingTriangleArea() {
	Triangle triangle = new Triangle(new Point(2, 4), new Point(-1, 3), new Point(4, 7));
	double result = 3.5;
	assertThat(result, closeTo(triangle.area(), 0.01));
	}
}