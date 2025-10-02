package problema;

/**
 * Class representing problem DTLZ1
 */
public class DTLZ2 extends Problema {
	
	private int numberOfObjectives;
	
	/**
	 * Creates a default DTLZ1 problem (7 variables and 3 objectives)
	 */
	public DTLZ2() {
		this(7, 3);
	}

	/**
	 * Creates a DTLZ1 problem instance
	 *
	 * @param numberOfVariables  Number of variables
	 * @param numberOfObjectives Number of objective functions
	 */
	public DTLZ2(int nVars, int numberOfObjectives) {
		super(nVars);
		this.numberOfObjectives = numberOfObjectives;
		
		this.lowerBounds = new double[nVars];
		this.upperBounds = new double[nVars];
		for (int i = 0; i < nVars; i++) {
			upperBounds[i] = 1;
		}
	}

	/** Evaluate() method */
	public double[] avaliar(double[] vars) {

		double[] f = new double[numberOfObjectives];
		double[] x = new double[nVars];
 
		int k = nVars - numberOfObjectives + 1;

		for (int i = 0; i < nVars; i++) {
			x[i] = vars[i];
		}
		

		double g = 0.0;
		for (int i = nVars - k; i < nVars; i++) {
			g += Math.pow(x[i] - 0.5, 2.0);
		}

		for (int i = 0; i < numberOfObjectives; i++) {
			f[i] = 1.0 + g;

			for (int j = 0; j < numberOfObjectives - i - 1; j++) {
				f[i] *= Math.cos(0.5 * Math.PI * x[j]);
			}

			if (i != 0) {
				f[i] *= Math.sin(0.5 * Math.PI * x[numberOfObjectives - i - 1]);
			}
		}

		return f;
	}
	
	public static void main(String [] args) {
		DTLZ2 problem = new DTLZ2();
		
		/*
		double [] vars = new double[7];
		for (int i = 0; i < vars.length; i++) {
			vars[i] = Math.random();
		}
		*/
		
		double [] vars = new double[] {0.68920914, 0., 0.37193993, 0.73608056, 0.71348334, 0., 0.60386215};
		
		double [] f = problem.avaliar(vars);
		
		imprimeVetor(vars);
		imprimeVetor(f);
	}
	
	private static void imprimeVetor(double [] vet) {
		System.out.print("[");
		for (int i = 0; i < vet.length; i++) {
			System.out.print(vet[i] + ", " );	
		}
		System.out.println("]");
	}


}