package PrefeitoSimulator;
import java.util.*;

public class BancoDeEscolhas {
    public static List<Evento> eventosNormais() {
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Uma grande indústria de montagem de carros elétricos quer se instalar às margens do principal rio da cidade, a montadora estima que vai ter que contratar até 3% da população, só com essa notícia pessoas das cidades vizinhas já começam a vir para sua cidade em busca dos futuros empregos existe uma parte da população que teme que essa montadora polua de alguma forma o rio, um grupo de analistas ambientais contratados pela montadora diz que o impacto ambiental vai ser baixo e ativistas ambientais são contra a instalação da montadora alegando que a montadora vai despejar químicos nos rios.",
            new Escolha("Negar instalação", +5, -15, -15, -20,
            "Você nega a montadora, perde investimentos. Parte da população critica a decisão.\n\n +5 de Meio Ambiente\n -15 de Fundos Econômicos\n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Aprovar com o regimento padrão", -15, +25, +10, +10,
            "A economia cresce rapidamente, 3% da população foi contratada, ao contrário do que os críticos diziam a montadora sequer mexe com químicos, uma montadora apenas monta e seus resíduos são poucos e pontuais .\n\n -15 de Meio Ambiente \n +25 de Fundos Econômicos \n +10 de População \n +10 de Aprovação Pública"),

            new Escolha("Aprovar com regras ambientais especiais", 0, +15, +10, +10,
            "A montadora é instalada com sucesso e a regulação garante que o rio fique intacto. A cidade se torna um polo de empregos verdes e a economia gira de forma limpa!\n\n 0 de Meio Ambiente \n +15 de Fundos Econômicos \n +10 de População \n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saneamento está sobrecarregado e começa a falhar em várias regiões, as falhas estão focadas em áreas específicas e tem algumas poucas falhas que se demonstram estruturais.",
            new Escolha("Melhorias pontuais focando nas áreas com defeitos não estruturais", +10, -10, +5, +5,
            "A situação melhora, mas ainda há áreas críticas que estão ligadas com a parte estrutural do sistema de esgoto.\n\n +10 de Meio Ambiente \n -10 de Fundos Econômicos \n +5 de População \n +5 de Aprovação Pública"),

            new Escolha("Adiar investimentos", -25, +5, -15, -20,
            "A crise se agrava, afetando diretamente o meio ambiente e a saúde da população, fazendo com que muitos saiam da sua cidade.\n\n -25 de Meio Ambiente\n +5 de Fundos Econômicos\n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Reforma completa do sistema, com foco sustentável", +20, -20, +10, +20,
            "A cidade dá um salto em qualidade de vida, reduzindo drasticamente doenças e despoluindo rios. A economia nos hospitais ajuda a abater o custo da obra.\n\n +20 de Meio Ambiente \n -20 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));

        eventos.add(new Evento("O trânsito da cidade está ficando insustentável.",
            new Escolha("Ignorar", -10, -5, -20, -25,
            "Congestionamentos pioram e a população perde produtividade.\n\n -10 de Meio Ambiente \n -5 de Fundos Econômicos \n -20 de População \n -25 de Aprovação Pública"),

            new Escolha("Expandir transporte sustentável", +15, -10, +10, +15,
            "Menos carros nas ruas reduz o desgaste do asfalto, poupando fundos a longo prazo. A cidade respira melhor.\n\n +15 de Meio Ambiente \n -10 de Fundos Econômicos \n +10 de População \n +15 de Aprovação Pública"),

            new Escolha("Construir mais avenidas", -20, -20, +15, +10,
            "O trânsito melhora por um tempo, mas o custo da obra é alto e o impacto ambiental cresce.\n\n -20 de Meio Ambiente \n -20 de Fundos Econômicos \n +15 de População \n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma empresa oferece um acordo ilegal para ignorar leis ambientais que esta empresa já vem quebrando há um tempo.",
            new Escolha("Recusar e chantagear a empresa ameaçando fazer uma denúncia", +10, +25, 0, 0,
            "Você mantém o meio ambiente limpo, a empresa para com as atividades e o governo recebe o valor por debaixo dos panos.\n\n +10 de Meio Ambiente \n +25 de Fundos Econômicos"),

            new Escolha("Recusar e denunciar", +15, +10, +5, +20,
            "A justiça é feita. A multa pesada aplicada à empresa vai direto para os cofres da prefeitura!\n\n +15 de Meio Ambiente\n +10 de Fundos Econômicos \n +5 de População \n +20 de Aprovação Pública"),

            new Escolha("Aceitar", -25, +35, 0, -25,
            "Você ganha recursos, mas sua reputação desmorona e o meio ambiente sofre.\n\n -25 de Meio Ambiente \n +35 de Fundos Econômicos \n -25 de Aprovação Pública")
        ));

        eventos.add(new Evento("Uma crise econômica global voltada à escassez de petróleo refinado começa a afetar sua cidade.",
            new Escolha("Criar refinarias de petróleo", -25, +30, +15, +15,
            "A crise quase não afeta a sua cidade, o meio ambiente é sacrificado mas a população consegue muitos empregos.\n\n -25 de Meio Ambiente\n +30 de Fundos Econômicos \n +15 de População \n +15 de Aprovação Pública"),

            new Escolha("Cortar gastos ambientais", -20, +15, -15, -20,
            "A economia melhora no curto prazo, mas a poluição aumenta e as pessoas saem da cidade.\n\n -20 de Meio Ambiente \n +15 de Fundos Econômicos \n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Investir agressivamente em economia verde", +20, +15, +10, +20,
            "Sua cidade não depende de petróleo! Startups verdes se instalam na região, atraindo capital e gerando lucro sustentável no meio da crise.\n\n +20 de Meio Ambiente \n +15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));

        eventos.add(new Evento("Grupos organizam protestos exigindo ações ambientais imediatas.",
            new Escolha("Ignorar, uma hora os protestos vão dispersar", 0, 0, -20, -25,
            "Os protestos crescem, algumas pessoas saem da sua cidade.\n\n -20 de População \n -25 de Aprovação Pública"),

            new Escolha("Dialogar e seguir suas exigências", +10, -15, +15, +25,
            "A população sente que foi ouvida. Algumas reformas custam dinheiro, mas a confiança na gestão explode.\n\n +10 de Meio Ambiente \n -15 de Fundos Econômicos \n +15 de População \n +25 de Aprovação Pública"),

            new Escolha("Reprimir para que não aumente", -5, 0, -15, -35,
            "Os protestos são dispersados à força e sua imagem piora drasticamente.\n\n -5 de Meio Ambiente \n -15 de População \n -35 de Aprovação Pública")
        ));

        eventos.add(new Evento("Sua cidade sofre com uma crise energética, você tem que construir uma nova fonte de energia trocando as antigas termoelétricas da sua cidade.",
            new Escolha("Energia nuclear dividida com outras cidades", +25, -40, +30, +30, 
            "Você constrói a usina nuclear dividindo os custos. Energia abundante e barata a longo prazo. A população aprova.\n\n +25 de Meio Ambiente \n -40 de Fundos Econômicos \n +30 de População \n +30 de Aprovação Pública"),

            new Escolha("Energia solar integrada (telhados públicos e indústrias)", +20, -15, +10, +20,
            "Você incentiva a instalação de painéis solares em tetos já existentes, sem precisar desmatar. O investimento se paga rapidamente com a economia na conta de luz da prefeitura.\n\n +20 de Meio Ambiente \n -15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública"),

            new Escolha("Energia hidrelétrica (pequena represa)", -10, -15, +10, +20,
            "Uma grande área é alagada, destruindo a flora original. É pouco poluente no ar, mas afeta o bioma local.\n\n -10 de Meio Ambiente \n -15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um desastre ambiental ameaça áreas da cidade.",
            new Escolha("Resposta econômica, focando no pós-desastre", -25, +10, -35, -40,
            "A situação sai do controle, dezenas de pessoas morrem e centenas ficam feridas, a reconstrução da cidade é coberta pelo seguro, a aprovação despenca.\n\n -25 de Meio Ambiente\n +10 de Fundos Econômicos\n -35 de População \n -40 de Aprovação Pública"),

            new Escolha("Resposta rápida, priorizar vidas a todo o custo ", -10, -35, 0, +40,
            "Quase ninguém foi diretamente afetado, vidas foram salvas, as pessoas perderam suas casas, o custo foi alto e você vira um herói da cidade.\n\n -10 de Meio Ambiente \n -35 de Fundos Econômicos \n 0 de População \n +40 de Aprovação Pública"),

            new Escolha("Resposta eficiente, salvar o máximo possível de tudo", +10, -20, -15, +15,
            "A infraestrutura da cidade é salva, as pessoas também, mas nem todas.\n\n +10 de Meio Ambiente \n -20 de Fundos Econômicos \n -15 de População \n +15 de Aprovação Pública")
        ));

        eventos.add(new Evento("A cidade discute implementar coleta seletiva de lixo.",
            new Escolha("Projeto piloto", +10, -5, +5, +10,
            "Algumas regiões já mostram resultados positivos.\n\n +10 de Meio Ambiente \n -5 de Fundos Econômicos \n +5 de População \n +10 de Aprovação Pública"),

            new Escolha("Ignorar", -20, 0, -10, -15,
            "O acúmulo de lixo se torna um problema crescente.\n\n -20 de Meio Ambiente\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Implementar totalmente e criar usinas de reciclagem", +30, +10, +15, +20,
            "A cidade reduz drasticamente o lixo nos aterros. A venda de materiais recicláveis e o reaproveitamento geram lucro para os cofres públicos!\n\n +30 de Meio Ambiente \n +10 de Fundos Econômicos \n +15 de População \n +20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Há uma proposta de incentivo à energia solar residencial.",
            new Escolha("Não incentivar", -15, +5, -5, -10,
            "A cidade fica para trás na transição energética.\n\n -15 de Meio Ambiente\n +5 de Fundos Econômicos\n -5 de População\n -10 de Aprovação Pública"),

            new Escolha("Bancar instalação parcial através de financiamento público", +25, -10, +15, +20,
            "A prefeitura subsidia parte dos custos e a cidade se torna referência em energia limpa. O custo final é muito mais amigável do que pagar tudo.\n\n +25 de Meio Ambiente\n -10 de Fundos Econômicos\n +15 de População\n +20 de Aprovação Pública"),

            new Escolha("Incentivo apenas em redução de burocracia", +10, 0, +5, +10,
            "Parte da população adere à ideia sem custo adicional para a prefeitura.\n\n +10 de Meio Ambiente\n 0 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("O consumo de água está aumentando rapidamente.",
            new Escolha("Aumentar os reservatórios", -15, -25, +20, +20,
            "A cidade caminha para uma crise hídrica.\n\n -15 de Meio Ambiente \n -25 de Fundos Econômicos \n +20 de População \n +20 de Aprovação Pública"),

            new Escolha("Campanhas educativas", +10, -5, +5, +10,
            "A população reduz o consumo parcialmente.\n\n +10 de Meio Ambiente\n -5 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Políticas de controle e reúso industrial", +25, +5, +5, +15,
            "A água de reúso é vendida para as indústrias por um preço acessível, gerando receita e poupando água potável.\n\n +25 de Meio Ambiente\n +5 de Fundos Econômicos\n +5 de População\n +15 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um escândalo político envolvendo membros do seu governo vem à tona.",
            new Escolha("Negar envolvimento", 0, +5, -15, -25,
            "A população fica desconfiada e sua imagem é abalada.\n\n +5 de Fundos Econômicos\n -15 de População\n -25 de Aprovação Pública"),

            new Escolha("Investigar e punir os responsáveis", 0, -10, +10, +25,
            "Você mostra firmeza e transparência, recuperando a confiança da população, mesmo com custos políticos.\n\n -10 de Fundos Econômicos\n +10 de População\n +25 de Aprovação Pública"),

            new Escolha("Abafar o caso com suborno", 0, -25, -10, -30,
            "A verdade começa a vazar e sua credibilidade despenca rapidamente.\n\n -25 de Fundos Econômicos \n -10 de População \n -30 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um grande investidor quer abrir diversos negócios na cidade.",
            new Escolha("Negociar condições equilibradas", -5, +15, +10, +15,
            "O investimento chega de forma controlada, beneficiando a cidade de forma justa.\n\n -5 de Meio Ambiente\n +15 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública"),

            new Escolha("Recusar proposta", +10, -20, -10, -15,
            "Você evita riscos, mas perde uma grande oportunidade econômica.\n\n +10 de Meio Ambiente\n -20 de Fundos Econômicos\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Aceitar com incentivos fiscais", -20, +25, +15, +10,
            "A economia cresce rapidamente, mas há críticas sobre benefícios excessivos ao setor privado.\n\n -20 de Meio Ambiente\n +25 de Fundos Econômicos\n +15 de População\n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("A cidade pode sediar um grande festival cultural.",
            new Escolha("Evento moderado", -5, -10, +10, +15,
            "O festival agrada, sem comprometer tanto o orçamento.\n\n -5 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública"),

            new Escolha("Investir pesado no evento", -15, -30, +20, +30,
            "O evento é um sucesso e aumenta a felicidade da população, mas gera custos altos.\n\n -15 de Meio Ambiente\n -30 de Fundos Econômicos\n +20 de População\n +30 de Aprovação Pública"),

            new Escolha("Cancelar", +5, +15, -15, -20,
            "A população fica decepcionada com a falta de iniciativas culturais.\n\n +5 de Meio Ambiente\n +15 de Fundos Econômicos\n -15 de População\n -20 de Aprovação Pública")
        ));

        eventos.add(new Evento("O sistema de saúde da cidade está sobrecarregado.",
            new Escolha("Incentivar fiscalmente a saúde privada", -5, +25, -15, -10,
            "A saúde melhora, a economia também, porém nem todos podem pagar.\n\n -5 de Meio Ambiente \n +25 de Fundos Econômicos \n -15 de População \n -10 de Aprovação Pública"),

            new Escolha("Investir fortemente na saúde", +5, -35, +25, +25,
            "A qualidade de atendimento melhora e a população se sente mais segura.\n\n +5 de Meio Ambiente\n -35 de Fundos Econômicos\n +25 de População\n +25 de Aprovação Pública"),

            new Escolha("Melhorias básicas", +5, -15, +10, +10,
            "A situação melhora parcialmente, mas ainda há filas e problemas.\n\n +5 de Meio Ambiente\n -15 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("O governo lhe faz um repasse equivalente a 15 pontos de fundos econômicos, o que fazer?",
            new Escolha("Manter a verba", 0, +25, 0, 0,
            "A verba foi guardada para os cofres.\n\n +25 de Fundos Econômicos"),

            new Escolha("Pagar um show de música gratuito", 0, -5, 0, +30,
            "A aprovação sobe vertiginosamente.\n\n -5 de Fundos Econômicos\n +30 de Aprovação Pública"),

            new Escolha("Investir em modernização e corte de poluentes", +25, +10, +5, +15,
            "O meio ambiente agradece, e a cidade economiza a longo prazo com saúde pública e eficiência energética!\n\n +25 de Meio Ambiente\n +10 de Fundos Econômicos\n +5 de População\n +15 de Aprovação Pública")
        ));

        return eventos;
    }

    public static List<Evento> eventoAprovacaoAlta() {
        List<Evento> eventoAprovacaoAlta = new ArrayList<>();

        eventoAprovacaoAlta.add(new Evento("URGENTE!!\n\nSua popularidade está em alta! A população confia na sua gestão e apoia novas iniciativas.",
            new Escolha("Aprovar reformas econômicas estratégicas", -10, +30, +10, +10,
            "Você utiliza o momento para fortalecer a economia, mantendo boa aprovação.\n\n -10 de Meio Ambiente\n +30 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Manter a estabilidade e evitar riscos", 0, +10, +5, -5,
            "Você opta por não arriscar, mantendo a cidade estável, mas sem grandes avanços.\n\n +10 de Fundos Econômicos\n +5 de População\n -5 de Aprovação Pública"),

            new Escolha("Lançar grandes projetos para a cidade", +10, -25, +20, +15,
            "Você aproveita o apoio popular para investir em melhorias. A população fica satisfeita, mas os custos são elevados.\n\n +10 de Meio Ambiente\n -25 de Fundos Econômicos\n +20 de População\n +15 de Aprovação Pública")
        ));

        return eventoAprovacaoAlta;
    }

    public static List<Evento> eventoAprovacaoBaixa() {
        List<Evento> eventoAprovacaoBaixa = new ArrayList<>();

        eventoAprovacaoBaixa.add(new Evento("URGENTE!!\n\nA população perdeu a fé no seu mandato. Protestos pedindo sua saída começam a ganhar força nas ruas!",
            new Escolha("Ignorar e focar em alianças políticas nos bastidores", 0, +20, -15, -15,
            "Você garante apoio financeiro dos deputados, mas o povo continua revoltado e alguns abandonam a cidade.\n\n +20 de Fundos Econômicos\n -15 de População\n -15 de Aprovação Pública"),

            new Escolha("Fazer um pronunciamento oficial prometendo bônus e auxílios", 0, -30, 0, +30,
            "Você acalma os ânimos distribuindo recursos públicos. A aprovação sobe temporariamente, mas os cofres sofrem.\n\n -30 de Fundos Econômicos\n +30 de Aprovação Pública"),

            new Escolha("Iniciar um grande mutirão de obras públicas para gerar empregos", -15, -20, +15, +20,
            "A resposta prática agrada o povo e traz pessoas de volta para a economia ativa, embora agrida o meio ambiente.\n\n -15 de Meio Ambiente\n -20 de Fundos Econômicos\n +15 de População\n +20 de Aprovação Pública")
        ));

        return eventoAprovacaoBaixa;
    }

    public static List<Evento> eventoAmbienteAlto() {
        List<Evento> eventoAmbienteAlto = new ArrayList<>();

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade foi reconhecida internacionalmente como uma das mais sustentáveis do mundo.",
            new Escolha("Aproveitar o reconhecimento para atrair investimentos", +10, +25, +15, +15,
            "Empresas sustentáveis se interessam pela cidade, fortalecendo a economia sem perder o foco ambiental.\n\n +10 de Meio Ambiente\n +25 de Fundos Econômicos\n +15 de População\n +15 de Aprovação Pública"),

            new Escolha("Investir para se tornar referência global", +25, -35, +20, +20,
            "Você amplia políticas ambientais e transforma a cidade em referência mundial. O custo é alto, mas o prestígio cresce muito.\n\n +25 de Meio Ambiente\n -35 de Fundos Econômicos\n +20 de População\n +20 de Aprovação Pública"),

            new Escolha("Não investir mais e manter como está", -15, +10, -20, -20,
            "Sem novos esforços, a cidade começa a perder destaque ao longo do tempo.\n\n -15 de Meio Ambiente\n +10 de Fundos Econômicos\n -20 de População\n -20 de Aprovação Pública")
        ));

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nSua cidade se tornou referência ambiental e foi convidada para sediar um grande evento internacional sobre sustentabilidade.",
            new Escolha("Recusar e manter estabilidade", -5, +5, -10, -15,
            "Sem novos investimentos, a cidade mantém seus níveis, mas perde a chance de crescer como referência global.\n\n -5 de Meio Ambiente\n +5 de Fundos Econômicos\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Firmar parcerias e dividir os custos", +10, -10, +10, +10,
            "Você consegue sediar o evento com apoio externo, equilibrando ganhos ambientais e custos financeiros.\n\n +10 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Investir pesado para sediar o evento", +15, -25, +15, +15,
            "A cidade ganha visibilidade mundial e fortalece suas políticas ambientais. O investimento é alto, mas o prestígio compensa.\n\n +15 de Meio Ambiente\n -25 de Fundos Econômicos\n +15 de População\n +15 de Aprovação Pública")
        ));

        return eventoAmbienteAlto;
    }

    public static List<Evento> eventoAmbienteBaixo() {
        List<Evento> eventoAmbienteBaixo = new ArrayList<>();

        eventoAmbienteBaixo.add(new Evento("URGENTE!!\n\nA poluição atingiu níveis críticos! Uma nuvem de fumaça tóxica cobre a cidade e os hospitais estão cheios.",
            new Escolha("Implementar um plano emergencial de arborização e filtros urbanos", +20, -15, +5, +10,
            "Uma solução moderada que começa a limpar o ecossistema sem quebrar as pernas da economia local.\n\n +20 de Meio Ambiente\n -15 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Maquiar os dados e focar em remédios para a população", -25, +10, -25, -35,
            "A crise de saúde piora, o meio ambiente é destruído e as pessoas fogem da cidade doente.\n\n -25 de Meio Ambiente\n +10 de Fundos Econômicos\n -25 de População\n -35 de Aprovação Pública"),

            new Escolha("Decretar lockdown industrial e multar severamente os poluidores", +35, -35, -15, +15,
            "O ar melhora drasticamente, mas indústrias param, gerando desemprego e fazendo trabalhadores saírem da cidade.\n\n +35 de Meio Ambiente\n -35 de Fundos Econômicos\n -15 de População\n +15 de Aprovação Pública")
        ));

        return eventoAmbienteBaixo;
    }

    public static List<Evento> eventoEconomiaAlta() {
        List<Evento> eventoEconommiaAlta = new ArrayList<>();

        eventoEconommiaAlta.add(new Evento("URGENTE!!\n\nSua cidade foi destaque nacional pelo forte crescimento econômico. Investidores e mídia elogiam sua gestão.",
            new Escolha("Manter a situação atual", 0, +10, +5, -5,
            "Você mantém a estabilidade, garantindo crescimento moderado sem grandes riscos.\n\n +10 de Fundos Econômicos\n +5 de População\n -5 de Aprovação Pública"),

            new Escolha("Expandir investimentos públicos", -10, -30, +25, +20,
            "Você reinveste na cidade, melhorando serviços e qualidade de vida. A população aprova, mas os cofres diminuem.\n\n -10 de Meio Ambiente\n -30 de Fundos Econômicos\n +25 de População\n +20 de Aprovação Pública"),

            new Escolha("Atrair mais empresas e ampliar a economia", -25, +35, +15, +10,
            "Novos negócios chegam à cidade, aumentando ainda mais a economia, mas com impacto ambient.\n\n -25 de Meio Ambiente\n +35 de Fundos Econômicos\n +15 de População\n +10 de Aprovação Pública")
        ));

        return eventoEconommiaAlta;
    }
    
    public static List<Evento> eventoEconomiaBaixa() {
        List<Evento> eventoEconimiaBaixa = new ArrayList<>();

        eventoEconimiaBaixa.add(new Evento("URGENTE!!\n\nA economia da cidade entrou em colapso. Empresas estão fechando e o desemprego cresce rapidamente.",
            new Escolha("Aumentar impostos para recuperar os cofres", 0, +30, -20, -30,
            "A arrecadação melhora, mas a população e empresas reagem negativamente.\n\n +30 de Fundos Econômicos\n -20 de População\n -30 de Aprovação Pública"),

            new Escolha("Não intervir e esperar recuperação natural", 0, -25, -20, -25,
            "A crise se agrava e afeta todos os setores da cidade.\n\n -25 de Fundos Econômicos\n -20 de População\n -25 de Aprovação Pública"),

            new Escolha("Plano agressivo de recuperação econômica", -25, +40, +10, +15,
            "Você toma medidas ousadas que reativam a economia rapidamente, mas com custos ambientais e riscos futuros.\n\n -25 de Meio Ambiente\n +40 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública")
        ));

        return eventoEconimiaBaixa;
    }

    public static List<Evento> eventoPopulacaoAlta() {
        List<Evento> eventoPopulacaoAlta = new ArrayList<>();

        eventoPopulacaoAlta.add(new Evento("URGENTE!!\n\nA explosão demográfica sobrecarregou a infraestrutura urbana. Transporte e habitação estão em colapso!",
            new Escolha("Cobrar uma taxa de imigração e novos moradores", 0, +25, -25, -20,
            "A arrecadação sobe e o crescimento da população é freado à força, mas a medida é vista como autoritária.\n\n +25 de Fundos Econômicos\n -25 de População\n -20 de Aprovação Pública"),

            new Escolha("Construir conjuntos habitacionais verticais rápidos", -25, -20, +25, +15,
            "Você abriga as novas famílias, expandindo a capacidade urbana, mas o impacto ambiental nas áreas periféricas é alto.\n\n -25 de Meio Ambiente\n -20 de Fundos Econômicos\n +25 de População\n +15 de Aprovação Pública"),

            new Escolha("Expandir o perímetro urbano sobre áreas verdes", -35, -15, +35, +20,
            "A cidade cresce sem barreiras acomodando todo mundo, mas destrói completamente as reservas ambientais locais.\n\n -35 de Meio Ambiente\n -15 de Fundos Econômicos\n +35 de População\n +20 de Aprovação Pública")
        ));

        return eventoPopulacaoAlta;
    }

    public static List<Evento> eventoPopulacaoBaixa() {
        List<Evento> eventoPopulacaoBaixa = new ArrayList<>();

        eventoPopulacaoBaixa.add(new Evento("URGENTE!!\n\nA cidade está virando uma 'cidade fantasma'. A falta de mão de obra ameaça fechar o comércio local.",
            new Escolha("Não fazer nada e reduzir o tamanho dos serviços públicos", +20, +15, -20, -25,
            "O ecossistema se recupera sem humanos por perto e o custo de manutenção cai, mas o comércio entra em depressão.\n\n +20 de Meio Ambiente\n +15 de Fundos Econômicos\n -20 de População\n -25 de Aprovação Pública"),

            new Escolha("Investir em automação e tecnologia para suprir a falta de pessoas", 0, -35, -5, +10,
            "Os cofres esvaziam com tecnologia cara. As empresas continuam funcionando com robôs, mas a cidade continua vazia.\n\n -35 de Fundos Econômicos\n -5 de População\n +10 de Aprovação Pública"),

            new Escolha("Oferecer isenção de impostos e moradia grátis para novos imigrantes", -10, -30, +35, +15,
            "Uma enxurrada de novas pessoas chega atraída pelos benefícios, reaquecendo as ruas e mudando a dinâmica da cidade.\n\n -10 de Meio Ambiente\n -30 de Fundos Econômicos\n +35 de População\n +15 de Aprovação Pública")
        ));

        return eventoPopulacaoBaixa;
    }
}