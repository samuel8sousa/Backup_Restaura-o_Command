package dispositivos.som;

import core.Comando;

public class LigarSomCommand implements Comando {

    private final Sound som;

    public LigarSomCommand(Sound som) {
        this.som = som;
    }

    @Override
    public void execute() {
        som.on();
    }

    @Override
    public String registro() {
        return "SOUND_ON";
    }
}
