package utils.chain;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

public abstract class ChainPatternsStrings {
    private ChainPatternsStrings next;

    public ChainPatternsStrings(ChainPatternsStrings next){
        this.next=next;
    }

    public abstract String getValuePattern();

    public ChainPatternsStrings getNext(){
        return next;
    }

    public boolean hasNext(){
        if(Optional.ofNullable(next).isPresent()){
            return !Optional.ofNullable(next.getValuePattern()).orElse("").isEmpty();
        }
        return false;
    }
}
