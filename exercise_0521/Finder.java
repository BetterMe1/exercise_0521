package exercise.exercise_0521;


/*
[编程题]寻找第K大
有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数。
测试样例：
[1,3,5,2,2],5,3
返回：2
 */
import java.util.*;

/*
这题应该是用快排的思想：例如找49个元素里面第24大的元素，那么按如下步骤：
1.进行一次快排（将大的元素放在前半段，小的元素放在后半段）,假设得到的中轴为p
2.判断 p - low + 1 == k ，如果成立，直接输出a[p]，（因为前半段有k - 1个大于a[p]的元素，故a[p]为第K大的元素）
3.如果 p - low + 1 > k，则第k大的元 素在前半段，此时更新high = p - 1，继续进行步骤1
4.如果p - low + 1 < k，则第k大的元素在后半段，此时更新low = p + 1, 且 k = k - (p - low + 1)，
继续步骤1. 由于常规快排要得到整体有序的数组，
而此方法每次可以去掉“一半”的元素，故实际的复杂度不是o(nlgn), 而是o(n).
 */
public class Finder {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a,0,n-1,K);
    }
    private int quickSort(int[] arr, int low, int high,int K){
        int p = partion(arr,low,high);
        if(K == p-low+1){
            return arr[p];
        }else if(p-low+1 > K){
            //递归左边
            return quickSort(arr,low,p-1,K);
        }else{
            //递归右边
            return quickSort(arr,p+1,high,K-(p-low+1));
        }
    }
    private int partion(int[] arr, int low, int high){
        int tmp = arr[low];
        while(low < high){
            while(low < high && arr[high] <= tmp){
                high--;
            }
            if(low == high){
                break;
            }else{
                arr[low] = arr[high];
            }
            while(low < high && arr[low] >= tmp){
                low++;
            }
            if(low == high){
                break;
            }else{
                arr[high] = arr[low];
            }
        }
        arr[low] = tmp;
        return low;
    }
}