package utils.chain;

import enums.EnumTipoPattern;
import utils.Util;

public class ChainPatternTipoDefault extends ChainPatternsStrings{
   private final Util util=new Util();
    private final String text;
    private final int index;

   public ChainPatternTipoDefault(ChainPatternsStrings next, String text){
       super(next);
       this.text = text;
       this.index=0;

   }

    @Override
    public String getValuePattern() {
        if(hasNext()==true){
            return getNext().getValuePattern();
        }
        if(util.getMatcher(text, EnumTipoPattern.TIPO_DEFAULT.getPattern())){
            return text;
        }
        return "";
    }
}
