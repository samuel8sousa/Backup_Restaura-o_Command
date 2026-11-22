# Backup e Restauração de uma Casa Automatizada

**Lista Avaliativa II — Padrões de Projetos Orientados a Objetos**

**Questão 2 — Padrão Command**

## 1. Sobre o projeto

Este projeto foi desenvolvido em Java e simula uma casa automatizada, na qual diferentes dispositivos podem ser controlados por comandos.

O objetivo é aplicar o padrão de projeto **Command**, permitindo registrar as operações realizadas pelos dispositivos e recuperar suas configurações após uma pane elétrica simulada.

Para isso, o sistema armazena o histórico dos comandos em um arquivo de texto e posteriormente utiliza esse histórico para reconstruir os estados da residência.

## 2. Dispositivos da casa

| Dispositivo | Funcionalidades |
|---|---|
| Light | Ligar e desligar a luz |
| CeilingFan | Controlar as velocidades do ventilador |
| TV | Ligar, desligar, selecionar entrada e ajustar volume |
| Sound | Ligar, desligar, selecionar CD, DVD ou rádio e ajustar volume |
| GarageDoor | Subir, descer e parar a porta |
| Hottub | Ativar circulação, controlar jatos e definir temperatura |
| SecurityControl | Armar e desarmar a segurança |

Cada dispositivo possui atributos para armazenar seu estado e métodos responsáveis por modificá-lo.

## 3. Padrão de projeto utilizado

O padrão **Command** encapsula uma solicitação em um objeto, separando quem solicita uma operação de quem a executa.

Neste projeto, a interface `Comando` define dois métodos:

- `execute()`: executa a operação do dispositivo.
- `registro()`: retorna um identificador textual que representa a operação.

Por exemplo, `LigarTVCommand` representa a solicitação de ligar a televisão. Ao executar esse comando, o método `execute()` chama `on()` no objeto `TV`.

Essa separação permite armazenar diferentes comandos em uma mesma lista e reconstruí-los posteriormente.

## 4. Estrutura do projeto

```text
Backup_e_Restauração/
├── src/
│   ├── Comando.java
│   ├── Light.java
│   ├── CeilingFan.java
│   ├── TV.java
│   ├── Sound.java
│   ├── GarageDoor.java
│   ├── Hottub.java
│   ├── SecurityControl.java
│   ├── [classes de comandos]
│   ├── Casa.java
│   ├── FabricaComandos.java
│   ├── ControleRemoto.java
│   └── Main.java
├── docs/
│   └── ia.md
├── dados/
│   └── historico.txt
└── README.md
```

A pasta `dados` e o arquivo `historico.txt` são criados automaticamente durante a execução.

### Classes principais

**Casa.java:** reúne os sete dispositivos da residência e disponibiliza métodos para acessá-los.

**ControleRemoto.java:** executa os comandos, mantém o histórico e realiza as operações de armazenamento e recuperação.

**FabricaComandos.java:** interpreta os registros textuais do histórico e recria os objetos de comando.

**Main.java:** executa a simulação principal, incluindo a configuração da casa, a pane elétrica e a restauração.

## 5. Como executar

### Requisitos

- Java JDK instalado (recomenda-se Java 11 ou superior).
- Terminal ou PowerShell.
- Não são necessárias bibliotecas externas.

### Compilação

Na pasta principal do projeto, execute:

```powershell
javac -encoding UTF-8 -d out src/*.java
```

### Execução

Após compilar sem erros, execute:

```powershell
java -cp out Main
```

O programa executará uma sequência de comandos, salvará o histórico, simulará uma pane elétrica e tentará restaurar as configurações da casa.

## 6. Funcionamento do backup e da restauração

O sistema realiza o processo em cinco momentos.

**1. Configuração inicial:** uma instância de `Casa` é criada, contendo todos os dispositivos em seus estados iniciais.

**2. Execução e armazenamento:** o controle remoto executa os comandos e utiliza `store()` para gravar o histórico em `dados/historico.txt`.

**3. Pane elétrica:** o programa simula a perda dos estados criando uma nova instância de `Casa`.

**4. Restauração:** o método `load()` lê o histórico salvo. A classe `FabricaComandos` reconstrói os comandos, que são executados novamente sobre os dispositivos da nova casa.

**5. Comparação:** o programa compara os estados da casa original e da casa restaurada para verificar se as configurações foram recuperadas.

## 7. Exemplo de histórico

Durante a execução, o arquivo `historico.txt` poderá conter:

```text
LIGHT_ON
FAN_HIGH
TV_ON
TV_INPUT:HDMI1
TV_VOLUME:25
SOUND_ON
SOUND_CD
SOUND_VOLUME:15
GARAGE_UP
GARAGE_STOP
HOTTUB_CIRCULATE
HOTTUB_JETS_ON
HOTTUB_TEMP:38
SECURITY_ARM
```

Os registros representam as operações na ordem em que foram executadas.

Comandos como `TV_VOLUME:25` e `HOTTUB_TEMP:38` também armazenam seus parâmetros, permitindo recuperar os valores configurados.

## 8. Resultado esperado

Ao executar a simulação corretamente, o programa deverá apresentar uma comparação dos estados antes e depois da pane.

O resultado final esperado é:

```text
Estados iguais? true
Historico salvo em: dados/historico.txt
```

Isso indica que, no cenário de teste, os estados representados na casa restaurada correspondem aos estados da casa original.

O resultado precisa ser confirmado por meio da execução do projeto.

## 9. Testes e validação

A validação deve verificar:

- Se os comandos modificam corretamente os estados dos dispositivos.
- Se o histórico é armazenado no arquivo.
- Se a ordem dos comandos é preservada.
- Se valores como volume, entrada e temperatura são recuperados.
- Se os estados antes e depois da restauração correspondem.
- Se o método `load()` não duplica os comandos no arquivo.

Também podem ser executadas as classes de teste individuais desenvolvidas para cada dispositivo.

## 10. Uso de inteligência artificial

A inteligência artificial foi utilizada como ferramenta de apoio ao aprendizado e ao desenvolvimento.

Durante a implementação, foram solicitadas explicações sobre o padrão Command, a responsabilidade de cada classe, a criação dos comandos e a identificação de erros de compilação.

As interações com a IA, as orientações recebidas e as modificações realizadas durante o desenvolvimento estão documentadas no arquivo [docs/ia.md](docs/ia.md).

## 11. Limitações

O projeto representa uma simulação acadêmica de automação residencial.

Não há comunicação com dispositivos físicos. A pane elétrica é simulada por meio da criação de novos objetos, e a restauração ocorre pela reprodução do histórico de comandos.

O programa não implementa sensores físicos, autenticação ou mecanismos de segurança necessários para controlar equipamentos reais.

## 12. Autoria

**Integrantes:** [Inserir nomes da dupla]

**Disciplina:** Padrões de Projetos Orientados a Objetos

**Atividade:** Lista Avaliativa II — Questão 2
