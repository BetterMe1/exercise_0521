package exercise.exercise_0521;

public class Test {
    public static void main(String[] args) {
        Finder finder = new Finder();
        int[] a = {1,3,5,2,2};
        int n = 5; int K = 3;
        System.out.println(finder.findKth(a,n,K));
    }
}
