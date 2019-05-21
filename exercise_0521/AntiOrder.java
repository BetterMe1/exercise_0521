package exercise.exercise_0521;


/*
逆序对
 */
import java.util.Arrays;

public class AntiOrder {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,6,7,0};
        System.out.println(count(A,A.length));
    }
    public static int count(int[] A, int n) {
        int[] c = new int[1];
        c[0] = 0;
        if(A != null && n!=0){
            int[] tmpArr = new int[n];
            mergeSort(A,0,n-1,tmpArr,c);
        }
        return c[0];
    }
    private static void mergeSort(int [] A,int start,int end,int[] tmpArr,int[] c){
        if(start >= end){
            return;
        }
        int mid = (start+end)>>1;
        mergeSort(A,start,mid,tmpArr,c);
        mergeSort(A,mid+1,end,tmpArr,c);
        merge(A,start,mid,end,tmpArr,c);//合并
    }
    private static void merge(int [] A,int start,int mid,int end,int[] tmpArr,int[] c){
        int tmpIndex = start;//tmpArr的下标
        int start2 = mid+1;//第二个归并段
        int i = start;
        while(start<=mid && start2<=end){
            if(A[start] > A[start2]){
                tmpArr[tmpIndex++] = A[start++];
                c[0] += (end-start2+1);//逆序对
            }else{
                tmpArr[tmpIndex++] = A[start2++];
            }
        }
        if (start2 <= end) {
            System.arraycopy(A, start2, tmpArr, tmpIndex, end - start2 + 1);
        }
        if (start <= mid) {
            System.arraycopy(A, start, tmpArr, tmpIndex, mid - start + 1);
        }
        System.arraycopy(tmpArr, i, A, i, end - i + 1);
    }
}
