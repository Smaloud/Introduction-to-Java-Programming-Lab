package Assignments.A3;

import java.util.Scanner;

public class Safe_Areas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[][] map = new boolean[n+200][n+200];
        int Des = in.nextInt();
        int Can = in.nextInt();
        int[] desx ={1,0,-1,0,1,1,-1,-1},desy={0,1,0,-1,1,-1,1,-1};
        int[] canx ={-2,-2,-2,-2,-2,-1,-1,0,0,1,1,2,2,2,2,2};
        int[] cany ={-2,-1,0,1,2,-2,2,-2,2,-2,2,-2,-1,0,1,2};
        int cnt = 0;
        for (int i = 0; i < Des; i++) {
            int x = in.nextInt(),y = in.nextInt();
            map[x+50][y+50] = true;
            for (int j = 0; j < 8; j++) {
                int px = x+desx[j]+50,py = y+desy[j]+50;
                if (px>=50&&px<=n+49&&py>=50&&py<=n+49) map[px][py] = true;
            }
        }
        for (int i = 0; i < Can; i++) {
            int x = in.nextInt(),y = in.nextInt();
            map[x+50][y+50] = true;
            for (int j = 0; j < 16; j++) {
                int px = x+canx[j]+50,py = y+cany[j]+50;
                if (px>=50&&px<=n+49&&py>=50&&py<=n+49) map[px][py] = true;
            }
        }
        for (int i = 50; i < n+50; i++) {
            for (int j = 50; j < n+50; j++) {
                if (!map[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
