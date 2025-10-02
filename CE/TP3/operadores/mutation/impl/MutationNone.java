package operadores.mutation.impl;

import operadores.mutation.Mutation;

public class MutationNone implements Mutation{
        //nenehum operador de mutação
        public MutationNone() {
        }

        @Override
        public double[] getMutate(double[] vars, double[] lowerBounds, double[] upperBounds) {
            // Retorna os genes sem alteração
            return vars;
        }
    
}
