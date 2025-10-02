/*
 * Author: Joice Barros de Figueiredo
 */

import java.util.ArrayList;
import java.util.List;

public final class FNDS {
    public static List<List<Individuo>> execute(List<Individuo> pop) {
        List<List<Individuo>> fronts = new ArrayList<>();
        List<Individuo> frontsA = new ArrayList<>();
        /*
         * ========================================================================
         * PARTE 1: Definição da Primeira Fronteira e das Dominâncias
         * ========================================================================
         */

        // Para cada indivíduo na população
        for (Individuo p : pop) {
            p.n = 0; // Inicializa o número de soluções que dominam p
            p.dominados = new ArrayList<>(); // Inicializa a lista de soluções dominadas por p
            for (Individuo q : pop) {
                // Verifica se p domina q
                if (p.objetivos[0] <= q.objetivos[0] && p.objetivos[1] <= q.objetivos[1]) {
                    p.dominados.add(q); // Adiciona q à lista de dominados por p
                } else if (p.objetivos[0] >= q.objetivos[0] && p.objetivos[1] >= q.objetivos[1]) {
                    p.n++; // Incrementa o número de soluções que dominam p
                }
            }
            // Se p não é dominado por nenhuma solução
            if (p.n == 0) {
                p.r = 1; // Define o ranking de p como 1 (primeira fronteira)
                frontsA.add(p); // Adiciona p à primeira fronteira
            }
        }
        /*
         * ========================================================================
         * PARTE 2: Definição das Demais Fronteiras
         * ========================================================================
         */
        fronts.add(frontsA); // Adiciona a primeira fronteira à lista de frentes
        int i = 0;
        // Enquanto a fronteira atual não estiver vazia
        while (!fronts.get(i).isEmpty()) {
            List<Individuo> Q = new ArrayList<>(); // Inicializa a próxima fronteira
            // Para cada indivíduo na fronteira atual
            for (Individuo p : fronts.get(i)) {
                // Para cada indivíduo q dominado por p
                for (Individuo q : p.dominados) {
                    q.n--; // Decrementa o número de soluções que dominam q
                    // Se q não é mais dominado por nenhuma solução
                    if (q.n == 0) {
                        q.r = i + 1; // Define o ranking de q como a próxima fronteira
                        Q.add(q); // Adiciona q à próxima fronteira
                    }
                }
            }
            i++;
            fronts.add(Q); // Adiciona a próxima fronteira à lista de frentes
        }

        return fronts; // Retorna a lista de frentes
    }
}