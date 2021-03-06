/*
Thomas Ax Gulbrandsrød s344043
Margrethe Luth Røed s344101
Camilla Bjørklund Gjermundnes s344038
 */ 

package no.oslomet;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //Oppgave 1
    /**
     * Vaar big O analyse ga oss O(n).
     * Det blir flest ombyttninger naar tabellen er sortert synkende/DESC
     * Det blir faerrest ombyttningen naar tabellen er sortet stigende/ASC
     * Hvis n = 20 og vi kjoerer 10 000 ganger blir gjennomsnittlig ombyttninger 16.
     * De tidligere maks metodene er ca like store med Big O, men metodene vil gaa litt raskere.
     */
    public static int maks(int[] a) throws NoSuchElementException {
        if (a.length < 1) {
            throw new NoSuchElementException("A list of length 0 has no biggest number!");
        }

        for (int i=0;i<a.length-1;i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) throws NoSuchElementException {
        if (a.length < 1) {
            throw new NoSuchElementException("A list of length 0 has no biggest number!");
        }

        int byttinger = 0;

        for (int i=0;i<a.length-1;i++) {
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                byttinger++;
            }
        }
        return byttinger;
    }

    //Oppgave 2
    public static int antallUlikeSortert(int[] a){

        for(int i = 0; i < a.length-1; i++) {
            if (a[i] <= a[i + 1]) {
            }else{
                throw new IllegalStateException("Tabellen er ikke sortert stigende");
            }
        }

        int ant = 0;
        for(int i = 0; i < a.length; i++){
            int j;
            for(j = 0; j < i; j++){
                if(a[i] == a [j]) {
                    break;
                }
            }
            if( i == j) {
                ant++;
            }
        } return ant;
    }

    //Oppgave 3
    public static int antallUlikeUsortert(int[] a){
        int ant = 0;
        for(int i = 0; i < a.length; i++){
            int j;
            for(j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if( i == j) {
                ant++;
            }
        } return ant;
    }

    //Oppgave 4
    private static int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int j = (begin - 1);

        for (int i = begin; i < end; i++) {
            if (a[i] <= pivot) {
                j++;
                bytt(a, i, j);
            }
        }
        bytt(a, j + 1, end);
        return j + 1;
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int pivot_index = partition(a, left, right);
            quickSort(a, left, pivot_index - 1);
            quickSort(a, pivot_index + 1, right);
        }
    }
    public static void quicksort(int[] a) // sorterer hele tabellen
    {
        quickSort(a, 0, a.length - 1);
    }

    public static void delsortering (int [] a){

        int left = 0;
        int right = a.length-1;


        for(int i = 0; i < a.length; i++){


            while((a[left]%2==1 || a[left]%2==-1) && left < right){
                left++;
            }
            while(a[right]%2==0 && right >= 1){
                right--;
            }
            if(left < right){
                bytt(a,left, right);

            }
        }
        if(left == 0){
            quicksort(a);
        }else{
            quickSort(a,0,right);
            quickSort(a,right+1,a.length-1);
        }

    }

    //Oppgave 5
    public static void rotasjon(char[] a) {
        if(a.length == 0) {
            return;
        }
        char temp = a[a.length-1];

        for (int i=a.length-1;i>0;i--) {
            a[i] = a[i-1];
        }

        a[0] = temp;
    }

    //Oppgave 6
    public static void rotasjon(char[] a, int k) { //A B, 1 -> B A
        if(a.length == 0 || k == 0) {
            return;
        }

        int len = a.length;
        k = k%len;

        if (k<0){
            k = k*-1;
            k = len-k;
        }

        char[] front = Arrays.copyOfRange(a, 0, len-k);
        char[] rest = Arrays.copyOfRange(a, len-k, len);

        System.arraycopy(rest, 0, a, 0, rest.length);
        System.arraycopy(front, 0, a, 0 + k, front.length);
    }

    //Oppgave 7 a)

    public static String flett(String s,String t) {
        String out = "";
        int len;
        String big;

        if (s.length() < t.length()) {
            big = t;
            len = s.length();
        } else {
            big = s;
            len = t.length();
        }

        for (int i = 0; i < len; i++) {
            out += s.charAt(i);
            out += t.charAt(i);
        }

        out += big.substring(len);

        return out;
    }

    //Oppgave 7 b)
    public static String flett(String...s) {
        int len = s.length;
        String out = "";
        int lengstestreng = 0;

        for (int i = 0; i < len ; i++) {
            if(s[i].length() > lengstestreng){
                lengstestreng = s[i].length();
            }
        }
        for (int i = 0; i < lengstestreng; i++) {
            for (int j = 0; j < len ; j++) {
                if (i < s[j].length()){
                    out += s[j].charAt(i);
                }
            }
        }
        return out;
    }

    //Oppgave 8
    public static int[] indekssortering(int[] a){
        int[] indeks = new int[a.length];
        if(a.length == 0){
            return a;
        }
        for(int i = 0; i < a.length; i++){
            indeks[i] = i;
        }

        for(int i = a.length-1; i > 0; i --){

            for(int j = 0; j <i ;j++){
               if(a[indeks[j]]>a[indeks[i]]){
                   bytt(indeks,i,j);
               }
            }
        }
       return indeks;
    }
    

    //Oppgave 9
    public static int[] tredjeMin(int[] a){

        int n = a.length;

        if (n < 3)
        {
            throw new NoSuchElementException("Det må vaere mer enn 3 elementer i arrayet, du har "+n+" elementer!!" );
        }

        int[] initMinste = indekssortering(new int[]{a[0], a[1], a[2]});

        int minst = initMinste[0];
        int nm = initMinste[1];
        int nnm = initMinste[2];

        if (a[nm] < a[minst]) {
            minst = 1;
            nm = 0;
        }
        if(a[nnm] < a[nm]){
            nm = 2;
            nnm = 1;
        }
        if(a[nnm] < a[minst]) {
            minst = 2;
            nnm = 0;
        }
        int minverdi = a[minst];
        int nestminverdi = a[nm];
        int nestnestminverdi = a[nnm];

        for (int i = 3; i < n; i++)
        {
            if(a[i] < nestnestminverdi){
                if (a[i] < nestminverdi){
                    if (a[i] < minverdi){
                        nnm = nm;
                        nm = minst;
                        nestnestminverdi = nestminverdi;
                        nestminverdi = minverdi;

                        minst = i;
                        minverdi = a[i];
                    }else{
                        nnm = nm;
                        nestnestminverdi =nestminverdi;

                        nm = i;
                        nestminverdi = a[i];
                    }
                } else {
                    nnm = i;
                    nestnestminverdi = a[i];
                }
            }
        }
        return new int[] {minst,nm,nnm};
    }
    
    //Oppgave 10
    public static boolean inneholdt(String a, String b) {
        int[] aASCII = new int[256];
        int[] bASCII = new int[256];
        for (char chr: b.toCharArray()) {
            bASCII[(int) chr]++;
        }
        for (char chr: a.toCharArray()) {
            aASCII[(int) chr]++;
        }
        for (int i=0;i<aASCII.length;i++) {
            if(bASCII[i]<aASCII[i]){
                return false;
            }
        }
        return true;
    }
}
