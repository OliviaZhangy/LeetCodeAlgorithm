package src.Olivia;

//NO 251
//iterator

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

public class Vector2D {
    private int[][] vector;
    private int listPointer;
    private int elementPointer;

    public Vector2D(int[][] v) {
        vector = v;
        listPointer = 0;
        elementPointer = 0;
    }

    public int next() {
        if(hasNext()){
            if(elementPointer<vector[listPointer].length){
                elementPointer++;
                return vector[listPointer][elementPointer-1];
            }
        }
        return -1;
    }

    public boolean hasNext() {
        int len = vector.length;
        while (listPointer<len){
            if(elementPointer<vector[listPointer].length){
                return true;
            }
            else{
                listPointer++;
                elementPointer = 0;
            }
        }
        return false;
    }
}
