Avaliação para Desenvolvedor de Software – Softplan UNIC

    Candidato: Leandro Silva Ferreira - leandrosilvaferreira@gmail.com

Desafios implementados:

    1 - Cálculo de Custo de Transporte
    2 - Geração do texto de observação para faturas

Requisitos:

    * Java 8
    * Maven 3

Arquitetura da Aplicação:

    * Java 8
    * Maven
        - Lombok: Utilizado para encapsular a geração de métodos Get, Set, Construtores, Builders, auxiliar na definição de Classes Utilitárias
                  e contribuir para que o projeto fique menos verboso e mais conciso
        - JUnit: Utilizado nos testes unitários
        - Commons Collections 4: Utilizada para validação de listas nulas/vazias

Observações

    1 - Cálculo de Custo de Transporte

        * Classes de Implementação:
            * br.com.softplan.enums.RoadType
            * br.com.softplan.enums.VehicleType
            * br.com.softplan.model.transport.TransportData
            * br.com.softplan.service.transport.TransportCostCalculator
            * br.com.softplan.util.NumberUtils
            * br.com.softplan.Main

        * Classes de Teste:
            * br.com.softplan.enums.RoadTypeTest
            * br.com.softplan.enums.VehicleTypeTest
            * br.com.softplan.model.transport.TransportDataTest
            * br.com.softplan.service.transport.TransportCostCalculatorTest
            * br.com.softplan.util.NumberUtilsTest


        * Para que fossem mantidos os padrões de nomenclatura das classes fornecidas, optei por utilizar a língua inglesa na criação dos artefatos

        * Optei por utilizar enums para a definição dos veículos e estradas (VehicleType e RoadType). A utilização de interfaces com implementações concretas
          para cada tipo de veiculo e estrada seria também uma escolha plausível, porém como se tratam de classes simples, geraria um excesso de complexidade,
          adicionado artefatos para interface e classes concretas, além do fato da necessidade de criação de novas classes caso fosse criados novos tipos de
          veículos ou estradas. Com a utilização de enums, a complexidade foi reduzida e os conceitos de orientação a objetos foram mantidos, permitindo por
          exemplo, caso fosse necessário adicionar um novo tipo de veículo, apenas incluir uma linha na classe VehicleType.

        * No enum VehicleType, foi implementado o método 'valueOf' recebendo int para facilitar a obtenção de uma instância a partir do vehicleId. Fiz isso para
          manter a implementação dos testes conforme foram fornecidos, passando int como parâmetro do id do veículo para a classe TransportData. Outro fator
          que motivou a implementação deste método é para que fosse possível definir "manualmente" o código do veículo(1,2,3), uma vez que poderia ser utilizada
          a ordem dos elementos na definição do enum como vehicleId, porém essa escolha iria impedir no futuro que um vehicleId de determinado tipo de veículo
          fosse alterado ou que fosse inserido um novo veículo entre os veículos já pré existentes.

        * A classe TransportData foi simplificada com a utilização do Lombok, assim como foram incluídos métodos auxiliares, como um novo método que calcula
          a distância total percorrida, levando em conta estradas pavimentadas e não pavimentadas, assim como um método que verifica se os atributos preenchidos
          da classe atendem a regra negocial informando se determinada instância é válida ou não. Outro método auxiliar adicionado nessa classe foi um
          método que já retorna o tipo de veículo (VehicleType) a partir do vehicleId definido, facilitando sua utilização posterior.

        * Foi criada a classe NumberUtils com objetivo de auxiliar na formatação, arrendondamento e escala de casas decimais para valores numéricos. Nessa classe,
          foi utilizada a anotação @UtilityClass do Lombok que força as características de uma classe utilitária, como construtores em modo privado, utilização
          de 'final' na declaração da classe e a marcação como 'static' de todos métodos, campos e classes internas.

        * Na classe TransportCostCalculator foram criados métodos privados com objetivo de realizar cálculos secundários e separar as responsabilidades distintas
          como cálculo do custo de transporte em redovias pavimentadas, em rodovias não pavimentadas, cálculo de excesso de peso e cálculo de custo de excesso
          de peso.

        * Conforme solicitado no desafio, foi criada a classe Main para executar esse desafio. Nesse caso, foram utilzados como valores de entrada a tabela de
          exemplo sugerida na descrição do desafio técnico.

        * Embora não solicitado explicitamente na descrição do desafio, foi adicionado um total geral informando o total de custo de uma lista de transportes
          realizados.

    2 - Geração do texto de observação para faturas

        * Classes de Implementação:
            * br.com.softplan.model.invoice.Invoice
            * br.com.softplan.service.invoice.GeradorObservacao

        * Classes de Teste:
            * br.com.softplan.model.invoice.InvoiceTest
            * br.com.softplan.service.invoice.GeradorObservacaoTest

        * As IDEs, assim como o Maven, irão reclamar da utilização de classes depreciadas no projeto, mas isso se deve à opção de anotar o método
          'String geraObservacao(final List<Integer> lista)' da classe GeradorObservacao como @Deprecated uma vez que na documentação da demanda informava que
          o mesmo iria ser descontinuado em um futuro próximo, porém devia continuar existindo durante o período de transição.

        * Quanto ao refactoring do código legado, foram seguidas as seguintes estratégias:

            * A Lista que é passada por parâmetro ao método 'public String geraObservacao(List lista)' foi tipada com o tipo de elemento, no caso, Integer para
            tornar o parâmetro type safe assim como facilitar na utilização da lista internamente dentro do método com os benefícios do generics.

            * O campo "texto" também foi removido, primeiro por que não era explicitamente necessário, e segundo que por não ser imutável poderia gerar comportamentos
            inesperados uma vez que não era thread safe.

            * Como estratégia para composição do texto na mensagem em singular ou plural ('da nota fiscal' ou 'das notas fiscais'), de acordo com o tamanho da lista
            de elementos, foi utilizada a API MessageFormat do Java, fazendo subistituição dinâmica do texto a ser utilizado de acordo com a quantidade de itens.
            Isso tornou o código muito mais simples, legível e menos suscetível a erros.

            * A iteração entre os elementos da lista também teve sua estratégia alterada, removendo o uso de Iterators e utilizando streams do Java8, com o benefício
            das 'functional interfaces' permitindo em uma única linha percorrer todos os itens da lista, converter os inteiros para string, concatená-os utilizando
            o caracter 'vírgula' como separador e adicionado um ponto no final da string gerada.

            * Um desafio interessante foi alterar a última vírgula da string resultante e substituí-la pela letra 'e'. Entre tantas implementações possíveis, sendo
            a maioria verbosas e deselegantes, escolhi a utilização de replace all com um padrão de regex com aparantes benefícios de sua utilização como a redução
            considerável de linhas de código, ifs, checagens de tamanho da lista, implementações sucessíveis a erros como "index out of bound", etc. Essa estratégia
            permitiu também que todo o processo de concatenação e geração da string resultante fosse feito em uma única linha.

        * Quanto à implementação do novo método gerando a observação de uma forma mais completa conforme a especificação descrita no texto do desafio

            * Primeiramente foi criada a classe Invoice para representar uma fatura, contendo seu código e valor. Nessa classe também foi implementado um método
            'getDescription' o qual já retorno a descrição da fatura levando em conta seu código e valor.

            * O novo método recebe uma lista de Invoice (List<Invoice>), permitindo assim que os dados de código e valor de cada uma delas possam ser acessados de
            forma facilitada, inclusive permitindo a somatório do total geral.

            * A API MessageFormat também foi utilizada para obter o texto final com o total geral das faturas já formatado.

            * Assim como no método anterior, foram utilizadas streams do Java8, com o benefício das 'functional interfaces' permitindo em uma única linha percorrer
            todos os itens da lista, concatenar as descrições das invoices utilizando o caracter 'vírgula' como separador e adicionado um ponto no final da string gerada.
            Além disso, também foi reutilizado o padrão regex definido anteriormente para através de um replace all substituir a vírgula pela letra 'e' no texto
            que concatena as descrições das invoices.

            * Ao fim, também foi adicionado à mensagem de observação o texto com o detalhamento do total geral das invoices passadas na lista.

Executando o Projeto:

    * Na raiz do projeto, no console, executar: mvn clean exec:java

Executando os Testes:

    * Na raiz do projeto, no console, executar: mvn clean test