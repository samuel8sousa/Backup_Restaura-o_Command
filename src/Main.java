import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String caminho = "dados/historico.txt";

        System.out.println("=== CASA ORIGINAL ===");

        Casa original = new Casa();

        ControleRemoto controle =
                new ControleRemoto(caminho);

        // Configurando os dispositivos da casa
        controle.executar(
                new LigarLuzCommand(original.getLuz()));

        controle.executar(
                new VentiladorAltoCommand(original.getVentilador()));

        controle.executar(
                new LigarTVCommand(original.getTv()));

        controle.executar(
                new DefinirEntradaTVCommand(
                        original.getTv(), "HDMI1"));

        controle.executar(
                new DefinirVolumeTVCommand(
                        original.getTv(), 25));

        controle.executar(
                new LigarSomCommand(original.getSom()));

        controle.executar(
                new SelecionarCDCommand(original.getSom()));

        controle.executar(
                new DefinirVolumeSomCommand(
                        original.getSom(), 15));

        controle.executar(
                new SubirGaragemCommand(original.getGaragem()));

        controle.executar(
                new PararGaragemCommand(original.getGaragem()));

        controle.executar(
                new AtivarCirculacaoCommand(original.getBanheira()));

        controle.executar(
                new LigarJatosCommand(original.getBanheira()));

        controle.executar(
                new DefinirTemperaturaCommand(
                        original.getBanheira(), 38));

        controle.executar(
                new ArmarSegurancaCommand(original.getSeguranca()));

        // Guardar o estado original para comparar depois
        String antes = original.resumoEstado();

        System.out.println("\n--- ESTADO ANTES DA PANE ---");
        System.out.println(antes);

        // Simular pane com novos objetos
        System.out.println("\n=== PANE ELETRICA ===");

        Casa restaurada = new Casa();

        System.out.println(
                "--- NOVA CASA ANTES DA RESTAURACAO ---");

        System.out.println(restaurada.resumoEstado());

        // Criar outro controle e recuperar o arquivo
        System.out.println("\n=== RESTAURANDO DO ARQUIVO ===");

        ControleRemoto novoControle =
                new ControleRemoto(caminho);

        novoControle.load(restaurada);

        // Conferir se a recuperacao funcionou
        String depois = restaurada.resumoEstado();

        System.out.println(
                "\n--- ESTADO APOS A RESTAURACAO ---");

        System.out.println(depois);

        System.out.println(
                "\nEstados iguais? " + antes.equals(depois));

        System.out.println(
                "Historico salvo em: " + caminho);
    }
}
