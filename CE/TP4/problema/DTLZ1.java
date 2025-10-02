package problema;

/**
 * Class representing problem DTLZ1
 */
public class DTLZ1 extends Problema {
	
	private int numberOfObjectives;
	
	/**
	 * Creates a default DTLZ1 problem (7 variables and 3 objectives)
	 */
	public DTLZ1() {
		this(7, 3);
	}

	/**
	 * Creates a DTLZ1 problem instance
	 *
	 * @param numberOfVariables  Number of variables
	 * @param numberOfObjectives Number of objective functions
	 */
	public DTLZ1(int nVars, int numberOfObjectives) {
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
			g += (x[i] - 0.5) * (x[i] - 0.5) - Math.cos(20.0 * Math.PI * (x[i] - 0.5));
		}

		g = 100 * (k + g);
		for (int i = 0; i < numberOfObjectives; i++) {
			f[i] = (1.0 + g) * 0.5;
		}

		for (int i = 0; i < numberOfObjectives; i++) {
			for (int j = 0; j < numberOfObjectives - (i + 1); j++) {
				f[i] *= x[j];
			}
			if (i != 0) {
				int aux = numberOfObjectives - (i + 1);
				f[i] *= 1 - x[aux];
			}
		}
		
		return f;
	}
	/* 
	* 
	*/
	 public static void main(String [] args) {
		DTLZ1 problem = new DTLZ1();
		
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