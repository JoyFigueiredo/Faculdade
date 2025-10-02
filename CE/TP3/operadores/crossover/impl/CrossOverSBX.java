package operadores.crossover.impl;

import java.util.Random;
import operadores.crossover.CrossOver;
import util.RepairSolution;

public class CrossOverSBX implements CrossOver {
    private double eta; // Taxa de distribuição
    private boolean inverterRandGenesFilhos;

    public CrossOverSBX(double eta) {
        this(eta, true);
    }

    public CrossOverSBX(double eta, boolean inverterRandGenesFilhos) {
        this.eta = eta;
        this.inverterRandGenesFilhos = inverterRandGenesFilhos;
    }

    @Override
    public double[][] getOffSpring(double[] vars1, double[] vars2, double[] lowerBounds, double[] upperBounds) {
        double[][] ret = new double[2][];
        
        double[] filho1 = new double[vars1.length];
        double[] filho2 = new double[vars1.length];

        Random rand = new Random();

        for (int i = 0; i < vars1.length; i++) {
            double u = rand.nextDouble();
            double beta;

            if (u <= 0.5) {
                beta = Math.pow(2 * u, 1.0 / (eta + 1.0));
            } else {
                beta = Math.pow(1.0 / (2.0 * (1.0 - u)), 1.0 / (eta + 1.0));
            }

            double c1 = 0.5 * ((1 + beta) * vars1[i] + (1 - beta) * vars2[i]);
            double c2 = 0.5 * ((1 - beta) * vars1[i] + (1 + beta) * vars2[i]);

            if (this.inverterRandGenesFilhos) {
                if (rand.nextDouble() > 0.5) {
                    double temp = c1;
                    c1 = c2;
                    c2 = temp;
                }
            }

            c1 = RepairSolution.repair(c1, lowerBounds[i], upperBounds[i]);
            c2 = RepairSolution.repair(c2, lowerBounds[i], upperBounds[i]);

            filho1[i] = c1;
            filho2[i] = c2;
        }

        ret[0] = filho1;
        ret[1] = filho2;

        return ret;
    }
}

