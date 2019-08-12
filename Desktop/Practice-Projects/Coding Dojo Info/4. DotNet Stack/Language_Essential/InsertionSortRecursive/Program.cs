using System;

namespace InsertionSortRecursive
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            int[] result = InsertionSort(new int[]{5,3,4,1,2});
            for(int i = 0; i < result.Length; i++){
                System.Console.WriteLine(result[i]);
            }            
        }
        public static int[] InsertionSort(int[] arr, int start = 1, int end = 1){            
            if(start == arr.Length){
                return arr;
            }

            if(start == 0){
                start = end += 1;
                return InsertionSort(arr, start, start);
            }

            if(arr[start-1] > arr[start]){
                int temp = arr[start-1];
                arr[start-1] = arr[start];
                arr[start] = temp;
            }
            
            return InsertionSort(arr, start -= 1, end);
        }
    }

    
}
