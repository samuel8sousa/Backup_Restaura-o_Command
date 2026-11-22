
public class SelecionarRadioCommand implements Comando {

    private final Sound som;

    public SelecionarRadioCommand(Sound som) {
        this.som = som;
    }

    @Override
    public void execute() {
        som.setRadio();
    }

    @Override
    public String registro() {
        return "SOUND_RADIO";
    }
}
