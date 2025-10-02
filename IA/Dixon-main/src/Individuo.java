import java.util.List;


public interface Individuo extends Comparable<Individuo>{

    public List<Individuo> recombinarAritm(Individuo ind);
    public List<Individuo> recombinarBLX(Individuo ind);
    
    Individuo mutar();
    double getAvaliacao();
    public double[] getGenes();

}
