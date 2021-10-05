package ru.nsu.medvedev.v;

import java.io.*;
import java.util.ArrayList;


public class ZFunc {
    public static ArrayList<Integer> search(Reader file, char[] needle) throws IOException {
        ArrayList<Integer> res = new ArrayList<>();
        int needle_len = needle.length;
        int buf_len = needle_len * 12;
        char[] buff = new char[buf_len];
        int size = buf_len + needle_len + 1;
        char[] text = new char[size];
        int step = 0;
        System.arraycopy(needle, 0, text, 0, needle_len);
        text[needle_len] = '$';
        int pos = 0;
        if (file.read(buff) != -1) {
            while (true) {
                System.arraycopy(buff,0,text,needle_len+1,buf_len);
                int[] Zres = Zarr(text);
                for(int i = needle_len + 1; i < size; i++){
                    if(Zres[i] == needle_len){
                        pos = i - needle_len - 1;
                        res.add(step * buf_len + pos);
                    }
                }
                if(file.read(buff) == -1){
                    break;
                } else {
                    int shift = pos +2 * needle_len;
                    System.arraycopy(text, shift, text, needle_len +1, size - shift);
                    step++;
                }
            }
        }
        file.close();
        return res;
    }

    private static int[] Zarr(char[] str) {
        int[] z = new int[str.length];
        int l = 0;
        int r = 0;
        for (int i = 1; i < str.length; i++) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < str.length && str[z[i]] == str[i + z[i]])
                z[i]++;
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
