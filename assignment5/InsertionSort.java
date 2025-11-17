public class InsertionSort {
    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public int sort() {
        int passes = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            arr[j + 1] = key; 
            passes++;
        }
        
        return passes;
    }

    public void display() {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int []arr = {5, 3, 1, 7, 9, 2};
        InsertionSort is = new InsertionSort(arr);
        int pass = is.sort();
        System.out.println("Number of passes for sorting: " + pass);
        is.display();
    }
}
