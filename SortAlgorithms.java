public class SortAlgorithms {
      public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    
    public static void merge(int arr[], int start, int mid, int end) {
        int tmp[] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
    
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
    
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
    
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
    
        for (i = start, k = 0; i <= end; i++, k++) {
            arr[i] = tmp[k];
        }
    }
    public static boolean BinarySearch(int arr[],int target){
        int left=0;
        int right=arr.length;
        int mid;
        while (right<=left) {
             mid =(right+left)/2;
             if(arr[mid]==target){
                return true;
             }
             else if (arr[mid]>target) {
                right=mid-1;
             }
             else if(arr[mid]<target){
                left =mid+1;
             }
        }
        return false;
    }
    public static int[] SelectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min_i=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min_i]>arr[j]){
                    min_i=j;
                }
            }
            if(min_i!=i){
                int tmp=arr[i];
                arr[i]=arr[min_i];
                arr[min_i]=tmp;
            }
        }
        return arr;
    }
    public static int[] BubbleSort(int arr[]){
        int x=1;
        while(x<=arr.length){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    int tmp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tmp;
                }
            }
            x++;
        }
        return arr;
    }
    public static void QuickSort(int array[],int start,int end){
        if(end <= start) return;
        int pivot =partition(array, start, end);
        QuickSort(array,start,pivot-1);
        QuickSort(array,pivot+1,end);
    }
    public static int partition(int array[],int start,int end){
        int i= start-1;
        int pivot =array[end];
        for(int j=start;j<=end-1;j++){
            if(array[j]<pivot){
                i++;
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        i++;
        int temp=array[i];
        array[i]=array[end];
        array[end]=temp;
        return i;
    }
}
