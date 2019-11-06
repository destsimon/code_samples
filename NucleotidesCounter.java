//Problem
//
//     A string is simply an ordered collection of symbols selected from some alphabet and formed into a word;
//     the length of a string is the number of symbols that it contains.
//
//     An example of a length 21 DNA string (whose alphabet contains the symbols 'A', 'C', 'G', and 'T')
//     is "ATGCTTCAGAAAGGTCTTACG."
//
//     Given: A DNA string s
//     of length at most 1000 nt.
//
//     Return: Four integers (separated by spaces) counting the respective number of times that the symbols
//     'A', 'C', 'G', and 'T' occur in s
//
//     Sample Dataset
//
//     AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC
//     Sample Output
//
//     20 12 17 21
//

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;

public class NucleotidesCounter {
    private final static char A = 'A';
    private final static char C = 'C';
    private final static char G = 'G';
    private final static char T = 'T';

    private final static char[] SYMBOLS = {A, C, G, T};
    private final static IntPredicate IS_VALID_NUCLEOTIDE = i -> i == A || i == C || i == G || i == T;

    private NucleotidesCounter() {
    }

    public static Map<Integer, Integer> countNucleotides(String dnaString) {
        if(dnaString == null) {
            throw new NullPointerException("dnaString can not be null");
        }

        Map<Integer, Integer> counter = new HashMap<>(SYMBOLS.length);
        for (char s : SYMBOLS) {
            counter.put((int) s, 0);
        }

        dnaString.chars()
                .filter(IS_VALID_NUCLEOTIDE)
                .forEach(c -> counter.put(c, counter.get(c) + 1));
        return counter;
    }

    public static void main(String[] args) {
        String dnaString = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        Map<Integer, Integer> counts = countNucleotides(dnaString);
        for (char s : SYMBOLS) {
            System.out.print(String.format("%s ", counts.get((int)s)));
        }
        assert(counts.get(A) == 20);
        assert(counts.get(C) == 12);
        assert(counts.get(G) == 17);
        assert(counts.get(T) == 21);

        dnaString = "";
        counts = countNucleotides(dnaString);
        for (char s : SYMBOLS) {
            assert(counts.get(s) == 0);
        }

        dnaString = "BBB";
        counts = countNucleotides(dnaString);
        for (char s : SYMBOLS) {
            assert(counts.get(s) == 0);
        }

    }

}
