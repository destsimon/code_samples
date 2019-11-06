//Problem
//
//        A permutation of length n
//        n
//        is an ordering of the positive integers {1,2,…,n}. For example, π=(5,3,2,1,4)
//        is a permutation of length 5
//
//        Given: A positive integer n≤7
//
//        Return: The total number of permutations of length n, followed by a list of all such permutations (in any order).
//
//        Sample Dataset
//
//        3
//        Sample Output
//
//        6
//        1 2 3
//        1 3 2
//        2 1 3
//        2 3 1
//        3 1 2
//        3 2 1


import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private Permutations() {
    }

    public static void permute(List<String> permutations, String prefix, String permString) {
        int length = permString.length();
        if (length == 0) {
            permutations.add(prefix.replace("", " ").trim());
            return;
        }
        for(int i=0; i<length; i++) {
            permute(permutations, prefix + permString.charAt(i),
                    permString.substring(0, i) + permString.substring(i+1, length));
        }
    }

    private static String getPermString(int perm) {
        StringBuilder permString = new StringBuilder();
        for (int i = 1; i <= perm; i++) {
            permString.append(i);
        }
        return permString.toString();
    }

    public static void main(String[] args) {
        int perm = 5;
        List<String> permutations = new ArrayList<>();
        permute(permutations, "", getPermString(perm));

        System.out.println(permutations.size());
        permutations.forEach(System.out::println);

        assert(permutations.size() == 6);
    }

}
