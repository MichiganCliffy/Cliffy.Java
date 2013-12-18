package samples;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChangeCounting {

	@Test
	public void test() {
		int[] denominations = new int[]{100, 25, 10, 5, 1};
		
		int amount = 157;
		for(int denomination : denominations) {
			int count = (int)Math.floor(amount / denomination);
			amount = amount - (count * denomination);
			
			switch(denomination) {
			case 100:
				assertEquals(1, count);
				assertEquals(57, amount);
				break;
				
			case 25:
				assertEquals(2, count);
				assertEquals(7, amount);
				break;
				
			case 10:
				assertEquals(0, count);
				assertEquals(7, amount);
				break;
				
			case 5:
				assertEquals(1, count);
				assertEquals(2, amount);
				break;
				
			case 1:
				assertEquals(2, count);
				assertEquals(0, amount);
				break;
			}
		}
	}
}
