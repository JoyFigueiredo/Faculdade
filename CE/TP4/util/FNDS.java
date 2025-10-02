package util;

import java.util.ArrayList;
import java.util.List;

import individuo.Individuo;

public class FNDS {

    // Executa o algoritmo Fast Non-Dominated Sort
    public List<List<Individuo>> executar(List<Individuo> insList) {
        List<Ponto> P = new ArrayList<Ponto>(insList.size());
        List<Ponto> front1 = new ArrayList<Ponto>();
        List<List<Ponto>> fronts = new ArrayList<List<Ponto>>();

        for (Individuo ind : insList) {
            P.add(new Ponto(ind));
        }

        /*
         * ========================================================================
         * PARTE 1 - Identificação e formação da primeira frente de Pareto
         * ========================================================================
         */
        for (Ponto p : P) {
            p.S = new ArrayList<Ponto>(); // Lista de indivíduos dominados
            p.n = 0; // Contagem de dominância
            for (Ponto q : P) {
                if (domina(p, q)) {
                    p.S.add(q); // p domina q
                } else if (domina(q, p)) {
                    p.n++; // q domina p
                }
            }
            if (p.n == 0) {
                p.rank = 0;
                front1.add(p); // Adiciona p à primeira frente
            }
        }

        /*
         * ========================================================================
         * PARTE 2 - Identificação e formação das demais frentes de Pareto
         * ========================================================================
         */
        fronts.add(front1);
        int i = 0;
        List<Ponto> Fi = fronts.get(i);
        while (Fi.size() != 0) {
            List<Ponto> Q = new ArrayList<>();
            for (Ponto p : Fi) {
                List<Ponto> Sp = p.S;
                for (Ponto q : Sp) {
                    q.n--;
                    if (q.n == 0) {
                        q.rank = i + 1;
                        Q.add(q); // Adiciona q à próxima frente
                    }
                }
            }
            i++;
            fronts.add(Q);
            Fi = Q;
        }

        // Converte as frentes de pontos em frentes de indivíduos
        List<List<Individuo>> frontsInd = new ArrayList<List<Individuo>>();
        for (List<Ponto> front : fronts) {
            List<Individuo> frontInd = new ArrayList<Individuo>();
            for (Ponto p : front) {
                frontInd.add(p.getInd());
            }
            frontsInd.add(frontInd);
        }

        return frontsInd;
    }

    // Verifica se p domina q
    public boolean domina(Ponto p, Ponto q) {
        boolean flag = true;

        double[] obj1 = p.objetivos;
        double[] obj2 = q.objetivos;

        for (int i = 0; i < obj1.length; i++) {
            if (obj2[i] < obj1[i]) {
                return false;
            }
        }
        flag = false;
        for (int i = 0; i < obj1.length; i++) {
            if (obj1[i] < obj2[i]) {
                return true;
            }
        }
        return flag;
    }
    /*
 * 
 public static void main(String[] args) {
    List<Individuo> pop = new ArrayList<Individuo>();
    pop.add(new Individuo(new ProblemaExemplo(), new double[]{0}));
    pop.add(new Individuo(new ProblemaExemplo(), new double[]{1}));
    pop.add(new Individuo(new ProblemaExemplo(), new double[]{2}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{3}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{4}));
        pop.add(new Individuo(new ProblemaExemplo(), new double[]{5}));

        FNDS fnds = new FNDS();
        List<List<Individuo>> fronts = fnds.executar(pop);
        System.out.println("Frentes: ");
        for (int i = 0; i < fronts.size(); i++) {
            System.out.println("Frente: " + (i + 1) + ":");
            for (Individuo ind : fronts.get(i)) {
                System.out.println(ind);
            }
        }
    }
     */
}
