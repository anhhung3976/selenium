package day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 7, 7, 8, 9, 9, 9, 10 };
		int[] my_array1 = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };
		String[] my_array2 = { "Java", "Python", "PHP", "C#", "C Programming", "C++" };

//		removeDuplicatesSet(arr);
		int[] newArr = removeDuplicates(arr);
//		System.out.println(Arrays.toString((newArr)));

		String[] sortArr = sortArray(my_array2);
//		System.out.println(Arrays.toString((sortArr)));

		int[] arrSum = { 1, 2, 4, 5, 10, 88, 10 };
		int total = sum(arrSum);
//		System.out.println(total);

		int[] numbers = new int[] { 20, 30, 25, 35, -16, 60, -100 };
		// calculate sum of all array elements
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}

//		double average = sum / numbers.length;
//		System.out.println(average);

//		int[] arrContains = new int[] { 20, 30, 25, 30, -16, 60, -100 };
//		contains(arrContains, 30);

		int[] arrRemove = { 1, 2, 3, 4, 5 };
		int index = 3;
		arrRemove = remove(arrRemove, index);
//		System.out.println(Arrays.toString((arrRemove)));

		int[] arrInsert = { 1, 2, 3, 4, 5 };
		int indexInsert = 1;
		int valueInsert = 9;
		arrInsert = insert(arrInsert, indexInsert, valueInsert);
		System.out.println(Arrays.toString((arrInsert)));

	
	}

	private static void removeDuplicatesSet(int[] arr) {
		int end = arr.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < end; i++) {
			set.add(arr[i]);
		}
		System.out.println(set);
	}

	private static int[] removeDuplicates(int[] arr) {
		int end = arr.length;
		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = arr[end - 1];
					end--;
					j--;
				}
			}
		}
		int[] whitelist = new int[end];
		System.arraycopy(arr, 0, whitelist, 0, end);
		Arrays.sort(whitelist);
		return whitelist;
	}

	private static int[] sortArray(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}

	private static String[] sortArray(String[] arr) {
		Arrays.sort(arr);
		return arr;
	}

	private static int sum(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}

	private static void contains(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				System.out.println(i);
			}
		}
	}

	private static int[] remove(int[] arr, int index) {
		if (arr == null || index > arr.length || index < 0) {
			System.out.println("lỗi");
			return arr;
		}

		int[] anotherArr = new int[arr.length - 1];
		try {
			for (int i = 0, k = 0; i < arr.length; i++) {
				if (arr[i] == index) {
					continue;
				}
				anotherArr[k++] = arr[i];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Something went wrong.");
		}
		return anotherArr;
	}

	private static int[] insert(int[] arr, int index, int value) {
		int[] result = new int[arr.length];
		System.arraycopy(arr, 0, result, 0, index);
		// bat dau copy từ vị trí index tới index+1v
		System.arraycopy(arr, index, result, index + 1, arr.length - index - 1);
		result[index] = value;
		return result;
	}
}
