package utils;

public class ManipulandoStringTipo2 {
    private final Util util = new Util();

    public String getSubStringAddPattern(String text,int index)
    {
        int lastOpenParenthesys=0;
        int contOpenPa=0;
        int firstClosedKeys=0;
        int contClosedKeys=0;
        for (int i = index; i < text.length(); i++) {
            var c = util.getCaracerByIndex(text,i);
            if(util.getMattcherSimbol(c, "(")){
                lastOpenParenthesys=i;
                contOpenPa++;
            }
            if(util.getMattcherSimbol(c, "}")){
                contClosedKeys++;
                if(contClosedKeys==1){
                    firstClosedKeys=i;
                }
            }
        }

        String novoText = text;
        if(contOpenPa==0 && contClosedKeys==0){
            return novoText;
        }else{
            StringBuilder stringBuilder = util.getSubstringByIndexBegginerAndLast(text, lastOpenParenthesys, firstClosedKeys);
            var resultParcial = util.getPattern(stringBuilder.toString(),"",0);
            novoText = text.replace(stringBuilder.toString(),resultParcial);
            return getSubStringAddPattern(novoText,index);
        }

    }


}
