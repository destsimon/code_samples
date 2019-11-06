//Problem
//
//        In DNA strings, symbols 'A' and 'T' are complements of each other, as are 'C' and 'G'.
//
//        The reverse complement of a DNA string s is the string sc
//
//        formed by reversing the symbols of s, then taking the complement of each symbol
//        (e.g., the reverse complement of "GTCA" is "TGAC").
//
//        Given: A DNA string s
//        of length at most 1000 bp.
//
//        Return: The reverse complement sc of s
//
//        Sample Dataset
//
//        AAAACCCGGT
//
//        Sample Output
//
//        ACCGGGTTTT


import java.util.HashMap;
import java.util.Map;

public class ReverseComplement {
    private final static char A = 'A';
    private final static char C = 'C';
    private final static char G = 'G';
    private final static char T = 'T';

    private final static char[] SYMBOLS = {A, C, G, T};
    private final static char[] COMPLEMENTS = {T, G, C, A};

    private final static Map<Character, Character> LOOKUP = new HashMap<>(SYMBOLS.length);
    static {
        for (int i = 0; i < SYMBOLS.length; i++) {
            LOOKUP.put(SYMBOLS[i], COMPLEMENTS[i]);
        }
    }

    private ReverseComplement() {
    }

    public static String reverseComplement(String dnaString) {
        if(dnaString == null) {
            throw new NullPointerException("dnaString can not be null");
        }
        char[] dnaStringArray = dnaString.toCharArray();

        int length = dnaString.length();
        for(int i = 0, j = length-1; i <= j; i++, j--) {
            swap_and_complement(dnaStringArray, i, j);
        }
        return new String(dnaStringArray);
    }

    private static void swap_and_complement(char[] arr, int i, int j) {
        char t = LOOKUP.get(arr[i]);
        arr[i] = LOOKUP.get(arr[j]);
        arr[j] = t;
    }

    public static void main(String[] args) {
        String dnaString = "AAAACCCGGT";
        String reverseComplementedDNAString = reverseComplement(dnaString);

        System.out.println(reverseComplementedDNAString);
        assert(reverseComplementedDNAString.equals("ACCGGGTTTT"));
    }

}
