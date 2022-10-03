package utils.chain;

import enums.EnumTipoPattern;
import utils.ManipulandoStringTipo1;
import utils.Util;

public class ChainPatternTipoUm extends ChainPatternsStrings{
   private final Util util=new Util();
    private final String text;
    private final String result;
    private final int index;
   private final ManipulandoStringTipo1 tipo = new ManipulandoStringTipo1();
   public ChainPatternTipoUm(ChainPatternsStrings next,String text){
       super(next);
       this.text = text;
       this.index=0;
       this.result="";

   }

    @Override
    public String getValuePattern() {
        if(hasNext()==true){
            return getNext().getValuePattern();
        }
        if(util.getMatcher(text, EnumTipoPattern.TIPO_UM.getPattern())) {
            return tipo.getValueOfPattern(text, result, index);
        }
        return "";
    }
}
