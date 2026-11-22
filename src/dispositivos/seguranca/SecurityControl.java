package dispositivos.seguranca;

public class SecurityControl {

    private boolean armado = false;

    public void arm() {
        armado = true;
        System.out.println("Sistema de seguranca armado");
    }

    public void disarm() {
        armado = false;
        System.out.println("Sistema de seguranca desarmado");
    }

    public boolean isArmado() {
        return armado;
    }
}
