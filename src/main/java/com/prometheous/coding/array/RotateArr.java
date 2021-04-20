package com.prometheous.coding.array;

public class RotateArr {

    public static void main(String[] args) {
//        int[] a = new int[] {1,2,3,4,5,6,7,8};
//        rotate(a, 5);
//        Arrays.asList(a).forEach(System.out::println);

        int[] a = new int[] {1,2,3,4,5,6,7};
        rotateByReversing(a, 3);
        for(int num : a) {
            System.out.print(num + " ");
        }
    }

    private static void rotate(int[] a, int k) {
        for(int i = 0; i < k; i++) {
            rotate(a);
        }
    }

    private static void rotate(int[] a) {
        int temp = a[a.length - 1];
        for(int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = temp;
    }

    public static void rotateByReversing(int[] a, int k) {
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - k - 1);
        reverse(a, 0, a.length - 1);
    }

    private static void reverse(int[] a, int start, int end) {
        int temp;
        while(start < end) {
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

}
