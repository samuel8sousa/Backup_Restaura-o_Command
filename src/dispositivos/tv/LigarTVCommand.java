package dispositivos.tv;

import core.Comando;

public class LigarTVCommand implements Comando {

    private final TV tv;

    public LigarTVCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public String registro() {
        return "TV_ON";
    }
}
