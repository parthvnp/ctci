package org.parthvnp.Array;

import java.util.Arrays;

public class ArrayProduct {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = prefixProduct(nums);
        int[] suffixProd = suffixProduct(nums);
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = prefixProd[i] * suffixProd[i];
        }
        return result;
    }

    public int[] productExceptSelfDoublePass(int[] nums){
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i-1];
        }
        int suffixProd = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] = result[i] * suffixProd;
            suffixProd *= nums[i];
        }

        return result;
    }

    private int[] prefixProduct(int[] nums){
       int[] products = new int[nums.length];
       products[0] = 1;
       for(int i = 1; i < nums.length; i++){
           products[i] = products[i-1] * nums[i - 1];
       }
       return products;
    }

    private int[] suffixProduct(int[] nums){
        int[] products = new int[nums.length];
        products[nums.length-1] = 1;
        for(int i = nums.length - 2; i >= 0; i--){
           products[i] = products[i+1] * nums[i+1];
        }
        return products;
    }

    public static void main(String[] args) {
        var arrayProduct = new ArrayProduct();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(arrayProduct.prefixProduct(nums)));
        System.out.println(Arrays.toString(arrayProduct.suffixProduct(nums)));
        System.out.println(Arrays.toString(arrayProduct.productExceptSelf(nums)));
        System.out.println(Arrays.toString(arrayProduct.productExceptSelfDoublePass(nums)));
    }
}
