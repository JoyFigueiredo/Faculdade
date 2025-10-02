package operadores.mutation.impl;

import java.util.Random;
import operadores.mutation.Mutation;

public class MutationPolynomial implements Mutation {

    private double mutationProbability;
    private double distributionIndex;

    public MutationPolynomial(double mutationProbability, double distributionIndex) {
        this.mutationProbability = mutationProbability;
        this.distributionIndex = distributionIndex;
    }

    @Override
    public double[] getMutate(double[] vars, double[] lowerBounds, double[] upperBounds) {
        double rnd, delta1, delta2, mutPow, deltaq;
        double y, yl, yu, val, xy;
        Random random = new Random();

        for (int i = 0; i < vars.length; i++) {
            if (random.nextDouble() <= this.mutationProbability) {
                y = vars[i];
                yl = lowerBounds[i];
                yu = upperBounds[i];
                if (yl == yu) {
                    y = yl;
                } else {
                    delta1 = (y - yl) / (yu - yl);
                    delta2 = (yu - y) / (yu - yl);
                    rnd = random.nextDouble();
                    mutPow = 1.0 / (this.distributionIndex + 1.0);
                    if (rnd <= 0.5) {
                        xy = 1.0 - delta1;
                        val = 2.0 * rnd + (1.0 - 2.0 * rnd) * Math.pow(xy, (this.distributionIndex + 1.0));
                        deltaq = Math.pow(val, mutPow) - 1.0;
                    } else {
                        xy = 1.0 - delta2;
                        val = 2.0 * (1.0 - rnd) + 2.0 * (rnd - 0.5) * Math.pow(xy, (this.distributionIndex + 1.0));
                        deltaq = 1.0 - Math.pow(val, mutPow);
                    }
                    y = y + deltaq * (yu - yl);
                    if (y < yl) {
                        y = yl;
                    }
                    if (y > yu) {
                        y = yu;
                    }
                }
                vars[i] = y;
            }
        }
        return vars;
    }
}
