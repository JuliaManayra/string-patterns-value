package utils;



import java.util.HashMap;
import java.util.Map;

public class ManipulandoStringTipo1 {


    private final Util util = new Util();

  public String getValueOfPattern(String text,String result, int index){
      text = text.trim();
      if( index <text.length()){
          var c = util.getCaracerByIndex(text,index);
           StringBuilder stringBuilder = new StringBuilder();
          if(util.getMatcher(String.valueOf(c), "[a-zA-Z]")){
              stringBuilder.append(result);
              stringBuilder.append(c);
              return getValueOfPattern(text,stringBuilder.toString(),index+1);
          }else if(util.getMattcherSimbol(String.valueOf(c),"(")){
              HashMap<String, Integer>  hashMap = getPatternWithConcat(text,index);
              for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                  String key = entry.getKey();
                  Integer value = entry.getValue();
                  stringBuilder.append(result);
                  stringBuilder.append(key);
                  return  getValueOfPattern(text,stringBuilder.toString(),value+1);
              }
          }
      }
      return result;
  }


    private HashMap<String, Integer> getPatternWithConcat(String text,int index){
        HashMap<String, Integer> result = new HashMap<>();
        if(index < text.length()){
            var hashMap = new HashMap<String, Integer> ();
            hashMap =getSubStringWithPatternStartAndEnd(text,index,"(");
            for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                result.put(util.getPattern(key,"",0), value+1);
                return result;
            }
        }else {
            result.put("",index);
            return result;
        }
        return result;
    }


    private  HashMap<String,Integer> getSubStringWithPatternStartAndEnd(String text, Integer index, String startPattern){
        var result= new HashMap<String, Integer> ();

        while ( index<text.length()) {
            var c = util.getCaracerByIndex(text,index);
            if(util.getMattcherSimbol(String.valueOf(c), startPattern)){
              String patternAdd =  getStringByIndexInitAndEnd(text,index,"}");
              result.put(patternAdd,index+patternAdd.length()-2);
              return result;
            }
            index++;
        }
        result.put("",index);
        return result;
    }


    private String getStringByIndexInitAndEnd(String text,int index,String patternEnd){
      boolean valid=true;
     StringBuilder stringBuilder=new StringBuilder();
      while(valid==true && index<text.length()){
          var c=util.getCaracerByIndex(text,index);
          if(util.getMattcherSimbol(String.valueOf(c), patternEnd)){
              valid=false;
              stringBuilder.append(c);
          }else {
              stringBuilder.append(c);
          }
          index++;
      }
      return stringBuilder.toString();

    }

}
