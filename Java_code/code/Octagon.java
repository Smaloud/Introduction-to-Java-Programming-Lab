package JavaClass.Class8;

public class Octagon {
    private void getOctagon(int index){
        int[][] map = new int[index][index];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                map[i][j] = 0;
            }
        }
        int cnt1 = (index+2)/3-1;
        for (int i = 0; i < (index+2)/3; i++) {
            map[i][cnt1] =1;
            cnt1--;
            }
        for (int i = 0; i < (index-4)/3; i++) {
            map[0][(index+2)/3+i] = 1;
        }
        for (int i = 0; i < (index+2)/3; i++) {
            map[i][(index+2)/3+(index-4)/3+i] = 1;
        }
        for (int i = 0; i < (index-4)/3; i++) {
            map[(index+2)/3+i][0] = 1;
            map[(index+2)/3+i][index-1] = 1;
        }
        for (int i = 0; i < (index+2)/3; i++) {
            map[(index+2)/3+(index-4)/3+i][i] = 1;
        }
        for (int i = 0; i < (index-4)/3; i++) {
            map[index-1][(index+2)/3+i] = 1;
        }
        for (int i = 0; i < (index+2)/3; i++) {
            map[(index+2)/3+(index-4)/3+i][index-i-1] = 1;
        }
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; j++) {
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
        }

    public static void main(String[] args) {
        Octagon o = new Octagon();
        o.getOctagon(13);
    }
    }
