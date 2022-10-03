package utils.chain;

import enums.EnumTipoPattern;
import utils.ManipulandoStringTipo2;
import utils.Util;

public class ChainPatternTipoDois extends ChainPatternsStrings{
   private final Util util=new Util();
    private final String text;
    private final int index;
   private final ManipulandoStringTipo2 tipo = new ManipulandoStringTipo2();
   public ChainPatternTipoDois(ChainPatternsStrings next, String text){
       super(next);
       this.text = text;
       this.index=0;

   }

    @Override
    public String getValuePattern() {
        if(hasNext()==true){
            return getNext().getValuePattern();
        }
        if(util.getMatcher(text, EnumTipoPattern.TIPO_DOIS.getPattern())){
            return tipo.getSubStringAddPattern(text,index);
        }
        return "";
    }
}
