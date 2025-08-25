package Assignments.A3;
import java.util.Scanner;

public class Miku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char cnt =' ';
        char[][] map = new char[200][200];
        StringBuilder string = new StringBuilder();
        String input = in.next();
        int sum ;
        boolean check = true;
        for (int i = 0; i < input.length(); i++) {
            char test = input.charAt(i);
            if (!Character.isDigit(test)){
                cnt = test;
            }
            if (Character.isDigit(test) ) {
                String str = String.valueOf(test);
                int intc = Integer.parseInt(str);
                sum = intc;
                if (i+1<=input.length()-1&&Character.isDigit(input.charAt(i + 1))) {
                    intc = intc * 10;
                    String str2 = String.valueOf(input.charAt(i + 1));
                    int intc2 = Integer.parseInt(str2);
                    sum = intc + intc2;
                    if (i+2>input.length()-1||!Character.isDigit(input.charAt(i + 2))) {
                        i+=1;
                        check = false;
                    }
                    if (i+2<=input.length()-1&&Character.isDigit(input.charAt(i + 2))&&check) {
                        intc = intc * 10;
                        intc2 = intc2 * 10;
                        String str3 = String.valueOf(input.charAt(i + 2));
                        int intc3 = Integer.parseInt(str3);
                        sum = intc + intc2 + intc3;
                    }
                }
                for (int j = 0; j < sum; j++) {
                    string.append(cnt);
                }
                check = true;
            }
        }
        boolean[][] fill = new boolean[200][200];
        for (int i = 0; i <200; i++) {
            for (int j = 0; j <200; j++) {
                fill[i][j] = false;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                fill[i][j] = true;
            }
        }
        int locx = n, locy = 0, loca = 0, dir = 0;
        int[] dirx = {0, -1, 0, 1}, diry = {1, 0, -1, 0};
        while (loca < n * m) {
            locx += dirx[dir];
            locy += diry[dir];
            map[locx][locy] = string.charAt(loca);
            fill[locx][locy] = false;
            loca++;
            if (!fill[locx + dirx[dir]][locy + diry[dir]]) dir = (dir + 1) % 4;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.printf("%s", map[i][j]);
            }
            System.out.println();
        }
    }
}



