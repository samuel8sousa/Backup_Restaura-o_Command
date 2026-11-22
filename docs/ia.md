# Registro de uso de Inteligência Artificial — Questão 2

**Atividade:** Lista Avaliativa II — Padrões de Projetos Orientados a Objetos  
**Questão:** 2 — Backup e Restauração de uma Casa Automatizada  
**Linguagem:** Java  
**Padrão de projeto:** Command  
**Integrantes:** [Inserir nomes da dupla]  
**Ferramenta utilizada:** ChatGPT (OpenAI)

> **Nota sobre a fidelidade deste registro:** este documento relata as orientações e correções discutidas com a IA. A existência de uma sugestão de código ou de teste **não comprova** que ela tenha sido implementada ou executada. Os campos de validação, modificações próprias e commits devem ser preenchidos com evidências reais antes da entrega.

## 1. Objetivo do uso da IA

A IA foi utilizada como apoio didático para compreender e aplicar o padrão Command, dividir a implementação em etapas, identificar erros de Java e planejar os mecanismos de persistência e restauração de comandos. O objetivo do projeto é simular dispositivos de uma casa, registrar suas ações em arquivo e reconstruir os estados depois de uma pane elétrica simulada.

A estratégia adotada nas orientações foi separar **dispositivos** (responsáveis por modificar seus estados) de **comandos** (responsáveis por encapsular solicitações). A interface `Comando` foi considerada com os métodos `execute()` e `registro()`. O primeiro executa a ação; o segundo fornece um identificador para o histórico.

## 2. Registro cronológico das principais interações

### Interação 1 — Entendimento da atividade e organização dos commits

**Solicitação feita à IA (trecho):**

> “Analise o documento, veja as três primeiras atividades e explique como fazer cada uma [...] passo a passo e o pq de cada coisa, para que cada parte possa ser enviada por commit.”

**Orientação recebida:** divisão da questão 2 em implementação dos dispositivos, comandos concretos, classe de integração, fábrica, controle remoto, persistência, recuperação e testes. Foram sugeridas mensagens de commit para registrar etapas compreensíveis.

**Decisão a documentar pela dupla:** [Informar se a divisão foi seguida integralmente e quais alterações foram feitas.]

### Interação 2 — Primeiro comando de luz

**Código enviado para análise:** `DesligarLuzCommand`, implementando `Comando`, recebendo `Light` pelo construtor, chamando `luz.off()` em `execute()` e retornando `LIGHT_OFF` em `registro()`.

**Orientação recebida:** a estrutura apresentada estava adequada ao padrão Command. A IA explicou o papel de `private final`, do construtor, de `execute()` e da representação textual do comando. Também sugeriu testar o estado da luz por meio de um getter.

**Aprendizado:** quem solicita a ação não precisa alterar diretamente os atributos do dispositivo; chama `execute()` de um objeto de comando.

### Interação 3 — Ventilador (`CeilingFan`)

**Solicitação feita à IA (trecho):**

> “Etapa 4 — CeilingFan [...] Crie o ventilador com um atributo `velocidade` e os métodos `high()`, `medium()`, `low()`, `off()` e `getSpeed()` [...] Explique como fazer essa parte e o pq.”

**Orientação recebida:** representar as velocidades com `0` (desligado), `1` (baixo), `2` (médio) e `3` (alto); criar um comando concreto por ação; consultar o estado com `getSpeed()`; preparar registros `FAN_HIGH`, `FAN_MEDIUM`, `FAN_LOW` e `FAN_OFF`.

**Justificativa:** a velocidade é parte do estado que deve ser reproduzido após a pane.

### Interação 4 — Erro real de compilação em `Light`

**Erro apresentado no PowerShell:**

```text
src\Ligth.java:1: error: class Light is public, should be declared in a file named Light.java
```

Também foi apresentada uma tentativa de executar `TesteCeilingFan` com `ClassNotFoundException`.

**Diagnóstico e orientação recebida:** o arquivo `Ligth.java` estava com o nome diferente da classe pública `Light`. A IA orientou renomeá-lo para `Light.java`, compilar novamente e somente depois executar o teste. A ausência da classe compilada pode explicar a falha de execução.

**Correção efetivamente aplicada:** [Confirmar se o arquivo foi renomeado.]  
**Resultado após correção:** [Inserir saída real da compilação e do teste.]

### Interação 5 — Televisão (`TV`): implementação e revisão

**Solicitação/ação:** foram enviados códigos para `LigarTVCommand` e `DesligarTVCommand`. Entre os trechos apresentados estavam `this.TV = TV`, `TV.on()`, `TV.off()` e um construtor `DesligarLuzCommand` dentro de `DesligarTVCommand`.

**Diagnóstico e orientação recebida:**

- `TV` é o nome da classe; `tv` é a variável. Para armazenar o objeto recebido, utilizar `this.tv = tv`.
- `on()` e `off()` são métodos de instância; por isso, chamar `tv.on()` e `tv.off()`.
- O construtor deve possuir exatamente o nome da classe (`DesligarTVCommand`).

**Aprendizado:** Java diferencia maiúsculas e minúsculas, e construtores não possuem tipo de retorno.

### Interação 6 — Outros erros reais durante o teste da TV

Foram apresentados três problemas sucessivos:

**a) Construtor incompatível**

```text
src\DesligarTVCommand.java:5: error: invalid method declaration; return type required
    public DesligarLuzCommand(TV tv) {
```

A IA explicou que o compilador não reconhecia o nome como construtor da classe `DesligarTVCommand`.

**b) Arquivo e classe pública com nomes diferentes**

```text
src\Main.java:1: error: class TesteTV is public, should be declared in a file named TesteTV.java
```

Foi sugerido renomear o arquivo para `TesteTV.java` ou alterar a classe para `Main`, mantendo a execução coerente com a escolha.

**c) Classe de comando não encontrada**

```text
src\TesteTV.java:8: error: cannot find symbol
        Comando entrada = new DefinirEntradaTVCommand(tv, "HDMI1");
```

A IA orientou conferir a existência do arquivo e da classe `DefinirEntradaTVCommand`, seu nome e seu método `execute()`, responsável por chamar `tv.setInputChannel(entrada)`.

**Resultado confirmado:** os erros acima foram apresentados no terminal. Não há, nesses registros, confirmação de compilação final bem-sucedida da TV.  
**Resultado após ajustes:** [Preencher com a saída real do seu teste.]

### Interação 7 — Recomeço da implementação da TV

**Prompt enviado:**

> “esqueça parte da tv que foi feito até agora e comece a explicar do começo”

**Orientação recebida:** reestruturar a TV desde os atributos `ligada`, `canalEntrada` e `volume`, implementar `on()`, `off()`, `setInputChannel()` e `setVolume()`, depois criar quatro comandos e um teste isolado `TesteTV`.

Foi enfatizado que os comandos parametrizados devem armazenar o valor recebido no construtor e incluí-lo no registro, como `TV_INPUT:HDMI1` e `TV_VOLUME:25`.

**Justificativa:** restaurar somente se a TV estava ligada não reproduz sua entrada e seu volume anteriores.

### Interação 8 — Sistema de som (`Sound`)

**Prompt enviado:**

> “agora explique como implementar a proxima parte da casa”

**Orientação recebida:** criar `Sound` com estado ligado/desligado, fonte de áudio e volume; implementar `on()`, `off()`, `setCd()`, `setDvd()`, `setRadio()` e `setVolume()`; criar os seis comandos correspondentes e `TesteSound`.

**Registros sugeridos:** `SOUND_ON`, `SOUND_OFF`, `SOUND_CD`, `SOUND_DVD`, `SOUND_RADIO` e `SOUND_VOLUME:<valor>`.

**Aprendizado:** operações sem parâmetros identificam diretamente seu resultado; comandos de volume precisam guardar o valor configurado.

### Interação 9 — Porta de garagem (`GarageDoor`)

**Prompt enviado:**

> “proximo aparelho”

**Orientação recebida:** criar `GarageDoor` com estados lógicos `SUBINDO`, `DESCENDO` e `PARADA`; implementar `up()`, `down()` e `stop()`; criar os comandos `SubirGaragemCommand`, `DescerGaragemCommand` e `PararGaragemCommand`, além de um teste.

**Registros sugeridos:** `GARAGE_UP`, `GARAGE_DOWN` e `GARAGE_STOP`.

**Limitação identificada:** `PARADA` indica apenas o estado lógico na simulação; não informa a posição física da porta. A repetição de movimentos só é adequada ao exercício simulado, não a uma instalação real sem sensores e verificações de segurança.

### Interação 10 — Banheira (`Hottub`)

**Prompt enviado:**

> “proximo aparelho”

**Orientação recebida:** criar `Hottub` com atributos `circulando`, `jatosLigados` e `temperatura`; implementar `circulate()`, `jetsOn()`, `jetsOff()` e `setTemperature(int)`; criar quatro comandos e `TesteHottub`.

**Registros sugeridos:** `HOTTUB_CIRCULATE`, `HOTTUB_JETS_ON`, `HOTTUB_JETS_OFF` e `HOTTUB_TEMP:<valor>`.

**Aprendizado:** circulação, jatos e temperatura são informações independentes. O registro da temperatura precisa incluir o valor para permitir a reconstrução.

### Interação 11 — Sistema de segurança (`SecurityControl`)

**Prompt enviado:**

> “faça o ultimo”

**Orientação recebida:** criar `SecurityControl` com atributo `boolean armado`, implementar `arm()` e `disarm()`, acrescentar `isArmado()` para teste, criar `ArmarSegurancaCommand`, `DesarmarSegurancaCommand` e `TesteSecurityControl`.

**Registros sugeridos:** `SECURITY_ARM` e `SECURITY_DISARM`.

**Aprendizado:** separar ações explícitas de armar e desarmar evita depender de uma operação de alternância cujo resultado mudaria conforme o estado anterior.

### Interação 12 — Planejamento da conclusão da questão 2

**Prompt enviado:**

> “quais são os proximos passos para terminar a questão 2”

**Orientação recebida:** integrar os dispositivos em `Casa`, reconstruir registros com `FabricaComandos`, executar e persistir comandos com `ControleRemoto`, implementar `store()` e `load()`, simular a pane em `Main` e comparar os estados antes e depois.

### Interação 13 — Solicitação dos códigos de integração explicados

**Prompt enviado:**

> “Faltou mostrar como fica cada codigo e explicar ele”

**Orientação recebida:** foram apresentados exemplos completos de `Casa.java`, `FabricaComandos.java`, `ControleRemoto.java` e `Main.java`, acompanhados de explicações sobre as responsabilidades de cada classe.

**Decisões propostas:**

| Elemento | Finalidade |
|---|---|
| `Casa` | Manter uma instância de cada um dos sete dispositivos e fornecer getters |
| `FabricaComandos.criar()` | Interpretar registros como `TV_VOLUME:25` e criar o comando correto para a nova casa |
| `ControleRemoto.executar()` | Executar um comando, guardá-lo no histórico em memória e chamar `store()` |
| `store()` | Converter comandos em textos com `registro()` e gravar o histórico em `dados/historico.txt` |
| `load()` | Ler registros, recriar comandos e executá-los em ordem sem gravá-los novamente durante a recuperação |
| `Main` | Configurar uma casa, criar outra para simular a pane e comparar os estados |

**Pontos de atenção discutidos:** os identificadores usados na fábrica devem corresponder aos retornados por `registro()`; a fábrica deve extrair parâmetros numéricos; o arquivo precisa manter a ordem dos comandos; e a casa restaurada deve conter novos dispositivos, não referências aos objetos originais.

### Interação 14 — Documentação do repositório

**Prompt enviado:**

> “faça oque colocar no readme”

**Orientação recebida:** elaboração de um `README.md` com objetivo, descrição do padrão Command, dispositivos disponíveis, estrutura de pastas, instruções de compilação e execução, exemplo de histórico, resultados esperados e limitações.

**Prompt atual:**

> “Também faça oque colocar no ia.md”

**Objetivo deste arquivo:** registrar de modo verificável como a IA foi utilizada na análise, no desenvolvimento, na correção de erros e na documentação da questão.

## 3. Decisões de projeto e justificativas

**Interface comum (`Comando`):** possibilita executar ações de dispositivos diferentes por meio do mesmo método `execute()`.

**Comandos concretos:** cada comando representa uma operação. Exemplos: `LigarTVCommand`, `SelecionarCDCommand` e `ArmarSegurancaCommand`.

**Parâmetros no construtor:** valores de entrada, volume e temperatura precisam ser guardados no próprio comando para poderem ser reconstruídos posteriormente.

**Método `registro()`:** representa a operação como texto, permitindo persistência sem serializar objetos Java completos.

**Arquivo de histórico:** mantém os registros na ordem de execução. A solução proposta salva o histórico após cada comando, reduzindo a janela de perda de dados na simulação.

**Fábrica:** converte cada linha do arquivo em um comando vinculado aos dispositivos da casa restaurada.

**Reexecução ordenada:** permite recuperar o último estado definido pelas operações para cada dispositivo.

**Simulação de pane:** cria uma nova instância de `Casa` e restaura seus estados usando os registros persistidos, sem reutilizar os objetos antigos.

## 4. Testes e evidências a preencher

Os seguintes comandos foram recomendados para a compilação e execução pelo PowerShell, a partir da raiz do projeto:

```powershell
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Também foram propostos testes individuais, como `TesteCeilingFan`, `TesteTV`, `TesteSound`, `TesteGarageDoor`, `TesteHottub` e `TesteSecurityControl`.

**Resultado real da compilação final:** [Inserir saída ou registrar "sem erros" somente depois de executar.]  
**Resultado real da restauração:** [Inserir saída do terminal. Verificar se aparece `Estados iguais? true`.]  
**Arquivo de histórico gerado:** [Confirmar existência e conteúdo de `dados/historico.txt`.]  
**Teste de parâmetros:** [Verificar recuperação de `TV_INPUT`, `TV_VOLUME`, `SOUND_VOLUME` e `HOTTUB_TEMP`.]  
**Teste da ordem dos comandos:** [Descrever a sequência executada e o estado final.]  
**Teste de registro inválido ou arquivo ausente:** [Inserir resultado, se realizado.]

> **Importante:** a execução bem-sucedida dos exemplos não foi comprovada pelas mensagens de terminal disponíveis nesta conversa. Não registrar testes sugeridos como se tivessem sido realizados.

## 5. Modificações realizadas pela dupla

Preencher esta seção **apenas com alterações efetivamente feitas** em relação às orientações da IA.

| Arquivo ou etapa | Sugestão original | Alteração realizada pela dupla | Motivo |
|---|---|---|---|
| `Light.java` | Nomear arquivo igual à classe pública | [Preencher] | [Preencher] |
| Comandos da TV | Corrigir construtores e nomes das referências | [Preencher] | [Preencher] |
| `TV.java` | Usar `boolean`, `String` e `int` para os estados | [Preencher] | [Preencher] |
| `ControleRemoto.java` | Persistir e restaurar histórico textual | [Preencher] | [Preencher] |
| `FabricaComandos.java` | Interpretar identificadores dos comandos | [Preencher] | [Preencher] |
| Testes | Comparar estados antes e depois da pane | [Preencher] | [Preencher] |

Se algum arquivo foi utilizado exatamente como sugerido, registrar isso com transparência em vez de inventar uma alteração.

## 6. Histórico de commits

Para consultar o histórico real do repositório:

```powershell
git log --oneline --reverse
```

Os exemplos abaixo são **mensagens sugeridas pela IA**, não comprovantes de commits já realizados:

| Etapa | Exemplo de commit | Hash real |
|---|---|---|
| Dispositivos e comandos | `feat: implementar comandos de controle dos dispositivos` | [Preencher com commits reais] |
| Integração da casa | `feat: integrar dispositivos na classe Casa` | [Preencher] |
| Fábrica | `feat: criar fabrica para reconstruir comandos` | [Preencher] |
| Persistência | `feat: implementar execucao e persistencia de comandos` | [Preencher] |
| Restauração | `feat: implementar leitura e recuperacao do historico` | [Preencher] |
| Simulação | `feat: simular pane eletrica e restauracao da casa` | [Preencher] |
| Documentação | `docs: documentar implementacao e testes de restauracao` | [Preencher] |

Se foram feitos vários commits pequenos para os dispositivos, listar cada um com seu hash. **Não criar commits retroativos apenas para corresponder a esta tabela.**

## 7. Limitações e cuidados

O sistema foi planejado como simulação acadêmica, sem dispositivos físicos. A movimentação da garagem e o acionamento da banheira ou do sistema de segurança não devem ser interpretados como procedimentos seguros para equipamentos reais.

A persistência proposta regrava o histórico após cada comando, o que é simples para a atividade, mas não assegura gravação atômica em caso de interrupção durante a escrita. O exemplo de `load()` também pode ter executado parte do histórico caso encontre um registro inválido no meio do arquivo. Essas limitações foram mantidas fora do escopo principal da solução didática.

## 8. Considerações finais

O uso da IA teve caráter de orientação e revisão: forneceu explicações, exemplos de implementação, interpretações de erros e sugestões de testes. A conclusão da questão depende da implementação efetiva pela dupla, da conferência do código no ambiente local, dos testes finais e do registro fiel das alterações e commits no GitHub.
