package individuo;

import problema.DTLZ1;
import problema.Problema;

public class IndividuoFactoryDTLZ1 implements IndividuoFactory{
    private Problema problema;
    private int nVars;

    public IndividuoFactoryDTLZ1(int nVars, int nObjs) {
		this.problema = new DTLZ1(nVars, nObjs);
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
