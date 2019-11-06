//Problem
//
//
//        Figure 2. The Hamming distance between these two strings is 7. Mismatched symbols are colored red.
//        Given two strings s and t of equal length, the Hamming distance between s and t, denoted dH(s,t), is
//        the number of corresponding symbols that differ in s and t.
//
//        Given: Two DNA strings s and t of equal length (not exceeding 1 kbp).
//
//        Return: The Hamming distance dH(s,t)
//
//        Sample Dataset
//
//        GAGCCTACTAACGGGAT
//        CATCGTAATGACGGCCT
//
//        Sample Output
//
//        7

public class HammingDistance {

    private HammingDistance() {
    }

    public static int calculateHammingDistance(String dnaString1, String dnaString2) {
        if(dnaString1 == null || dnaString2 == null) {
            throw new NullPointerException("dnaString can not be null");
        }
        if(dnaString1.length() != dnaString2.length()) {
            throw new IllegalArgumentException("dnaStrings must have equal length");
        }
        int hammingDistance = 0;

        for(int i = 0; i < dnaString1.length(); i++) {
            if(dnaString1.charAt(i) != dnaString2.charAt(i)) {
                hammingDistance += 1;
            }
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        String dnaString1 = "GAGCCTACTAACGGGAT";
        String dnaString2 = "CATCGTAATGACGGCCT";
        int hammingDistance = calculateHammingDistance(dnaString1, dnaString2);

        System.out.println(hammingDistance);
        assert(hammingDistance == 7);
    }

}
