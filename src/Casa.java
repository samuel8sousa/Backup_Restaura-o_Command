
public class Casa {

    private final Light luz = new Light();
    private final CeilingFan ventilador = new CeilingFan();
    private final TV tv = new TV();
    private final Sound som = new Sound();
    private final GarageDoor garagem = new GarageDoor();
    private final Hottub banheira = new Hottub();
    private final SecurityControl seguranca = new SecurityControl();

    public Light getLuz() {
        return luz;
    }

    public CeilingFan getVentilador() {
        return ventilador;
    }

    public TV getTv() {
        return tv;
    }

    public Sound getSom() {
        return som;
    }

    public GarageDoor getGaragem() {
        return garagem;
    }

    public Hottub getBanheira() {
        return banheira;
    }

    public SecurityControl getSeguranca() {
        return seguranca;
    }

    public String resumoEstado() {
        return "Luz ligada: " + luz.isLigada() + "\n"
                + "Ventilador velocidade: " + ventilador.getSpeed() + "\n"
                + "TV: ligada=" + tv.isLigada()
                + ", entrada=" + tv.getCanalEntrada()
                + ", volume=" + tv.getVolume() + "\n"
                + "Som: ligado=" + som.isLigado()
                + ", fonte=" + som.getFonte()
                + ", volume=" + som.getVolume() + "\n"
                + "Garagem: " + garagem.getEstado() + "\n"
                + "Banheira: circulacao=" + banheira.isCirculando()
                + ", jatos=" + banheira.isJatosLigados()
                + ", temperatura=" + banheira.getTemperatura() + "\n"
                + "Seguranca armada: " + seguranca.isArmado();
    }
}
