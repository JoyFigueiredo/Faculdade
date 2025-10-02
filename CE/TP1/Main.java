import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FNDS fnds = new FNDS();
        List<Individuo> pop = new ArrayList<>();
        
        // Adiciona indivíduos à população com seus genes e objetivos
        pop.add(new Individuo(new double[]{1},new double[]{1,5}));//A
        pop.add(new Individuo(new double[]{2},new double[]{2,3}));//B
        pop.add(new Individuo(new double[]{3},new double[]{4,1}));//C
        pop.add(new Individuo(new double[]{4},new double[]{3,4}));//D
        pop.add(new Individuo(new double[]{5},new double[]{4,3}));//E
        pop.add(new Individuo(new double[]{6},new double[]{5,5}));//F
        
        List<List<Individuo>> fronts = fnds.execute(pop);
        System.out.println("Fronts: ");
        // Imprime as frentes de Pareto
        for(int i=0; i<fronts.size(); i++){
            System.out.println("Front "+(i+1)+": ");
            for(Individuo ind : fronts.get(i)){
                System.out.println("Individuo: "+ind.genes[0]+" Objetivos: "+ind.objetivos[0]+", "+ind.objetivos[1]);
            }
        }
    }
}
