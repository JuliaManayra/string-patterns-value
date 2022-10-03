import utils.ManipulandoPattern;

public class Main {


    public static void main(String[] args){

        ManipulandoPattern pattern = new ManipulandoPattern();

        System.out.println("entrada: (abc){3} ->  SAIDA:  "+ pattern.getValuePattern("(abc){3}"));
        System.out.println("entrada: (aaa){4} ->  SAIDA:  "+ pattern.getValuePattern("(aaa){4}"));
        System.out.println("entrada: b(a){4} ->  SAIDA:  "+ pattern.getValuePattern("b(a){4}"));
        System.out.println("entrada: b(a){4}juli(o){4} ->  SAIDA:  "+ pattern.getValuePattern("b(a){4}juli(o){4}"));
        System.out.println("entrada: b(o){4}juli(a){4}test(e){2} ->  SAIDA:  "+ pattern.getValuePattern("b(o){4}juli(a){4}test(e){2}"));
        System.out.println("entrada: b(o){10}juli(a){2}test(e){2} ->  SAIDA:  "+ pattern.getValuePattern("b(o){10}juli(a){2}test(e){2}"));
        System.out.println("entrada: j(u){2}li(a){2}man(a){2}(y){2}r(a){3} ->  SAIDA:  "+ pattern.getValuePattern("j(u){2}li(a){2}man(a){2}(y){2}r(a){3}"));
        System.out.println("entrada: a(bo){2}ra ->  SAIDA:  "+ pattern.getValuePattern("a(bo){2}ra"));
        System.out.println("entrada: a(bo(ki){2}){2}ra ->  SAIDA:  "+ pattern.getValuePattern("a(bo(ki){2}){2}ra"));
        System.out.println("entrada: b(a){4} ->  SAIDA:  "+ pattern.getValuePattern("b(a){4}"));
        System.out.println("entrada: b(o){10}juli(a){2}test(e){2} ->  SAIDA:  "+ pattern.getValuePattern("b(o){10}juli(a){2}test(e){2}"));
        System.out.println("entrada: julia ->  SAIDA:  "+ pattern.getValuePattern("julia"));
    }
}
