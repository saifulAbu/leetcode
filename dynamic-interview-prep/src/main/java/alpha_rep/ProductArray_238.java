package alpha_rep;

// noted
public class ProductArray_238 {
  public int[] productExceptSelf_sub_optimal(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];

    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    int[] suffix = new int[n];
    suffix[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * nums[i + 1];
    }

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = prefix[i] * suffix[i];
    }

    return result;
  }

  public int[] productExceptSelf_drona(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    // prefix products
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }

    // suffix products (accumulated on the fly)
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] *= suffix;
      suffix *= nums[i];
    }

    return result;
  }

  public int[] productExceptSelf_0(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = 1;
    for (int i = 1; i < n; i++) {
      ans[i] = ans[i - 1] * nums[i - 1];
    }

    int R = 1;
    for (int i = n - 1; i >= 0; i++) {
      ans[i] = ans[i] * R;
      R = R * nums[i];
    }

    return ans;
  }

  public int[] productExceptSelf_0524(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    prefix[0] = 1;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    int suffix = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      prefix[i] = prefix[i] * suffix;
      suffix *= nums[i];
    }

    return prefix;
  }

  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    // Forward pass: calculate the prefix products
    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    // Backward pass: calculate the suffix products on the fly and multiply
    int backProd = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] = res[i] * backProd;
      backProd *= nums[i];
    }

    return res;
  }

}
