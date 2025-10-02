import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FGA {
    Random rand = new Random();

    public Individuo execute(int nPop, int nElitismo, int nGer, IndividuoFactory IF) {

        List<Individuo> popIni = new ArrayList<>(nPop);

        // Preenchendo lista com individuos
        for (int i = 0; i < nPop; i++) {
            popIni.add(IF.getIndividuo());
        }

        // Percorre toda geração
        for (int i = 0; i < nGer; i++) {
            List<Individuo> filhos = new ArrayList<>(nPop);
            filhos.addAll(recombinarFilhos(popIni));

            // Geração de mutantes
            List<Individuo> mutante = new ArrayList<>(nPop);
            for (int j = 0; j < popIni.size(); j++) {
                Individuo p = popIni.get(j);
                mutante.add(p.mutar());
            }

            for (int j = 0; j < popIni.size(); j++) {
                popIni.get(j).getAvaliacao();
                filhos.get(j).getAvaliacao();
                mutante.get(j).getAvaliacao();
            }
            // Concatenação
            List<Individuo> join = new ArrayList<>(nPop *3);
            join.addAll(popIni);
            join.addAll(filhos);
            join.addAll(mutante);

            List<Individuo> newPop = new ArrayList<>();

            newPop.addAll(elitismo(join, nElitismo));
            newPop.addAll(roleta(join, nPop - nElitismo));
            popIni = newPop;

            System.out.println("g: " + i + " - " + popIni.get(0));

        }
        return popIni.get(0);
    }

    public List<Individuo> elitismo(List<Individuo> join, int elitismo) {
        //ordena
        ordena(join);
        List<Individuo> aux = new ArrayList<>();

        for(int i=0; i<elitismo;i++){
            aux.add(join.get(i));
        }
        //ja foi add então remove
        join.removeAll(aux);
        return aux;

    }

    private List<Individuo> roleta(List<Individuo> join, int t) {
        List<Individuo> listaRoleta = new ArrayList<Individuo>(t);
        Random r = new Random();
        
        double valor = 0;

        for (int roda = 0; roda < t; roda++) {
            double soma = 0;
            double somamin = 0;

            for (int i = 0; i < join.size(); i++) {
                soma += 1 / join.get(i).getAvaliacao();
            }

            valor = r.nextDouble() * (soma);

            for (int j = 0; j < join.size(); j++) {
                somamin += (1 / join.get(j).getAvaliacao());
                if (somamin >= valor) {
                    listaRoleta.add(join.remove(j));
                    break;
                }
                // rand < soma -> soma no rand o valor da avaliação, se não add dentro do vetor
            }
        }
        return listaRoleta;
    }

    public List<Individuo> recombinarFilhos(List<Individuo> popIni) {
        List<Individuo> listaFilhos = new ArrayList<Individuo>(2);
        List<Individuo> listaPais = new ArrayList<Individuo>(2);
        listaPais.addAll(popIni);
        Random rand = new Random();

        for (int j = 0; j < popIni.size() / 2; j++) {
            Individuo p1 = listaPais.remove(rand.nextInt(listaPais.size()));
            Individuo p2 = listaPais.remove(rand.nextInt(listaPais.size()));
            // listaFilhos.get(j).getAvaliacao();
            // listaFilhos.addAll(p1.recombinarAritm(p2));
            listaFilhos.addAll(p1.recombinarBLX(p2));

        }
        return listaFilhos;
    }

    public List<Individuo> ordena(List<Individuo> list) {
        int n = list.size();
        Individuo temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < n; j++) {
                if (list.get(i).getAvaliacao() > list.get(j).getAvaliacao()) {
                    // swap
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
