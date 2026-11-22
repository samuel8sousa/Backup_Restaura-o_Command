public class SelecionarDVDCommand implements Comando {

    private final Sound som;

    public SelecionarDVDCommand(Sound som) {
        this.som = som;
    }

    @Override
    public void execute() {
        som.setDvd();
    }

    @Override
    public String registro() {
        return "SOUND_DVD";
    }
}
