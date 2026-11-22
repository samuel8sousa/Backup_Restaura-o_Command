package dispositivos.garagem;

import core.Comando;

public class SubirGaragemCommand implements Comando {

    private final GarageDoor garagem;

    public SubirGaragemCommand(GarageDoor garagem) {
        this.garagem = garagem;
    }

    @Override
    public void execute() {
        garagem.up();
    }

    @Override
    public String registro() {
        return "GARAGE_UP";
    }
}
