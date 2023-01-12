import java.util.ArrayList;

public class MinHeap {

    private int []arr;
    private int size;
    private int capacity;

    public MinHeap(int c){
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    public int left(int i){return (2*i+1);}
    public int right(int i){return (2*i+2);}
    public int parent(int i){return ((i-1)/2);}
   
    public void printMinHeap(){
        for (int i=0;i<size;i++){
           System.out.print(arr[i] +"  ");;
       }
   } 
    public void minHipify(int i){
        int LT = left(i);
        int RT = right(i);
        int min = i;
        if(LT < size && arr[min] > arr[LT]){
            min = LT;
        }
        if(RT < size && arr[min] > arr[RT]){
            min = RT;
        }
        if(arr[min] != arr[i]){
            swap(i, min);
            minHipify(min);
        }
    }
    public int minExtract(){
        int RN = arr[0];
        arr[0] = arr[size-1];
        size--;
        minHipify(0);
        
        
        return RN;//remember to modify this
    }
    
    public void instert(int x){

        if(size == capacity){
            return;
        }
        size++;

        arr[size-1] = x;

        for(int i = size-1; i != 0 && (arr[parent(i)] > arr[i]);){
            swap(parent(i),i);
            i = parent(i);
        }
    }

    public void swap(int i, int j){
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
    }
}
