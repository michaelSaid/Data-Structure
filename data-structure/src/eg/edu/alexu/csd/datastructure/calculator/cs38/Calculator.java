package eg.edu.alexu.csd.datastructure.calculator.cs38;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * @author DELL
 *
 *
 */
public class Calculator implements ICalculator {

	@Override
	public int add(final int x, final int y) {
		// TODO Auto-generated method stub
		return (x + y);
	}

	@Override
	public float divide(final int x, final int y) {
		// TODO Auto-generated method stub
		if (y == 0) {
			throw new RuntimeException("Division by zero!");
		}
		return (float) x / y;
	}

}
