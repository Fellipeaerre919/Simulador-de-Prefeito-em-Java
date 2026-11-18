 🏙️ Prefeito Simulator

Um jogo de simulação desenvolvido em Java, no qual o jogador assume o papel de prefeito e precisa administrar uma cidade, tomando decisões diante de diferentes situações e desafios.

Cada escolha gera consequências que afetam diretamente os indicadores municipais. O objetivo é equilibrar economia, meio ambiente, população e aprovação pública durante o mandato.

 🎮 Sobre o projeto

O **Prefeito Simulator** apresenta situações relacionadas à administração pública, economia, infraestrutura, meio ambiente e questões sociais.

Durante cada rodada, o jogador recebe um evento e precisa escolher entre três alternativas. Cada decisão modifica os indicadores da cidade, podendo trazer benefícios para determinadas áreas e prejuízos para outras.

O jogo também possui eventos especiais, que podem aparecer conforme os indicadores municipais e as condições estabelecidas na lógica do jogo.

 📊 Indicadores municipais

O jogo possui quatro indicadores principais:

| Indicador | Descrição |
|---|---|
| 🌳 Meio Ambiente | Representa condições ambientais e sustentabilidade. |
| 💰 Economia | Representa os recursos econômicos disponíveis. |
| 👥 População | Representa as condições da população municipal. |
| 🏛️ Aprovação Pública | Representa a aceitação das decisões do prefeito. |

Todos os indicadores começam em 50 pontos e variam entre 0 e 100.

Se qualquer indicador atingir zero, a partida termina.

 ⚙️ Funcionalidades

- Sistema de eventos com decisões alternativas.
- Três opções de escolha por evento.
- Consequências específicas para cada decisão.
- Atualização dinâmica dos indicadores municipais.
- Limites mínimos e máximos para os indicadores.
- Eventos especiais condicionados aos indicadores.
- Sorteio de eventos especiais.
- Sistema de rodadas com limite configurado de 20.
- Interface gráfica com barras de progresso.
- Exibição das consequências após cada decisão.
- Sistema de encerramento da partida.

 🛠️ Tecnologias utilizadas

- **Java:** linguagem principal do projeto.
- **Java Swing:** desenvolvimento da interface gráfica.
- **Java AWT:** componentes gráficos e personalização visual.

 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO).
- Classes, atributos e métodos.
- Encapsulamento.
- Construtores e métodos acessores.
- Arrays e ArrayList.
- Estruturas condicionais e de repetição.
- Geração de números aleatórios.
- Manipulação de eventos e ações na interface gráfica.
- Separação entre lógica do jogo e interface gráfica.

## 📁 Estrutura do projeto

```text
Jogo/
└── PrefeitoSimulator/
    ├── BancoDeEscolhas.java
    ├── Escolha.java
    ├── Evento.java
    ├── Jogo.java
    ├── JogoUI.java
    ├── Main.java
    └── imagens/
        └── cidade.jpg
```

 Organização das classes

| Classe | Responsabilidade |
|---|---|
| `Main` | Inicialização do jogo. |
| `Jogo` | Gerenciamento das rodadas, indicadores e regras. |
| `JogoUI` | Construção e atualização da interface gráfica. |
| `BancoDeEscolhas` | Armazenamento e organização dos eventos. |
| `Evento` | Estrutura dos eventos e suas alternativas. |
| `Escolha` | Definição das decisões e suas consequências. |

 ▶️ Como executar

**Pré-requisitos:**
- Java JDK instalado.
- IDE compatível com Java ou terminal.

**Executando pelo terminal:**

1. Clone o repositório:

```bash
git clone https://github.com/Fellipeaerre919/Simulador-de-Prefeito-em-Java.git
```

2. Entre na pasta do projeto:

```bash
cd Simulador-de-Prefeito-em-Java/Jogo
```

3. Compile os arquivos:

```bash
javac PrefeitoSimulator/*.java
```

4. Execute o jogo:

```bash
java PrefeitoSimulator.Main
```

**Importante:** execute os comandos a partir da pasta `Jogo`, mantendo a estrutura original das pastas e a imagem `cidade.jpg`.

 🎯 Objetivo acadêmico

O projeto foi desenvolvido com o objetivo de aplicar conhecimentos de Java e Programação Orientada a Objetos na criação de uma aplicação interativa.

Durante o desenvolvimento, foram trabalhados conceitos de estruturas de dados, lógica de programação, manipulação de eventos e construção de interfaces gráficas.

---

👥 Equipe de desenvolvimento

Projeto desenvolvido em equipe por:

Fellipe Rodrigues Alves

Pedro Henrique Santos de Almeida

Rafael Piña Kasbergen

Thales Duarte de Oliveira

Desenvolvido como projeto acadêmico para aplicação prática de conhecimentos em Java e Programação Orientada a Objetos.
