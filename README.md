# Password Validation Demo
Baseando-se nas regras apresentadas pelo case, construiu-se a API presente neste repositório que contém um endpoint exposto para validar as senhas.

# Instruções para executar a aplicação
1. Clone o repositório ou baixe o projeto.
2. Importe/Abra o projeto em sua IDE de preferência.
3. Baixe as dependências do Maven
4. Já em sua IDE, abra a classe DemoApplication.java, clique com o botão direito e mande executar(geralmente a opção Run. Obs: não é necessário selecionar um perfil).
5. O endpoint está exposto em http://localhost:8080/password-validation
  
     5.1 Exemplo de utilização via Postman
    ![image](https://user-images.githubusercontent.com/107516470/186043235-a5b3ef07-6ea0-4bf9-abcf-77e4a28d70ac.png)


# Sobre a construção da aplicação
Tentou-se abstrair ao máximo, simplificando e deixando o código mais limpo e fácil de compreender o possível. O código contempla apenas o que foi pedido pelo case, sem explorar
mais afundo conceitos de perfis de execução, setup de portas e context path, não utilizou-se de documentação padrão(swagger) e nem mesmo componentização, devido à baixa complexidade
da funcionalidade. Durante a construção da aplicação tentou-se utilizar o conceito de Clean Architecture, separando os pacotes de acordo - o que pode ser mais explorado no
futuro em que se queira deixar a aplicação mais robusta(para o problema atual, nem modelos foram necessários utilizar). Utilizou-se, também, do conceito de encapsulamento,
enquanto mantiam-se as responsabilidades das classes.

Um problema emergente foi que a requisição era passível de valores nulos, o que causava uma exception durante o runtime e que teve que ser tratada adequadamente, pois fugia
do Pattern estabelecido para avaliação - e que nem mesmo atingia essa parte do fluxo, sendo que quebrava a requisição já ao parsear esta - como se pode ver durante um dos testes
de integração. Acatando a premissa deve-se ter o número mínimo de caracteres mas null não contém, e então decidiu-se retornar false ao invés de um erro.

No mais, a lógica empreendida foi fazer com que o Pattern descrito pelo problema fosse transformado em um regex para que pudesse se utilizar do método .matches do Pattern do 
Java e com isso parte da solução já estava compreendida. A parte restante era checar por caracteres repetidos na string e então considerou-se que nesse caso "A" e "a"
são coisas distintas, por exemplo. Para tanto criou-se um método que itera pela própria string, comparando se o char na posicao X era como Y, onde Y = X+1 e este se atualiza a cada
iteração, varrendo assim o charset completo. Tendo em vista que o primeiro char(X(0)) não se repete, vamos para o próximo em X(1) e assim recursivamente(olhamos apenas para
frente, pois o que ficou para trás já foi validado). Tudo isso implementado com lógica booleana, pois as condições devem ser combinadas - se alguma das condições for falsa,
o programa já entende que não é uma senha valida e retorna false. Além disso, deixou-se a parte da iteração sendo a segunda parte da validação, pois consome mais tempo de processamento - 
caso alguma condição de Pattern não seja atendida, esse será false e então não precisamos entrar nos laços de validação de chars repetidos.

O Fluxograma


![image](https://user-images.githubusercontent.com/107516470/186045795-dccee330-67f2-486c-a5a3-98cf1d8e72c5.png)

O Fluxograma não contempla processo de validação de regex - feito por terceiro - e nem lógica de check de duplicidade de char na string, que já foi explicado acima e está
descrito no código. Os Patterns de regex estão explicados nos comentários do código

Além disso, os testes foram separados por testes de unidade - que contém a lógica do negócio - e testes de integração - que testam a responsividade do endpoint, e claro testam
a lógica para os cenários de true, false e exception. Para os testes, criei um enum que contempla uma senha válida e duas validas - sendo que uma destas passa pelo Pattern
mas que falha na duplicidade de chars. Para o teste de integração, testei a exception em que o body vem null, ao não setar o .content do mockMvc. As nomenclaturas dos
testes são autoexplicativas, assim como as classes, métodos e variáveis em geral.
