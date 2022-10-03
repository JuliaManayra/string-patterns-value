import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int nsize=101;

        int [] array= new int[nsize];
        int [] arrayInverso= new int[nsize];
        int [] arrayIntercaladoNormal= new int[nsize+nsize];
        int [] arrayParesEImpares = new int[nsize+nsize];

        criarListaComNElementos(array);
        //imprimeLista(" LISTA ORIGINAL ", array);
        criaListaComValoresInversosEmRelacaoAumaOutra(array, arrayInverso);
        //imprimeLista(" INVERSO ", arrayInverso);
        criaListaComValoresIntercaladosDeDuasListas(array, arrayInverso, arrayIntercaladoNormal);
        //imprimeLista(" INVERSO + ordenado ", arrayIntercaladoNormal);
        listaComInicioParEMetadeAteOFimImpar(arrayIntercaladoNormal, arrayParesEImpares);
       // imprimeLista("\nprimeiros pares e depois impares ", arrayParesEImpares);
        //int size = getSize(arrayIntercaladoNormal, arrayParesEImpares);
        //imprimeImpares(arrayParesEImpares, size);

       /* System.out.println("numeros primos ");
        for (int i = 0; i < array.length-1; i++) {
            if (isNumeroPrimo(array[i])){
                //System.out.println(array[i]);
            }
            if(somaDosAlgarismosEhPrimo(array[i])){
               // System.out.println("a soma dos algarismos e primo: "+ array[i]);
            }
        }*/
       // somaDosAlgarismosEhPrimo(333);

        getNumeroReverso(1000000333);

    }

    private static void criaListaComValoresIntercaladosDeDuasListas(int[] array, int[] arrayInverso, int[] arrayIntercaladoNormal) {
        for (int i = 0, j = 0; i <= array.length-1 ; i++,j+=2) {
            arrayIntercaladoNormal[j]= array[i];
            arrayIntercaladoNormal[j+1]= arrayInverso[i];
        }
    }

    private static void criaListaComValoresInversosEmRelacaoAumaOutra(int[] array, int[] arrayInverso) {
        for (int i = array.length-1, j = 0; i >= 0 ; i--,j++) {
            arrayInverso[j]= array[i];
        }
    }

    private static void criarListaComNElementos(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] =i;
        }
    }

    private static void imprimeLista(String x, int[] arrayParesEImpares) {
        System.out.println(x);

        Arrays.stream(arrayParesEImpares).forEach(a->System.out.println(a));
    }

    private static void listaComInicioParEMetadeAteOFimImpar(int[] arrayIntercaladoNormal, int[] arrayParesEImpares) {
        int indexPar=0;
        int indexImpar=(arrayIntercaladoNormal.length/2)+1;
        System.out.println("tamanho do array" + (arrayIntercaladoNormal.length));
        System.out.println("tamanho do array" + (arrayIntercaladoNormal.length/2));
        System.err.println("inicio index Impar -> " + indexImpar);
        System.err.println("index par -> " + indexPar);
        for (int i = 0; i <= arrayIntercaladoNormal.length-1 ; i++) {
            if(arrayIntercaladoNormal[i]%2==0){
                arrayParesEImpares[indexPar]= arrayIntercaladoNormal[i];
                indexPar++;
            }
            if(arrayIntercaladoNormal[i]%2 !=0 ){
              //  System.err.println("Imapares -> indice: "+ i+" valor: "+ arrayIntercaladoNormal[i] +" indiceiMPAR: "+ indexImpar);
                arrayParesEImpares[indexImpar]= arrayIntercaladoNormal[i];
                indexImpar++;
            }
        }

        System.err.println("fim index Impar -> " + indexImpar);
        System.err.println("fim index par -> " + indexPar);
    }

    private static int getSize(int[] arrayIntercaladoNormal, int[] arrayParesEImpares) {
        System.out.println("\n primeiros pares ");
        int size = (arrayIntercaladoNormal.length/2)+1;
        for (int i=0; i<size;i++) {
            System.out.println(arrayParesEImpares[i]);
        }
        return size;
    }

    private static void imprimeImpares(int[] arrayParesEImpares, int size) {
        System.out.println("\n impares ");
        for (int i = size; i < arrayParesEImpares.length-1; i++) {
            System.out.println(arrayParesEImpares[i]);
        }
    }

    private static void imprimePares(int[] arrayParesEImpares, int size) {
        System.out.println("\n pares ");
        for (int i = 0; i < size; i++) {
            System.out.println(arrayParesEImpares[i]);
        }
    }


    private static boolean isNumeroPrimo(int numero){
        return numero>0 && isDivisivelPor(numero,1) == true &&
                isDivisivelPor(numero,numero) == true &&
                isDivisivelPor(numero,2) == false &&
                isDivisivelPor(numero,3) == false &&
                isDivisivelPor(numero,5) == false;
    }

    private static boolean isDivisivelPor(int numero, int divisisao){
        return numero%divisisao==0;
    }

    private static boolean somaDosAlgarismosEhPrimo( int valor){
        int centena = getUnidadeNumerica(valor,100);
        int dezena = getUnidadeNumerica(valor,10);
        int valorUnitario = getValorUnitario(valor, (centena * 100) - (dezena * 10));

        System.out.println("valorRecebido: "+ valor +" centena: " + centena +" dezena: "+ dezena + " valorUnitario "+ valorUnitario);
        int soma = (centena+ dezena+valorUnitario);
        //System.out.println("soma "+  soma);
        return isNumeroPrimo(soma);
    }

    private static int getNumeroReverso(int valor){
        int bilhao =  getUnidadeNumerica(valor,1000000000);
        int centenaDeMilhao = getUnidadeNumerica(valor,100000000);
        int dezenaDeMilhao = getUnidadeNumerica(valor,10000000);
        int milhao = getUnidadeNumerica(valor,1000000);
        int centenasDeMilhar = getUnidadeNumerica(valor,100000);
        int DezenaDemilhar = getUnidadeNumerica(valor,10000);
        int unidadeDemilhar = getUnidadeNumerica(valor,1000);
        int centena = getUnidadeNumerica(valor,100);
        int dezena = getUnidadeNumerica(valor,10);
        int valoresNaoUnitarios =  (bilhao * 1000000000) - (centenaDeMilhao * 100000000) - (dezenaDeMilhao * 10000000) - (milhao * 1000000)  - (centenasDeMilhar * 100000)   - (DezenaDemilhar * 10000) - (unidadeDemilhar * 1000) - (centena * 100) - (dezena * 10);
        int unidade = getValorUnitario(valor, valoresNaoUnitarios);

        System.out.println("valorRecebido: "+ valor
                +"\n bilhao: "+ bilhao
                +"\n milhao: "+  milhao + " dezenaDeMilhao: "+  dezenaDeMilhao +      " centenaDeMilhao: "+  centenaDeMilhao
                +"\n unidadeDemilhar: "+  unidadeDemilhar + " DezenaDemilhar: "+  DezenaDemilhar +      " centenasDeMilhar: "+  centenasDeMilhar
                +"\n centena: " + centena +" dezena: "+ dezena + " unidade "+ unidade);

        return valor;
    }

    private static int getValorUnitario(int valor,int valoresNaoUnitarios) {
        return valor - valoresNaoUnitarios;
    }

    private static int getDezena(int valor) {
        if((valor / 10)> 10){
            return (valor / 10) / 10;
        }
        return (valor / 10);
    }
    private static int getUnidadeNumerica(int valor, int unidade) {
        if((valor / unidade) >= unidade){
            return getUnidadeNumerica(valor / unidade , unidade);
        }
        return (valor / unidade);
    }
}
