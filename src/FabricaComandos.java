public class FabricaComandos {

    public static Comando criar(String registro, Casa casa) {

        String[] partes = registro.split(":", 2);
        String tipo = partes[0];

        switch (tipo) {

            // LUZ
            case "LIGHT_ON":
                return new LigarLuzCommand(casa.getLuz());

            case "LIGHT_OFF":
                return new DesligarLuzCommand(casa.getLuz());

            // VENTILADOR
            case "FAN_HIGH":
                return new VentiladorAltoCommand(casa.getVentilador());

            case "FAN_MEDIUM":
                return new VentiladorMedioCommand(casa.getVentilador());

            case "FAN_LOW":
                return new VentiladorBaixoCommand(casa.getVentilador());

            case "FAN_OFF":
                return new DesligarVentiladorCommand(casa.getVentilador());

            // TV
            case "TV_ON":
                return new LigarTVCommand(casa.getTv());

            case "TV_OFF":
                return new DesligarTVCommand(casa.getTv());

            case "TV_INPUT":
                return new DefinirEntradaTVCommand(
                        casa.getTv(), texto(partes));

            case "TV_VOLUME":
                return new DefinirVolumeTVCommand(
                        casa.getTv(), numero(partes));

            // SOM
            case "SOUND_ON":
                return new LigarSomCommand(casa.getSom());

            case "SOUND_OFF":
                return new DesligarSomCommand(casa.getSom());

            case "SOUND_CD":
                return new SelecionarCDCommand(casa.getSom());

            case "SOUND_DVD":
                return new SelecionarDVDCommand(casa.getSom());

            case "SOUND_RADIO":
                return new SelecionarRadioCommand(casa.getSom());

            case "SOUND_VOLUME":
                return new DefinirVolumeSomCommand(
                        casa.getSom(), numero(partes));

            // GARAGEM
            case "GARAGE_UP":
                return new SubirGaragemCommand(casa.getGaragem());

            case "GARAGE_DOWN":
                return new DescerGaragemCommand(casa.getGaragem());

            case "GARAGE_STOP":
                return new PararGaragemCommand(casa.getGaragem());

            // BANHEIRA
            case "HOTTUB_CIRCULATE":
                return new AtivarCirculacaoCommand(casa.getBanheira());

            case "HOTTUB_JETS_ON":
                return new LigarJatosCommand(casa.getBanheira());

            case "HOTTUB_JETS_OFF":
                return new DesligarJatosCommand(casa.getBanheira());

            case "HOTTUB_TEMP":
                return new DefinirTemperaturaCommand(
                        casa.getBanheira(), numero(partes));

            // SEGURANCA
            case "SECURITY_ARM":
                return new ArmarSegurancaCommand(casa.getSeguranca());

            case "SECURITY_DISARM":
                return new DesarmarSegurancaCommand(casa.getSeguranca());

            default:
                throw new IllegalArgumentException(
                        "Registro desconhecido: " + registro);
        }
    }

    private static String texto(String[] partes) {

        if (partes.length < 2 || partes[1].trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Registro sem parametro de texto");
        }

        return partes[1];
    }

    private static int numero(String[] partes) {

        String valor = texto(partes);

        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Numero invalido: " + valor, e);
        }
    }
}
