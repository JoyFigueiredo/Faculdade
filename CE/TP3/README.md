# Trabalho 2

## Índice
- [Descrição](#Descrição)
- [Funcionamento](#Funcionamento)
- [Aplicação](#Aplicação)
- [Descrição das classes](#Descrição-das-classes)
- [Contato](#contato)

## Descrição
O NSGA-II (Non-dominated Sorting Genetic Algorithm II) é um algoritmo evolutivo projetado para resolver problemas de otimização multiobjetivo. Ele é amplamente utilizado devido à sua eficiência em encontrar soluções de Pareto, mantendo um equilíbrio entre a exploração de diferentes soluções e a escolha das melhores soluções em problemas de otimização com duas ou mais dimensões.

## Funcionamento
- **População Inicial:** Geração de uma população inicial aleatória de indivíduos e cálculo dos valores das funções objetivo para cada indivíduo.
- **Seleção:** Seleção dos indivíduos com base em um torneio binário para reprodução.
- **Recombinação e Mutação:** Aplicação de operadores genéticos (crossover e mutação) para gerar uma nova população de descendentes.
- **Combinação:** Combinação das populações dos pais e descendentes para formar uma população unificada.
- **Classificação de Não-dominância:** Classificação da população unificada em frentes de Pareto.
- **Cálculo da Crowding Distance:** Cálculo da distância de aglomeração para cada indivíduo dentro de sua respectiva frente.
- **Seleção da Próxima Geração:** Seleção dos melhores indivíduos com base na classificação de não-dominância e na distância de aglomeração até atingir o tamanho da população original.
- **Repetição:** O loop principal continua até que um critério de parada seja atingido (por exemplo, número máximo de gerações ou tempo de execução).

## Aplicação
- **Otimização Multiobjetivo:** Utilizado em problemas de otimização que envolvem a minimização ou maximização simultânea de duas ou mais funções objetivo.
- **Seleção de Soluções:** Facilita a escolha de soluções não dominadas que são eficazes em termos de objetivos e bem distribuídas ao longo do espaço objetivo.

## Descrição das classes

### `Individuo`
Representa um indivíduo no algoritmo evolutivo, contendo variáveis de decisão e valores de objetivos. Inclui métodos para avaliação das variáveis de decisão e para aplicação de operadores genéticos.

### `Crossover`
Interface para operações de crossover entre dois indivíduos. Define o método `getCrossover`, que combina os genes dos pais para gerar descendentes.

### `CrossoverAritmetico`
Implementa a interface `Crossover` usando um método de crossover aritmético. Este método combina os genes dos pais através de uma média ponderada para gerar novos indivíduos.

### `MutationNone`
Implementa a interface `Mutation` e define um operador de mutação que não altera os genes dos indivíduos. É utilizado em situações onde nenhuma mutação é desejada.

### `MutationPolynomial`
Implementa a interface `Mutation` e define um operador de mutação polinomial. Modifica os genes dos indivíduos com base em uma probabilidade e um índice de distribuição, proporcionando uma variação controlada dos genes.

### `Mutation`
Interface para operações de mutação em indivíduos. Define o método `getMutate`, que aplica alterações nos genes dos indivíduos, respeitando os limites inferiores e superiores.

### `Problema`
Classe abstrata que define métodos para avaliar variáveis de decisão e retornar o número de variáveis de decisão de um problema de otimização. Deve ser estendida por classes específicas para problemas concretos.

### `ProblemaExemplo`
Implementa a classe `Problema` para fornecer uma base para problemas de exemplo. Avalia as variáveis de decisão de acordo com uma função objetivo genérica.

### `ProblemaShaffer`
Implementa a classe `Problema` para o problema de Schaffer, que calcula os objetivos baseados em uma fórmula matemática específica com duas variáveis de decisão.

### `CrowdingDistance`
Avalia a distância de crowding para cada indivíduo em uma lista, que ajuda a manter a diversidade na população. Ordena os indivíduos com base em seus objetivos e na distância de crowding.

### `FNDS`
Implementa o algoritmo Fast Non-Dominated Sort para identificar e formar frentes de Pareto. Classifica a população em frentes baseadas na dominância e cria listas de indivíduos não dominados.

### `Ponto`
Representa um ponto no espaço objetivo, associado a um indivíduo. Contém informações sobre dominância e ranking, sendo utilizado no algoritmo de não-dominância para classificar os indivíduos.

### `RepairSolution`
Contém um método estático para ajustar variáveis que excedem os limites inferiores ou superiores definidos, garantindo que as soluções permaneçam dentro dos limites aceitáveis.

## Contato

Se você tiver alguma dúvida ou sugestão, entre em contato!

---

*Este projeto foi criado por [Joice Barros de Figueiredo](https://github.com/JoyFigueiredo).*
