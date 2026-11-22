
public class DefinirVolumeTVCommand implements Comando {

    private final TV tv;
    private final int volume;

    public DefinirVolumeTVCommand(TV tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    @Override
    public void execute() {
        tv.setVolume(volume);
    }

    @Override
    public String registro() {
        return "TV_VOLUME:" + volume;
    }
}
