package ru.nsu.medvedev.v;

public class ZFunc {
    public static void search(String text, String needle) {
        String concat = needle + "#" + text;
        int l = concat.length();
        int Z[] = new int[l];
        Zarr(concat, Z);
        for (int i = 0; i < l; ++i) {
            if (Z[i] == needle.length()) {
                System.out.println(i - needle.length() - 1);
            }
        }
    }

    private static void Zarr(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0;
        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (Z[k] < R - i + 1){
                    Z[i] = Z[k];
                }
                else {
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "тачки диски рули";
        String needle = "ки";
        search(text, needle);
    }
}
