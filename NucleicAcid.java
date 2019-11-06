//Problem
//
//        An RNA string is a string formed from the alphabet containing 'A', 'C', 'G', and 'U'.
//
//        Given a DNA string t
//        corresponding to a coding strand, its transcribed RNA string u
//        is formed by replacing all occurrences of 'T' in t with 'U' in u
//
//        Given: A DNA string t
//        having length at most 1000 nt.
//
//        Return: The transcribed RNA string of t
//
//        Sample Dataset
//
//        GATGGAACTTGACTACGTAAATT
//        Sample Output
//
//        GAUGGAACUUGACUACGUAAAUU

public class NucleicAcid {
    private final static char T = 'T';
    private final static char U = 'U';

    private NucleicAcid() {
    }

    public static String transcribe(String dnaString) {
        if(dnaString == null) {
            throw new NullPointerException("dnaString can not be null");
        }
        char[] dnaStringArray = dnaString.toCharArray();
        for (int i = 0; i<dnaStringArray.length; i++) {
            if (dnaStringArray[i] == T) {
                dnaStringArray[i] = U;
            }
        }
        return new String(dnaStringArray);
    }

    public static void main(String[] args) {
        String dnaString = "GATGGAACTTGACTACGTAAATT";
        String transcribedDNAString = transcribe(dnaString);

        System.out.println(transcribedDNAString);
        assert(transcribedDNAString.equals("GAUGGAACUUGACUACGUAAAUU"));
    }

}
