package JavaClass.Class8;

public class Person {
    private int[][] directions = {{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};

    private int i;
    private int j;
    private int index;
    public  Person(int i,int j,int index){
        this.i = i;
        this.j = j;
        this.index = index;
    }
    public void setI(int i){
        this.i = i;
    }
    public int getI(){
        return i;
    }
    public void setJ(int j){
        this.j = j;
    }
    public int getJ(){
        return j;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
    public void changeDirection(){
        index = (index+1)%8;
    }
    public void walk(int step){
        for (int k = 0; k < step; k++) {
            i+=directions[index][0];
            j+=directions[index][1];
        }
    }
    public String toString(){
        return "("+i+","+j+")";
    }
}
