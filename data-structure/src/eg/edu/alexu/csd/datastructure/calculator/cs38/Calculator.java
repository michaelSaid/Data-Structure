package eg.edu.alexu.csd.datastructure.calculator.cs38;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class Calculator implements ICalculator {
	public int add(int x, int y) {
		return (x + y);
	}

	public float divide(int x, int y) {
		if (y == 0)
			throw new RuntimeException("'Division by zero!'!");
		return (float) x / y;
	}

}