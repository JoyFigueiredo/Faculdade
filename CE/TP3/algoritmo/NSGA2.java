package algoritmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import individuo.Individuo;
import individuo.IndividuoFactory;
import individuo.IndividuoShafferFactory;
import util.CrowdingDistance;
import util.FNDS;

public class NSGA2 {

    //Executar o FNDS
    private FNDS fnds = new FNDS();
    public Random rnd = new Random();

    public void execute(IndividuoFactory individuoFactory, int nPop, int qtdEpocas) {
        List<Individuo> pop = new ArrayList<Individuo>(nPop);
        for (int i = 0; i < nPop; i++) {
            pop.add(individuoFactory.getIndividuo());
        }

        int e = 1; // Contador de épocas

        while (e <= qtdEpocas) {

            List<Individuo> q = new ArrayList<Individuo>(nPop);
            //União dos pais com os filhos R = pop U Q
            List<Individuo> r = new ArrayList<Individuo>(nPop * 2);
            //Nova população
            List<Individuo> popNova = new ArrayList<Individuo>(nPop);
            //pegar os pais e filhos, recombinação
            makeOffSpring(q, pop);

            r.addAll(pop);
            r.addAll(q);

            //lista de fronteiras
            List<List<Individuo>> f = fnds.executar(r);

            int i = 0; // Contador de fronteiras
            while (popNova.size() + f.get(i).size() <= nPop) {
                popNova.addAll(f.get(i));
                i++;
            }

            //Ultima fronteira
            List<Individuo> fLast = f.get(i);
            if (popNova.size() < nPop) {
                CrowdingDistance cd = new CrowdingDistance();
                cd.avaliar(fLast);
                
                int popSize = popNova.size();
                for (int j = 0; j < nPop - popSize; j++) {
                    popNova.add(fLast.get(j));
                }
            }

            if (e == 1 || e == 10 || e == 50 || e == 100 || e == 1000) {
                System.out.println("Época: " + e);
                imprimirPop(popNova);
            }
            pop = popNova;
            e++;
        }
    }

    private void makeOffSpring(List<Individuo> q, List<Individuo> pop) {
        
        List<Individuo> r = new ArrayList<Individuo>(pop.size());
        r.addAll(pop);

        while (r.size() > 1) {
            int idx1 = rnd.nextInt(r.size());
            Individuo p1 = r.remove(idx1);
            int idx2 = rnd.nextInt(r.size());
            Individuo p2 = r.remove(idx2);

            //Mutação de 15%
            List<Individuo> filhos = p1.recombinar(p2);
            Individuo f1 = filhos.get(0);
            if (rnd.nextDouble() > 0.85) {
                f1.mutar();
            }
            Individuo f2 = filhos.get(1);
            if (rnd.nextDouble() > 0.85) {
                f2.mutar();
            }

            q.addAll(filhos);

        }
    }

    private void imprimirPop(List<Individuo> pop) {
        for (Individuo ind : pop) {
            System.out.print("(");
            double[] obj = ind.getObjetivos();
            for (int j = 0; j < obj.length; j++) {
                if (j == obj.length - 1) {
                    System.out.print(String.format("%f", obj[j]) + ")");
                } else {
                    System.out.print(String.format("%f", obj[j]) + ";");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IndividuoFactory factory = new IndividuoShafferFactory();
        NSGA2 nsga2 = new NSGA2();
        nsga2.execute(factory, 20, 1000);
    }

}
