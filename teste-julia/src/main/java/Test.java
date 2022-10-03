import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    //(abc){3}

    public String getPattern(String text, int index){
        StringBuilder builder = new StringBuilder();
        HashMap<String,Integer> hashMap = new HashMap<>();
        char c = text.charAt(index);

        if (getMattcherSimbol(String.valueOf(c),"(")) {
            hashMap  = getValueOfRepetition(text,index+1);
            for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                index = value+1;
                builder.append(key);
                c=text.charAt(index);
            }

        }
        if (getMattcherSimbol(String.valueOf(c),"{")){
            StringBuilder result = new StringBuilder();
            int repetition= getNumberOfRepetition(text,index);
            String value = builder.toString();
            while (repetition>0){
                result.append(value);
            }
            return result.toString();
        }
        return "";
    }


    private HashMap<String,Integer> getValueOfRepetition(String text, int index){
        HashMap<String,Integer> result= new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean valid = true;
        while (valid && index<text.length()){
            char c = text.charAt(index);
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
    private Integer getNumberOfRepetition(String text, int index){
        int value=0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean valid = true;
        while (valid && index<text.length()){
            char c = text.charAt(index);
            if(getMatcher(String.valueOf(c),"[0-9]")){
                stringBuilder.append(c);

            }
            if (getMattcherSimbol(String.valueOf(c),"}")){
                valid = false;
            }
            index++;
        }
        return  Integer.valueOf(stringBuilder.toString());
    }

    private boolean getMatcher(String a, String patternstr){
        Pattern pattern = Pattern.compile(patternstr);
        Matcher matcher = pattern.matcher(String.valueOf( a));
        return matcher.find();
    }

    private boolean getMattcherSimbol(String a, String pattern){
        return a.equals(pattern);
    }

}
