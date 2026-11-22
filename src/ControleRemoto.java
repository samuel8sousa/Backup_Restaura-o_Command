import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ControleRemoto {

    private final Path arquivo;
    private final List<Comando> historico = new ArrayList<>();

    public ControleRemoto(String caminhoArquivo) {
        this.arquivo = Paths.get(caminhoArquivo);
    }

    public void executar(Comando comando) throws IOException {
        comando.execute();
        historico.add(comando);
        store();
    }

    public void store() throws IOException {

        List<String> registros = new ArrayList<>();

        for (Comando comando : historico) {
            registros.add(comando.registro());
        }

        Path pasta = arquivo.getParent();

        if (pasta != null) {
            Files.createDirectories(pasta);
        }

        Files.write(
                arquivo,
                registros,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

    public void load(Casa casaRestaurada) throws IOException {

        if (!Files.exists(arquivo)) {
            throw new IOException(
                    "Historico nao encontrado: " + arquivo);
        }

        List<String> linhas = Files.readAllLines(
                arquivo,
                StandardCharsets.UTF_8
        );

        historico.clear();

        for (int i = 0; i < linhas.size(); i++) {

            String linha = linhas.get(i).trim();

            if (linha.isEmpty()) {
                continue;
            }

            try {
                Comando comando = FabricaComandos.criar(
                        linha, casaRestaurada);

                comando.execute();
                historico.add(comando);

            } catch (IllegalArgumentException erro) {
                throw new IOException(
                        "Erro na linha " + (i + 1)
                                + " do historico: " + linha,
                        erro
                );
            }
        }
    }
}
