package com.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

public class RepetitionsJava {

    String compress(List<String> cs) {
        if (cs.isEmpty()) return "";
        else {
            String head = cs.get(0);
            int reps = 0;
            for (String s : cs) {
                if (s.equals(head)) reps++;
                else break;
            }
            return (reps == 1 ? "" : reps) + head
                    + compress(cs.subList(reps, cs.size()));
        }
    }

    private List<String> grouped(String s, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= s.length(); i += n) {
//            System.out.println(s.substring(i, Math.min(i + n, s.length()))) ;
            res.add(s.substring(i, Math.min(i + n, s.length())));
        }
        return res;
    }

    public String solve(String s) {
        IntStream.rangeClosed(1, Math.max(1, s.length() / 2)).boxed()
                .map(n ->
                        {
                            String result = compress(grouped(s, n));
//                            System.out.println(result);
//                            return compress(grouped(s, n));
                            return result;
                        }
                );


        return IntStream.rangeClosed(1, Math.max(1, s.length() / 2)).boxed()
                .map(n ->
                        {
                            return compress(grouped(s, n));
                        }
                )
                .min(
                        comparing(item ->
                                {
//                                    System.out.println(item);
                                    return item.length();
                                }
                        )
                )
                .orElse("");
    }

    public int solution(String s) {
        return solve(s).length();
    }

    private static void pcompress(String s) {
        String compressed = new RepetitionsJava().solve(s);
        System.out.println("compress(" + s + ") = " + compressed.length() + ", " + compressed);
    }

    public static void main(String[] args) {
        pcompress("aabb");
//        pcompress("aabbaccc");
//        pcompress("ababcdcdababcdcd");
//        pcompress("abcabcdede");
//        pcompress("abcabcabcabcdededededede");
//        pcompress("xababcdcdababcdcd");
    }

}
