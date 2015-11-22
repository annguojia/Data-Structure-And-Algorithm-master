package RPNCalculatorWithMemory;

import static org.junit.Assert.*;

import org.junit.Test;

public class RPNParserWithDictionaryTest {

	@Test
	public void test() throws Exception {
		RPNCalcWithDictionary the_calc = new RPNCalcWithDictionary();
		
		// test equal
		the_calc.variable("a");
		the_calc.number(3);
		the_calc.equal();
		assertEquals(3, the_calc.top(), 0.001);
		
		// test add
		the_calc.number(1);
		the_calc.add();
		assertEquals(4, the_calc.top(), 0.001);
		
		// test multiply
		the_calc.number(2);
		the_calc.multiply();
		assertEquals(8, the_calc.top(), 0.001);
		
		// test divide
		the_calc.number(4);
		the_calc.divide();
		assertEquals(2, the_calc.top(), 0.001);
	}

}
