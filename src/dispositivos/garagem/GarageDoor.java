package dispositivos.garagem;

public class GarageDoor {

    private String estado = "PARADA";


    public void up() {
        estado = "SUBINDO";
        System.out.println("Porta da garagem subindo");
    }

    public void down() {
        estado = "DESCENDO";
        System.out.println("Porta da garagem descendo");
    }

    public void stop() {
        estado = "PARADA";
        System.out.println("Porta da garagem parada");
    }

    public String getEstado() {
        return estado;
    }
}