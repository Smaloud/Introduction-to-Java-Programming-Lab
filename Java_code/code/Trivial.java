package Assignments.A3;

import java.util.Arrays;
import java.util.Scanner;
public class Trivial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[][] map = new int[n + 3][m];
        int cnt = 1;
        int cnt2 = 2;
        int cnt3 = 3;
        int[] a = new int[m];
        Arrays.fill(a, 1);
        for (int i = 0; i < n + 3; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 0;
            }
        }
        int tetNum = in.nextInt();
       loop: for (int i = 0; i < tetNum; i++) {
            String type = in.next();
            int x = in.nextInt();
            if (type.equals("I")) {
                for (int j = 0; j < 4; j++) {
                    map[0][j + x] = 1;
                }
                while (cnt < n + 3 && map[cnt][x] != 1 && map[cnt][x + 1] != 1 && map[cnt][x + 2] != 1 && map[cnt][x + 3] != 1) {
                    for (int j = 0; j < 4; j++) {
                        map[cnt][x + j] = 1;
                    }
                    for (int j = 0; j < 4; j++) {
                        map[cnt - 1][x + j] = 0;
                    }
                    cnt++;
                }
                cnt = 1;
            }
            if (type.equals("O")) {
                for (int j = 0; j < 2; j++) {
                    map[0][x + j] = 1;
                    map[0][x + j] = 1;
                }
                while (cnt2 < n + 3 && map[cnt2][x] != 1 && map[cnt2][x + 1] != 1) {
                    for (int j = 0; j < 2; j++) {
                        map[cnt2][j + x] = 1;
                        map[cnt2 - 1][j + x] = 1;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 2][j + x] = 0;
                    }
                    cnt2++;
                }
                cnt2 = 2;
            }
            if (type.equals("L")) {
                for (int j = 0; j < 3; j++) {
                    map[j][x] = 1;
                }
                map[2][x + 1] = 1;
                while (cnt3 < n + 3 && map[cnt3][x] != 1 && map[cnt3][x + 1] != 1) {
                    for (int j = 0; j < 3; j++) {
                        map[cnt3 + j - 3][x] = 0;
                    }
                    map[cnt3 - 1][x + 1] = 0;
                    for (int j = 0; j < 3; j++) {
                        map[cnt3 + j - 2][x] = 1;
                    }
                    map[cnt3][x + 1] = 1;
                    cnt3++;
                }
                cnt3 = 3;
            }
            if (type.equals("J")) {
                for (int j = 0; j < 3; j++) {
                    map[j][x + 1] = 1;
                }
                map[2][x] = 1;
                while (cnt3 < n + 3 && map[cnt3][x] != 1 && map[cnt3][x + 1] != 1) {
                    for (int j = 0; j < 3; j++) {
                        map[cnt3 + j - 3][x + 1] = 0;
                    }
                    map[cnt3 - 1][x] = 0;
                    for (int j = 0; j < 3; j++) {
                        map[cnt3 + j - 2][x + 1] = 1;
                    }
                    map[cnt3][x] = 1;
                    cnt3++;
                }
                cnt3 = 3;
            }
            if (type.equals("T")) {
                for (int j = 0; j < 3; j++) {
                    map[0][x + j] = 1;
                }
                map[1][x + 1] = 1;
                while (cnt2 < n + 3 && map[cnt2 - 1][x] != 1 && map[cnt2][x + 1] != 1 && map[cnt2 - 1][x + 2] != 1) {
                    for (int j = 0; j < 3; j++) {
                        map[cnt2 - 2][x + j] = 0;
                    }
                    map[cnt2 - 1][x + 1] = 0;
                    for (int j = 0; j < 3; j++) {
                        map[cnt2 - 1][x + j] = 1;
                    }
                    map[cnt2][x + 1] = 1;
                    cnt2++;
                }
                cnt2 = 2;
            }
            if (type.equals("S")) {
                for (int j = 0; j < 2; j++) {
                    map[0][j + x+1] = 1;
                }
                for (int j = 0; j < 2; j++) {
                    map[1][j+x] = 1;
                }
                while (cnt2 < n + 3 && map[cnt2 - 1][x + 2] != 1 && map[cnt2][x] != 1 && map[cnt2][x + 1] != 1) {
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 2][x + 1 + j] = 0;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 1][x + j] = 0;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 1][x + j + 1] = 1;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2][j + x] = 1;
                    }
                    cnt2++;
                }
                cnt2 = 2;
            }
            if (type.equals("Z")) {
                for (int j = 0; j < 2; j++) {
                    map[0][j + x] = 1;
                }
                for (int j = 0; j < 2; j++) {
                    map[1][j + 1 + x] = 1;
                }
                while (cnt2 < n + 3 && map[cnt2 - 1][x] != 1 && map[cnt2][x + 1] != 1 && map[cnt2][x + 2] != 1) {
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 2][j + x] = 0;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 1][j + 1 + x] = 0;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2 - 1][j + x] = 1;
                    }
                    for (int j = 0; j < 2; j++) {
                        map[cnt2][j + 1 + x] = 1;
                    }
                    cnt2++;
                }
                cnt2 = 2;
            }
            int p = 0;
            for (int w = 0; w <n+3; w++) {
                for (int[] e : map) {
                    if (Arrays.equals(e, a)) {
                            for (int j = 0; j < m; j++) {
                                map[p][j] = 0;
                            }
                            for (int j = p; j >= 1; j--) {
                                System.arraycopy(map[j - 1], 0, map[j], 0, m);
                            }
                            for (int j = 0; j < m; j++) {
                                int checkx = n+2;
                                while (checkx<=1){
                                    map[checkx][j] = map[checkx-1][j];
                                    checkx--;
                                }
                            }
                        }
                    p++;
                    }
                p = 0;
            }

            for (int j = 0; j < m; j++) {
                if (map[0][j] == 1 || map[1][j] == 1) break loop;
            }
        }
        for (int e = 3; e < n + 3; e++) {
            for (int r = 0; r < m; r++) {
                System.out.print(map[e][r]);
            }
            System.out.println();
        }
    }
}
