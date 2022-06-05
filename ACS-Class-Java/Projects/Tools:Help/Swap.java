public class swap {
    public static void swap(int[] a1, int a2[]) {
        int[] arrhold = a1;
        a1 = a2;
        a2 = arrhold;
    }
    public static void main(String[] args) {
        int[] a = {356, 35, 564, 574, 23, 3};
        int[] b = {5, 46, 625, 7464526, 46, 564, 54, 994, 43, 467};
        System.out.println(a + "  " + b);
        swap(a, b);
        System.out.println(a + "  " + b);
    }
    
}