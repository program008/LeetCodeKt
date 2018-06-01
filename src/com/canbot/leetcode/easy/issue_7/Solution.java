package com.canbot.leetcode.easy.issue_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: tao.liu
 * @version: v1.0
 * @package: com.canbot.leetcode.easy.issue_7
 * @fileName: Solution
 * @description: 7. 反转整数
 * @date: 2018/6/1
 * @email: tao.liu@uurobot.cn
 */
public class Solution {
	//假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
	// 根据这个假设，如果反转后的整数溢出，则返回 0。

	/**
	 * 最差的算法
	 * @param x
	 * @return
	 */
	private int reverse(int x) {
		String a = x + "";
		List<String> bList = new ArrayList<>();
		for (int i = 0; i < a.length(); i++) {
			char b = a.charAt(i);
			bList.add(b + "");
		}

		Collections.reverse(bList);
		StringBuffer c = new StringBuffer();
		for (int i = 0; i < bList.size(); i++) {
			String s = bList.get(i);
			c.append(s);
		}
		String reverse1 = c.toString();
		if (reverse1.contains("-")) {
			String reverse2 = reverse1.replace("-", "");
			return Integer.parseInt(reverse2);
		}

		return Integer.parseInt(reverse1);
	}

	public int reverse2(int x) {
		long res = 0;
		for (; x != 0; x /= 10){
			res = res * 10 + x % 10;
			System.out.println(x + ", " + res);
		}
		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse2(-123));
	}
}
