package co.edu.uniandes.umbrella.entidades;

public enum ListaValoresEnum {
	//public static final int IDLISTA_TIPODOCUMENTO = 1;
		//public static final int IDLISTA_TIPOCARPETA = 2;
		//public static final int IDLISTA_PERMISOSDOCUMENTO = 3;
		//public static final int IDLISTA_PERMISOSCARPETA = 4;
		//public static final int IDLISTA_TIPOPQR = 5;
		//public static final int IDLISTA_TIPOTRAMITE = 6;
	
	IDLISTA_TIPODOCUMENTO(1), IDLISTA_TIPOCARPETA(2), IDLISTA_PERMISOSDOCUMENTO(3), 
	IDLISTA_PERMISOSCARPETA(4), IDLISTA_TIPOPQR(5), IDLISTA_TIPOTRAMITE(6),IDLISTA_TIPOIDENTIFICACION(7);

    private int value;

    ListaValoresEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
