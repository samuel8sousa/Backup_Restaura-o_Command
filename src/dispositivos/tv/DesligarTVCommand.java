package dispositivos.tv;

import core.Comando;

public class DesligarTVCommand implements Comando {

    private final TV tv;

    public DesligarTVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public String registro() {
        return "TV_OFF";
    }
}
