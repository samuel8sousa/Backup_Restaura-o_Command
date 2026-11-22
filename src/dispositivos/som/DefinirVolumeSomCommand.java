package dispositivos.som;

import core.Comando;

public class DefinirVolumeSomCommand implements Comando {

    private final Sound som;
    private final int volume;

    public DefinirVolumeSomCommand(Sound som, int volume) {
        this.som = som;
        this.volume = volume;
    }

    @Override
    public void execute() {
        som.setVolume(volume);
    }

    @Override
    public String registro() {
        return "SOUND_VOLUME:" + volume;
    }
}
