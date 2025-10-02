package operadores.mutation.impl;

import operadores.mutation.Mutation;

public class MutationNone implements Mutation {

	public MutationNone() {
	}
	
	public double[] getMutation(double[] x, double[] lowerBound, double[] upperBound) {
		return x;
	}
}
