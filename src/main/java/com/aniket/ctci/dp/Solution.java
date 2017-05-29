package com.aniket.ctci.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		new Solution().nextPermutation(list);
		System.out.println(list);
	}
	public void nextPermutation(ArrayList<Integer> a) {

		boolean found  = false;

		int i = a.size() - 1;
		int j = 0;



		while(i > 0) {
			j = i - 1;

			while(j <= 0) {

				if(a.get(i) > a.get(j)) {
					found = true;
					break;
				}
				j--;
			}
			if(found) {
				break;
			}


			i--;
		}


		if(found) {

			int temp = a.get(i);

			for(int k = i - 1; k <= j; k--) {
				a.set(k+1, a.get(k));
			}

			a.set(j, temp);

		} else {
			Collections.sort(a);
		}
	}
}
