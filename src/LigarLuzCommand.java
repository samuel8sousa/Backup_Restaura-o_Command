
public class LigarLuzCommand implements Comando {

    private final Light luz;

    public LigarLuzCommand(Light luz) {
        this.luz = luz;
    }

    @Override
    public void execute() {
        luz.on();
    }

    @Override
    public String registro() {
        return "LIGHT_ON";
    }
}
