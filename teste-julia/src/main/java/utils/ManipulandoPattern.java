package utils;

import utils.chain.ChainPatternTipoDois;
import utils.chain.ChainPatternTipoDefault;
import utils.chain.ChainPatternTipoUm;
import utils.chain.ChainPatternsStrings;

public class ManipulandoPattern {

    public String getValuePattern(String text){

        ChainPatternsStrings ch2 = new ChainPatternTipoDois(null,text);
        ChainPatternsStrings ch1 = new ChainPatternTipoUm(ch2,text);
        ChainPatternsStrings ch3 = new ChainPatternTipoDefault(ch1,text);
        return ch3.getValuePattern();
    }

}
