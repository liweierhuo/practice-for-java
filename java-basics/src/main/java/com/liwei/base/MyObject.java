package com.liwei.base;


import java.util.Random;

/**
 * @author liwei17788
 * @date 2019/4/1614:25
 */
public class MyObject {
	static String getA() {
		return "a";
	}
	public static void main(String[] args) {
		test6();
	}

	/**
	 * 牢记字符串的常量池概念，但是对于字符串变量要格外小心，区分清楚哪些是编译期间优化哪些是不能编译优化的
	 */
	public static void test3() {
		String a = "a";
		String b = a + "b";
		String c = "ab";
		String d = new String(b);
		println(b == c);
		println(c == d);
		println(c == d.intern());
		println(b.intern() == d.intern());
	}

	private static void println(boolean b) {
		System.out.println(b);
	}

	/**
	 * 如果大量的变量字符串拼装，尽可能的采用StringBuilder否则会出现大量的无用对象导致进行频繁GC
	 */
	public static void test4() {
		StringBuilder a = new StringBuilder();
		Random random = new Random();
		for (int i = 0 ;i < 100;i++) {
			a.append(String.valueOf(random.nextInt(100)));
		}
		System.out.println(a.toString());
	}

	/**
	 * 找到一组数据中的最大值和最小值，只需要遍历数组一次而不需要排序
	 */
	public static void searchMaxMin() {
		int[] array = {132,1324,11,41233,13,1,1134,134,134341,1334,55245};
		int max = array[0];
		int min = array[0];
		for (int i=0; i<array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("max:"+max+";min:"+min);

	}

	/**
	 * 交换两个数组可以采用叠加法，使用效率更高的”异或“运算
	 */
	public static void test5() {
		int a = 127;
		int b = 124;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = "+a+";b="+b);
	}

	public static void test6() {
		System.out.println(12341234&10);
	}
}
