package dispositivos.tv;

import core.Comando;

public class DefinirEntradaTVCommand implements Comando {

    private final TV tv;
    private final String entrada;

    public DefinirEntradaTVCommand(TV tv, String entrada) {
        this.tv = tv;
        this.entrada = entrada;
    }

    @Override
    public void execute() {
        tv.setInputChannel(entrada);
    }

    @Override
    public String registro() {
        return "TV_INPUT:" + entrada;
    }
}
