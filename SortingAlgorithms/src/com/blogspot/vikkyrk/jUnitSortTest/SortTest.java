package com.blogspot.vikkyrk.jUnitSortTest;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.blogspot.vikkyrk.sort.*;

@RunWith(Parameterized.class)
public class SortTest {

	private Sort sort;

	public SortTest(Sort sort) {
		this.sort = sort;
	}
	
	@Parameters
	public static Collection<Object[]> testAllSort() {
		Object[][] ob = new Object[][] {{new InsertionSort()},
										{new BubbleSort()}, 
										{new SelectionSort()},
										{new MergeSort()}, 
										{new QuickSort()},
										{new CountingSort()}};
		
		return Arrays.asList(ob);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullArray() {
		sort.sort(null);
	}

	@Test
	public void testEmptyArray() {
		int[] arr = new int[0];
		sort.sort(arr);
		Assert.assertArrayEquals(new int[0], arr);
	}

	@Test
	public void testOneElementArray() {
		int[] arr = {5};
		int[] test = {5};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testTwoElementSortedArray() {
		int[] arr = {3, 9};
		int[] test = {3, 9};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testTwoElementUnSortedArray() {
		int[] arr = {8, 4};
		int[] test = {4, 8};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testOddNumberOfElementsArray() {
		int[] arr = {94, 14, 33, 1, 76, 23, 88};
		int[] test = {1, 14, 23, 33, 76, 88, 94};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testEvenNumberOfElementsArray() {
		int[] arr = {42, 68, 9, 7, 100, 36, 27, 99};
		int[] test = {7, 9, 27, 36, 42, 68, 99, 100};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testDuplicateArray() {
		int[] arr = {4,4,4,4,4};
		int[] test = {4,4,4,4,4};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}
	
	@Test
	public void testSortedArray() {
		int[] arr = {7, 9, 27, 36, 42, 68, 99, 100};
		int[] test = {7, 9, 27, 36, 42, 68, 99, 100};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}
	
	@Test
	public void testReverseSortedArray() {
		int[] arr = {100, 99, 68, 42, 36, 27, 9, 7};
		int[] test = {7, 9, 27, 36, 42, 68, 99, 100};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}

	@Test
	public void testLongArray() {
		int[] arr = {13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10};
		int[] test = {10, 13, 14, 23, 25, 25, 27, 33, 39, 45, 59, 65, 73, 82, 94, 94};
		sort.sort(arr);
		Assert.assertArrayEquals(test, arr);
	}
}
