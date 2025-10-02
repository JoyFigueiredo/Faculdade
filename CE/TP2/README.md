# Trabalho 2
Este código é um exemplo didático para ilustrar como funciona o algoritmo  e como ele pode ser implementado em Java.

A Crowding Distance é um conceito utilizado em algoritmos de otimização multiobjetivo, como o Fast Non-Dominated Sort (FNDS), para medir a densidade de soluções em um espaço objetivo. Ela ajuda a manter a diversidade na população de soluções não dominadas ao calcular a distância média entre cada solução em relação às outras em termos de seus objetivos.

Este conceito é implementado para cada objetivo individualmente, onde cada solução recebe uma medida de distância com base na proximidade em seu objetivo específico. Soluções que estão mais isoladas no espaço objetivo têm uma maior distância de crowding, o que permite uma melhor distribuição de soluções ao longo das frentes de Pareto.

A Crowding Distance é fundamental para algoritmos que buscam equilibrar a exploração (manter soluções diversificadas) e a explotação (selecionar soluções de alta qualidade).


## Índice
- [Descrição](#Descrição)
- [Funcionamento](#Funcionamento)
- [Aplicação](#Aplicação)
- [Descrição das classes](#Descrição-das-classes)
- [Contato](#contato)

## Descrição
A Crowding Distance desempenha um papel crucial na manutenção do equilíbrio entre explorar diferentes soluções (diversidade) e escolher as melhores soluções (qualidade) em problemas de otimização multiobjetivo.

## Funcionamento
- Ordenação por Objetivo: Inicialmente, as soluções são ordenadas com base nos seus objetivos individuais. Isso é feito para cada objetivo separadamente.
- Cálculo da Distância: Para cada solução na população não dominada, a Crowding Distance é calculada. Ela representa a média da diferença entre os valores de objetivo das soluções adjacentes na ordenação.
- Manutenção da Diversidade: Soluções que estão mais isoladas (ou seja, têm uma distância de crowding maior) são preferidas, pois contribuem para manter a diversidade da população. Isso ajuda a evitar a concentração excessiva de soluções em áreas específicas do espaço objetivo.

## Aplicação
- Algoritmos de Otimização Multiobjetivo: Utilizada em conjunção com métodos de ordenação não dominada, como o FNDS, para classificar e selecionar soluções em frentes de Pareto.
- Seleção de Soluções: Facilita a escolha de soluções não dominadas que não apenas são eficazes em termos de objetivos, mas também estão bem distribuídas ao longo do espaço objetivo.

## Descrição das classes 

### `Individuo`
- Representa um indivíduo na população de soluções.
- Armazena os valores das variáveis de decisão (vars) e dos objetivos (objetivos).
- Mantém uma lista de indivíduos que ele domina (dominados), o número de soluções que o dominam (n), e o ranking (r). 

### `FNDS`
- Implementa o algoritmo Fast Non-Dominated Sort (FNDS) para otimização multiobjetivo.
- O método execute recebe uma lista de indivíduos e retorna uma lista de frentes de Pareto.
- A primeira parte do algoritmo identifica e forma a primeira frente de Pareto, baseada na dominância de Pareto.
- A segunda parte do algoritmo forma as demais frentes de Pareto, iterativamente, removendo soluções das frentes anteriores e atualizando as contagens de dominância.

### `CrowdingDistance`
- Calcula a distância de crowding para cada indivíduo em uma lista de indivíduos não dominados.
- A distância de crowding ajuda a manter a diversidade ao longo das frentes de Pareto, avaliando quão densamente os indivíduos estão distribuídos no espaço objetivo.

### `Ponto`
- Representa um ponto no espaço objetivo associado a um indivíduo.
- Mantém os objetivos do ponto, uma lista de pontos dominados, a contagem de dominância (n), e o ranking (rank).

### `Main`
- Demonstração da utilização do algoritmo FNDS para classificar uma população em frentes de Pareto.
- Cria uma população de indivíduos com variáveis de decisão e objetivos específicos.
- Executa o algoritmo FNDS para gerar e imprimir as frentes de Pareto resultantes da população.

## Contato

Se você tiver alguma dúvida ou sugestão, entre em contato!

---

*Este projeto foi criado por [Joice Barros de Figueiredo](https://github.com/JoyFigueiredo).*
