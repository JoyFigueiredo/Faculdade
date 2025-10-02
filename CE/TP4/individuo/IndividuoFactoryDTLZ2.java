package individuo;

import problema.DTLZ2;
import problema.Problema;

public class IndividuoFactoryDTLZ2 implements IndividuoFactory {
    private Problema problema;
	private int nVars;

	
	public IndividuoFactoryDTLZ2(int nVars, int nObjs) {
		this.problema = new DTLZ2(nVars, nObjs);
		this.nVars = nVars;
	}
	
	public Individuo getIndividuo() {
		double [] vars = new double[this.nVars];
		
		for (int i = 0; i < vars.length; i++) {
			vars[i] = Math.random();
		}
		
		Individuo ret = new Individuo(this.problema, vars);
		
		return ret;
	}
}
