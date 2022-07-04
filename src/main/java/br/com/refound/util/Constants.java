package br.com.refound.util;

public class Constants {

    public static final int ID_USER_POS_INI = 0;
    public static final int ID_USER_POS_FIN = 10;
    public static final int NAME_POS_INI = 10;
    public static final int NAME_POS_FIN = 55;
    public static final int ID_ORDER_POS_INI = 55;
    public static final int ID_ORDER_POS_FIN = 65;
    public static final int ID_PRODUCT_POS_INI = 65;
    public static final int ID_PRODUCT_POS_FIN = 75;
    public static final int VALUE_POS_INI = 75;
    public static final int VALUE_POS_FIN = 87;
    public static final int DATE_YEAR_POS_INI = 87;
    public static final int DATE_YEAR_POS_FIN = 91;
    public static final int DATE_MONTH_POS_INI = 91;
    public static final int DATE_MONTH_POS_FIN = 93;
    public static final int DATE_DAY_POS_INI = 93;
    public static final int DATE_DAY_POS_FIN = 95;

    public static final String LINE_CONVERTER_EXCEPTION_MSG = "Erro de conversão na linha: {0}";
    public static final String FILE_SAVE_EXCEPTION_MSG = "Erro ao salvar o arquivo";
    public static final String FILE_PATH_EXCEPTION_MSG = "Arquivo não informado";

    public static final String CONVERT_STRING_EXCEPTION_MSG = "Valor não informado";

    public static String getPathFileSave(){
        return System.getProperty("user.home")
                .concat(System.getProperty("file.separator"))
                .concat("estorno.txt");
    }

}
