package co.edu.uniandes.umbrella.entidades;

public enum FormaComparticionEnum {
	VISTA_PREVIA_SIN_DESCARGA(1), VISTA_PREVIA_CON_DESCARGA(2), COMPARTIR_DOCUMENTO_MISMO_OP(3), 
	LINK(4), LINK_CON_CLAVE(5), DE_PUBLICA(6), DE_PRIVADA(7);

    private int value;

    FormaComparticionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
