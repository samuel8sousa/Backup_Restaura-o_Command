public class SelecionarCDCommand implements Comando {

    private final Sound som;

    public SelecionarCDCommand(Sound som) {
        this.som = som;
    }

    @Override
    public void execute() {
        som.setCd();
    }

    @Override
    public String registro() {
        return "SOUND_CD";
    }
}
