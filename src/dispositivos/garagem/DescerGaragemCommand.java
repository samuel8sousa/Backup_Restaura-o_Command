package dispositivos.garagem;

import core.Comando;

public class DescerGaragemCommand implements Comando {

    private final GarageDoor garagem;

    public DescerGaragemCommand(GarageDoor garagem) {
        this.garagem = garagem;
    }

    @Override
    public void execute() {
        garagem.down();
    }

    @Override
    public String registro() {
        return "GARAGE_DOWN";
    }
}
