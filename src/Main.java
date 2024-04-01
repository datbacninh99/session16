import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(1000);
        }

//        Arrays.sort(array);
//        long t1 =System.currentTimeMillis();
//        System.out.println(t1);
//
//        System.out.println(linearSearch(array,11111));
//        long t2 =System.currentTimeMillis();
//        System.out.println(t2);
//        System.out.println("Thoi gian tim kiem = "+(t2-t1));
//        System.out.println(linearSearch(array,12));

        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    // Tìm kiếm tuyến tính
    public static int linearSearch(int[] arr, int value) { // -> Generic
        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("Duyệt vòng lặp thứ %d , giá trị là %d \n", i, arr[i]);
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Tìm kiếm nhị phân
    public static int binarySearchNoRecursive(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            // Tìm kiếm giá trị
            int mid = start + (end - start) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                // Tìm ra vị trí
                return mid;
            }
        }
        return -1;
    }

    public static void bubbleSort(int[] arr) {
        boolean isNextPass = true;
        for (int i = 1; i < arr.length && isNextPass; i++) {  // i -> 1 đến length - 1
            for (int j = 0; j < arr.length - i; j++) { // i = 1 ; j -> 0 -> length - 2
                // Giả sử đã sắp xếp rồi
                isNextPass = false;
                if (arr[j] > arr[j + 1]) {
                    isNextPass = true;
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // Giả sử vị trí và gía trị nhỏ nhất
            int indexMin = i;
            int valueMin = arr[i];
            // Tìm giá trị nhỏ nhất
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < valueMin) {
                    indexMin = j;
                    valueMin = arr[j];
                }
            }

            // Đổi chỗ với giá trị đầu tiên
            arr[indexMin] = arr[i]; // Đổi vị trí index min trước
            arr[i] = valueMin;
        }
    }

    // Sắp xếp chèn
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];
            int j;
            for (j = i - 1; j >= 0 && currentValue <= arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentValue;
        }
    }
}