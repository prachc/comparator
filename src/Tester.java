import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Tester {

	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {
		long start = System.currentTimeMillis();

		// MyClass is tested
		Main1 tester = new Main1();

		// Tests
		assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
		assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
		assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
		
		long time = System.currentTimeMillis()-start;
		
		System.out.println("multiplicationOfZeroIntegersShouldReturnZero runtime:"+time);
	}
	
	@Test
	public void testComparator(){
		long start = System.currentTimeMillis();

		// MyClass is tested
		Main1 tester = new Main1();

		// Tests
		assertEquals("test char count order", "dabce", tester.orderByOccurrance("dcbadcbadcbadde"));
		assertEquals("test char count then alpha order","jlafkds", tester.orderByOccurrance("ajklfajdlkfajsdklfjalljaklsdfjaklsdjf"));
		assertEquals("test char count order", "z", tester.orderByOccurrance("z"));
		assertEquals("test char null", null, tester.orderByOccurrance(null));
		assertEquals("test no char", "", tester.orderByOccurrance(""));
		
		long time = System.currentTimeMillis()-start;
		
		System.out.println("testComparator runtime:"+time);
	}

}
