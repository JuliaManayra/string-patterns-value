package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {



    public HashMap<String,Integer> putData(String simbolo, int index){
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put(simbolo,index);
        return hashMap;
    }

    public StringBuilder getSubstringByIndexBegginerAndLast(String text, int ultimoOpenParenteses, int primeroClosedChaves) {
        StringBuilder stringBuilder = new StringBuilder();
        int i= ultimoOpenParenteses,j= primeroClosedChaves;
        while (i<=j){
            var c = getCaracerByIndex(text,i);
            stringBuilder.append(c);
            i++;
        }
        return  stringBuilder;
    }





    public String getPattern(String text, String resultParcial, int index){
        if(index < text.length()){
            var c = getCaracerByIndex(text,index);
            if (getMattcherSimbol(String.valueOf(c),"(")) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                hashMap  = getValueOfRepetition(text,index+1);
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    return getPattern(text, key,value+1);
                }
            }else  if (getMattcherSimbol(String.valueOf(c),"{")) {
                StringBuilder result = new StringBuilder();
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap = getNumberOfRepetition(text, index);

                for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                    Integer key = entry.getKey();
                    Integer value = entry.getValue();
                    while (key > 0) {
                        result.append(resultParcial);
                        key--;
                    }
                    return getPattern(text, result.toString(), value + 1);
                }
            }
        } else if(index > text.length()){
            return resultParcial;
        }
        return "";
    }

    public   HashMap<Integer,Integer>  getNumberOfRepetition(String text, int index){
        HashMap<Integer,Integer> result= new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean valid = true;
        while (valid && index<text.length()){
            var c = getCaracerByIndex(text,index);
            if(getMatcher(String.valueOf(c),"[0-9]")){
                stringBuilder.append(c);
            }
            if (getMattcherSimbol(String.valueOf(c),"}")){
                valid = false;
            }
            index++;
        }
        result.put(Integer.valueOf(stringBuilder.toString()),index);
        return  result;
    }

    public HashMap<String,Integer> getValueOfRepetition(String text, int index){
        HashMap<String,Integer> result= new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean valid = true;
        while (valid && index<text.length()){
            var c = getCaracerByIndex(text,index);
            if(getMatcher(String.valueOf(c),"[a-zA-Z]")==true){
                stringBuilder.append(c);
                index++;
            }else if (getMattcherSimbol(String.valueOf(c),")")){
                valid = false;
            }
        }
        result.put(stringBuilder.toString(),index);
        return  result;
    }


    public boolean getMatcher(String a, String patternstr){
        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(String.valueOf(a));
        return matcher.find();
    }

    public boolean getMattcherSimbol(String a, String pattern){
        return a.equals(pattern);
    }

    public String getCaracerByIndex(String text, int index){
        if(!Optional.ofNullable(text).orElse("").isEmpty() && index<text.length() ){
            return String.valueOf(text.charAt(index));
        }
        return "";
    }
}
