package enums;

public enum EnumTipoPattern {

    TIPO_UM("\\([a-zA-z]*\\)\\{[0-9]*\\}"),
    TIPO_DOIS("\\([a-zA-z\\([a-zA-z]*]*\\)\\{[0-9]*\\}*\\)\\{[0-9]*\\}"),
    TIPO_DEFAULT("[a-zA-z]*");

    EnumTipoPattern(String pattern){
        this.pattern = pattern;
    }

    private String pattern;
    public String getPattern(){
        return pattern;
    }
}
