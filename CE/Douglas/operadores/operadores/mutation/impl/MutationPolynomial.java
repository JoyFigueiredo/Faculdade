package operadores.mutation.impl;

import operadores.mutation.Mutation;
import util.RepairSolution;

public class MutationPolynomial implements Mutation {
	
	private double mutationProbability;
	private double mutationDistributionIndex;
	
	public MutationPolynomial(double mutationProbability, double mutationDistributionIndex) {
		this.mutationProbability = mutationProbability;
		this.mutationDistributionIndex = mutationDistributionIndex;
	}
	
	public double[] getMutation(double[] x, double[] lowerBound, double[] upperBound) {
		double rnd, delta1, delta2, mutPow, deltaq;
		double y, yl, yu, val, xy;

		for (int i = 0; i < x.length; i++) {
			if (Math.random() <= mutationProbability) {
				y = x[i];
				yl = lowerBound[i];
				yu = upperBound[i];
				if (yl == yu) {
					y = yl;
				} else {
					delta1 = (y - yl) / (yu - yl);
					delta2 = (yu - y) / (yu - yl);
					rnd = Math.random();
					mutPow = 1.0 / (mutationDistributionIndex + 1.0);
					if (rnd <= 0.5) {
						xy = 1.0 - delta1;
						val = 2.0 * rnd + (1.0 - 2.0 * rnd) * (Math.pow(xy, mutationDistributionIndex + 1.0));
						deltaq = Math.pow(val, mutPow) - 1.0;
					} else {
						xy = 1.0 - delta2;
						val = 2.0 * (1.0 - rnd) + 2.0 * (rnd - 0.5) * (Math.pow(xy, mutationDistributionIndex + 1.0));
						deltaq = 1.0 - Math.pow(val, mutPow);
					}
					y = y + deltaq * (yu - yl);
					y = RepairSolution.repairSolutionVariableValue(y, yl, yu);
				}
				x[i] = y;
			}
		}

		return x;
	}
}
