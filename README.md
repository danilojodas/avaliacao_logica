
# Desafio de programação

Este repositório contém o código-fonte e o arquivo executável JAR da avaliação de lógica de programação da TaxWeB.

## Instruções para executar os programas do teste de lógica:

1. Instale o JRE (Java Runtime Environment) 8 ou superior neste [link](https://www.oracle.com/technetwork/pt/java/javase/downloads/jre8-downloads-2133155.html).
2. Faça o fork deste projeto para a sua conta no Github.
3. Faça o clone do repositório do projeto para uma pasta do seu computador.
4. Abra o terminal de comando do seu sistema operacional e acesse a pasta para onde foi feito o clone do repositorio.
5. Acesso o diretorio **avaliacao_logica**.
6. Execute o seguinte comando no terminal para carregar o programa:
```
java -jar Avaliacao.jar
```

## Explicação da solução do Desafio Especial "Matriz"

A solução proposta neste projeto para retornar um quadrado 2x2 de vogais de um array de Strings informadas pelo usuário consiste na utilização de um HashSet contendo todas as combinações de vogais que devem ser procuradas em cada String do array. O objeto HashSet possui 25 combinações de duas vogais, o que corresponde 5 combinações para cada vogal. O HashSet é uma estrutura de dados que possui um tempo de resposta menor do que ArrayList. A busca de dados no ArrayList é linear e de complexidade O(n), sendo n o número de elementos contidos no ArrayList. Já no HashSet a busca possui uma complexidade constante O(1) para acesso à um elemento em particular, o que torna a busca muito mais rápida comparada com o ArrayList.

O objeto HashSet com as combinações de vogais está no método **quadradosDeVogais(String[] strArr)** implementado na classe **QuadradoVogais.java**. O método recebe um array do tipo String. Um par de caracteres da String avaliada é recuperado juntamente com o par de caracteres no mesmo índice na linha abaixo da que está atualmente a ser avaliada. Se houver uma ocorrência para os dois pares de vogais no HashSet de combinações de vogais, os índices da linha e coluna do par de letras da String avaliada é adicionada à uma lista de índices que é retornada após o término do método. Nota-se que esta operação é semelhante ao acesso aos elementos de uma matriz NxM, sendo N o número de linhas e M o número de colunas.

Quanto à complexidade do algoritmo, o tempo de resposta depende da quantidade de Strings contida no array. Semelhante à uma matriz NxM, o acesso à cada String é da ordem de O(N). A complexidade do acesso à cada caracter da String avaliada é O(M). Portanto, a complexidade para ler todos os caracteres é da ordem de O(N`*`M). Cada caracter da String avaliada é usado para formar o par de letras da linha atual e da linha seguinte, o que resulta numa complexidade O(4). A complexidade do acesso à combinação de vogais no HashSet para cada par de letras é da ordem de 2`*`O(1). Portanto, podemos considerar que a complexidade da solução implementada é:

**O(N`*`M`*`4)2`*`O(1)**

Portanto, o tempo de processamento é linear em relação ao número Strings que serão avaliadas. É importante notar que a complexidade para acessar um elemento do HashSet é constante em relação ao número de combinações e, portanto, pouco influencia no tempo do algoritmo.
