package Assignments.A3;

import java.util.Scanner;

public class Contributor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        int[] dirx={0,1,0,-1,-1,1,-1,1},diry={1,0,-1,0,-1,1,1,-1};
        char[][] map = new char[n+2][n+2];
        String[] map01 = new String[n];
        for (int i = 0; i < n; i++) {
            map01[i] = in.next();
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                map[i][j] = map01[i-1].charAt(j-1);
            }
        }
        int x = in.nextInt(),y = in.nextInt();
        if (map[x+1][y+1]=='x') {
            System.out.println("-1");
        }else {
            for (int i = 0; i < 8; i++) {
                int px = x+1+dirx[i];
                int py = y+1+diry[i];
                if (map[px][py]=='x') cnt++;
            }
            System.out.println(cnt);
        }
    }
}
