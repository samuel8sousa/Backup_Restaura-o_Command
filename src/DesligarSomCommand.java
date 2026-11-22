
public class DesligarSomCommand implements Comando {

    private final Sound som;

    public DesligarSomCommand(Sound som) {
        this.som = som;
    }

    @Override
    public void execute() {
        som.off();
    }

    @Override
    public String registro() {
        return "SOUND_OFF";
    }
}
