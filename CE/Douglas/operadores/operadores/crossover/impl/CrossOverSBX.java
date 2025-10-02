package operadores.crossover.impl;

import operadores.crossover.CrossOver;
import util.RepairSolution;

public class CrossOverSBX implements CrossOver {
	/** EPS defines the minimum difference allowed between real values */
	private static final double EPS = 1.0e-14;
	  
	private double probability;
	private double distributionIndex;
	
	public CrossOverSBX() {
		this(0.9, 20.0);
	}
	
	public CrossOverSBX(double probability, double distributionIndex) {
		this.probability = probability;
		this.distributionIndex = distributionIndex;
	}
	
	@Override
	public double[][] getOffSpring(double[] vars1, double[] vars2, double[] lowerBounds, double[] upperBounds) {
		double[][] ret = new double[2][];

		double[] f1 = new double[vars1.length];
		double[] f2 = new double[vars2.length];

		for (int i = 0; i < f1.length; i++) {
			f1[i] = vars1[i];
		}

		for (int i = 0; i < f2.length; i++) {
			f2[i] = vars2[i];
		}

		int i;
		double rand;
		double y1, y2, lowerBound, upperBound;
		double c1, c2;
		double alpha, beta, betaq;
		double valueX1, valueX2;

		if (Math.random() <= probability) {
			for (i = 0; i < vars1.length; i++) {
				valueX1 = vars1[i];
				valueX2 = vars1[i];
				if (Math.random() <= 0.5) {
					if (Math.abs(valueX1 - valueX2) > EPS) {
						if (valueX1 < valueX2) {
							y1 = valueX1;
							y2 = valueX2;
						} else {
							y1 = valueX2;
							y2 = valueX1;
						}

						lowerBound = lowerBounds[i];
						upperBound = upperBounds[i];

						rand = Math.random();
						beta = 1.0 + (2.0 * (y1 - lowerBound) / (y2 - y1));
						alpha = 2.0 - Math.pow(beta, -(distributionIndex + 1.0));

						if (rand <= (1.0 / alpha)) {
							betaq = Math.pow(rand * alpha, (1.0 / (distributionIndex + 1.0)));
						} else {
							betaq = Math.pow(1.0 / (2.0 - rand * alpha), 1.0 / (distributionIndex + 1.0));
						}
						c1 = 0.5 * (y1 + y2 - betaq * (y2 - y1));

						beta = 1.0 + (2.0 * (upperBound - y2) / (y2 - y1));
						alpha = 2.0 - Math.pow(beta, -(distributionIndex + 1.0));

						if (rand <= (1.0 / alpha)) {
							betaq = Math.pow((rand * alpha), (1.0 / (distributionIndex + 1.0)));
						} else {
							betaq = Math.pow(1.0 / (2.0 - rand * alpha), 1.0 / (distributionIndex + 1.0));
						}
						c2 = 0.5 * (y1 + y2 + betaq * (y2 - y1));
						
						c1 = RepairSolution.repairSolutionVariableValue(c1, lowerBound, upperBound);
						c2 = RepairSolution.repairSolutionVariableValue(c2, lowerBound, upperBound);

						if (Math.random() <= 0.5) {
							f1[i] = c2;
							f2[i] = c1;
						} else {
							f1[i] = c1;
							f2[i] = c2;
						}
					} else {
						f1[i] = valueX1;
						f2[i] = valueX2;
					}
				} else {
					f1[i] = valueX2;
					f2[i] = valueX1;
				}
			}
		}

		ret[0] = f1;
		ret[1] = f2;

		return ret;
	}

}
