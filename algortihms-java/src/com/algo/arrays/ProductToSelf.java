package com.algo.arrays;

import java.util.Arrays;

public class ProductToSelf {
    static void main() {
        int[] arr = {1, 2, 4, 6};
        int[] result = productExceptSelf1(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
        System.out.println();
        result = productExceptSelf2(arr);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }

    //Using prefix and postfix array
    private static int[] productExceptSelf1(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < pre.length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        post[post.length - 1] = nums[nums.length - 1];
        for (int i = post.length - 2; i >= 0; --i) {
            post[i] = post[i + 1] * nums[i];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            int preProd = 1;
            if (i - 1 >= 0) {
                preProd = pre[i - 1];
            }
            int postProd = 1;
            if (i + 1 < post.length) {
                postProd = post[i + 1];
            }
            output[i] = postProd * preProd;
        }
        return output;
    }

    //Using one array, more memory efficient
    private static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        var pre = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre;
            pre *= nums[i];
        }
        var post = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            result[i] *= post;
            post *= nums[i];
        }
        return result;
    }
}
