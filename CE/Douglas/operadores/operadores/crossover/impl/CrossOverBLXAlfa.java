package operadores.crossover.impl;

import java.util.Random;

import operadores.crossover.CrossOver;
import util.RepairSolution;

public class CrossOverBLXAlfa implements CrossOver {

	private double desvioPadrao;
	private boolean inverterRandGenesFilhos;
	
	
	public CrossOverBLXAlfa(double desvioPadrao) {
		this(desvioPadrao, true);
	}
	
	public CrossOverBLXAlfa(double desvioPadrao, boolean inverterRandGenesFilhos) {
		this.desvioPadrao = desvioPadrao;
		this.inverterRandGenesFilhos = inverterRandGenesFilhos;
	}
	
	@Override
	public double[][] getOffSpring(double[] vars1, double[] vars2, double[] lowerBounds, double[] upperBounds) {
		double[][] ret = new double[2][];

		double[] f1 = new double[vars1.length];
		double[] f2 = new double[vars1.length];

		Random rand = new Random();

		for (int i = 0; i < vars1.length; i++) {
			double c1 = 0;
			double c2 = 0;
			
			if (this.inverterRandGenesFilhos) {
				if (rand.nextDouble() > 0.5) {
					c1 = vars1[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
					c2 = vars2[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
				} else {
					c2 = vars1[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
					c1 = vars2[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
				}
			}else {
				c1 = vars1[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
				c2 = vars2[i] + (rand.nextGaussian() * desvioPadrao) * Math.abs(vars1[i] - vars2[i]);
			}
			
			c1 = RepairSolution.repairSolutionVariableValue(c1, lowerBounds[i], upperBounds[i]);
			c2 = RepairSolution.repairSolutionVariableValue(c2, lowerBounds[i], upperBounds[i]);
			
			f1[i] = c1;
			f2[i] = c2;
		}

		ret[0] = f1;
		ret[1] = f2;

		return ret;
	}

	
	
}
