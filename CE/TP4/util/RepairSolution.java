package util;

public class RepairSolution {

    public static double repair(double vars, double lowerBounds, double upperBounds) {
        if (vars < lowerBounds) {
            vars = lowerBounds;
        } else if (vars > upperBounds) {
            vars = upperBounds;
        }
        return vars;
    }
}
