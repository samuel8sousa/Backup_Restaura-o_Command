package dispositivos.garagem;

import core.Comando;

public class PararGaragemCommand implements Comando {

    private final GarageDoor garagem;

    public PararGaragemCommand(GarageDoor garagem) {
        this.garagem = garagem;
    }

    @Override
    public void execute() {
        garagem.stop();
    }

    @Override
    public String registro() {
        return "GARAGE_STOP";
    }
}
