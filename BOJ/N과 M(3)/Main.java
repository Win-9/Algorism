package com.backend.nutt.common;

import java.io.*;
import java.util.*;

public class ex {
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        int[] data = new int[N];

        for(int i = 0; i < N; i++) {
            data[i] = i + 1;
        }

        int[] arr = new int[M];
        trace(0, data, arr);
        bw.flush();

    }

    static void trace(int depth, int[] data, int[] arr) throws IOException {

        if (depth == M) {
            print(arr);
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = data[i];
            trace(depth + 1, data, arr);
        }
    }

    static void print(int[] arr) throws IOException {
        for(int i = 0; i < M; i++) {
            bw.write(arr[i] + " ");
        }
        bw.newLine();
    }
}
