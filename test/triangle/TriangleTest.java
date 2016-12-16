package triangle;

import org.junit.Test;

import triangle.Triangle;
import triangle.Triangle.Type;

import static org.junit.Assert.*;

import java.util.ArrayList;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

import java.util.ArrayList;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

    /*
     * Test the classification of an equilateral triangle.
     */



@Test
public void testA(){
Triangle t  = new Triangle();
assertNotNull(t);

}


    @Test
    public void test1() {
        Type actual = Triangle.classify(1, 1, 1);
        Type expected = EQUILATERAL;
        assertEquals (expected, actual);
    }
    
	@Test
	public void test2() {
		ArrayList<Type> t = new ArrayList<Type>();
		t.add(Triangle.classify(1, 2, 3));
		t.add(Triangle.classify(1, 3, 2));
		t.add(Triangle.classify(3, 1, 2));

	
		t.add(Triangle.classify(1, 2, -1));
		t.add(Triangle.classify(0, 2, 1));
		t.add(Triangle.classify(-1, 2, -1));
		t.add(Triangle.classify(-1, -2, -1));
		t.add(Triangle.classify(-1, 2, 1));

		for (Type m : t) {
			Type actual = m;
			Type expected = INVALID;
			assertEquals(expected, actual);
		}

	}

	@Test
	public void test3() {
		ArrayList<Type> t = new ArrayList<Type>();
		t.add(Triangle.classify(2, 2, 3));
		t.add(Triangle.classify(2, 3, 2));



		for (Type m : t) {
			Type actual = m;
			Type expected = ISOSCELES;
			assertEquals(expected, actual);
		}

	}

	@Test
	public void test4() {
		ArrayList<Type> t = new ArrayList<Type>();
		t.add(Triangle.classify(2, 2, 2));
		for (Type m : t) {
			Type actual = m;
			Type expected = EQUILATERAL;
			assertEquals(expected, actual);
		}

	}

	@Test
	public void test5() {
		ArrayList<Type> t = new ArrayList<Type>();
		t.add(Triangle.classify(3, 4, 5));
        	t.add(Triangle.classify(3, 5, 4));
		t.add(Triangle.classify(5, 3, 4));
		
		for (Type m : t) {
			Type actual = m;
			Type expected = SCALENE;
			assertEquals(expected, actual);
		}

	}
}


