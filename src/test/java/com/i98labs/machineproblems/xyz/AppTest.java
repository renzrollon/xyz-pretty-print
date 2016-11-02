package com.i98labs.machineproblems.xyz;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	private static final String XYZ_H3 = 
		"* * * * ***\n" + 
		" *   *   * \n" +
		"* *  *  ***\n";

	private static final String XYZ_H5 = 
		"*   * *   * *****\n" + 
		" * *   * *     * \n" + 
		"  *     *     *  \n" + 
		" * *    *    *   \n" + 
		"*   *   *   *****\n";
	
	private static final String XYZ_V3 = 
		"* *\n" + 
		" * \n" + 
		"* *\n" + 
		"   \n" + 
		"* *\n" + 
		" * \n" + 
		" * \n" + 
		"   \n" + 
		"***\n" + 
		" * \n" + 
		"***\n";
	
	private static final String XYZ_V5 = 
		"*   *\n" + 
		" * * \n" + 
		"  *  \n" + 
		" * * \n" + 
		"*   *\n" + 
		"     \n" + 
		"*   *\n" + 
		" * * \n" + 
		"  *  \n" + 
		"  *  \n" + 
		"  *  \n" + 
		"     \n" + 
		"*****\n" + 
		"   * \n" + 
		"  *  \n" + 
		" *   \n" + 
		"*****\n";

	private static final String XYZZXYYY_H3 =
			"* * * * *** *** * * * * * * * *\n" +
			" *   *   *   *   *   *   *   * \n" +
			"* *  *  *** *** * *  *   *   * \n";

	@Override
	protected void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Override
	protected void tearDown() throws Exception {
		System.setOut(null);
		System.setErr(null);
	}

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * 
	 */
	public void testAppWhenHorizontalSize3() {
		App.main(new String[] { "xyz", "3", "h" });
		assertEquals(XYZ_H3, outContent.toString());
	}
	
	public void testAppWhenHorizontalSize5() {
		App.main(new String[] { "xyz", "5", "h" });
		assertEquals(XYZ_H5, outContent.toString());
	}
	
	public void testAppWhenVerticalSize3() {
		App.main(new String[] { "xyz", "3", "v" });
		assertEquals(XYZ_V3, outContent.toString());
	}
	
	public void testAppWhenVerticalSize5() {
		App.main(new String[] { "xyz", "5", "v" });
		assertEquals(XYZ_V5, outContent.toString());
	}

	public void testAppWhenHorizontalSize3AdditionalChar() {
		App.main(new String[] { "xyzzxyyy", "3", "h" });
		assertEquals(XYZZXYYY_H3, outContent.toString());
	}


	public void testAppInvalidXYZString() {
		try {
			App.main(new String[] { "xyzR", "5", "v" });
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Args[0] must only contains xyzXYZ characters.", iae.getMessage());
		}
	}

	public void testAppInvalidSize() {
		try {
			App.main(new String[] { "xyz", "2", "v" });
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Args[1] must be an odd positive integer.", iae.getMessage());
		}
	}

	public void testAppInvalidOrientation() {
		try {
			App.main(new String[] { "xyz", "3", "x" });
			fail();
		} catch (IllegalArgumentException iae) {
			assertEquals("Args[2] must be h or v only.", iae.getMessage());
		}
	}
}
