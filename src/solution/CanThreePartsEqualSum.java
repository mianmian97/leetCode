package solution;

/**
 * @Author : zhangyi
 * @Date : 2020-03-11 18:49
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args) {

        System.out.println(canThreePartsEqualSum(new int[]{10, -10, 10, -10}));
    }

    public static boolean canThreePartsEqualSum(int[] A) {

        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) return false;

        int left = 0;
        int right = A.length - 1;

        int leftSum = A[left];
        int rightSum = A[right];

        while (left < right - 1 && (leftSum != sum / 3 || rightSum != sum / 3)) {

            if (leftSum != sum / 3) {
                left++;
                leftSum += A[left];
            }

            if (rightSum != sum / 3) {
                right--;
                rightSum += A[right];
            }
        }

        if (left < right - 1 && (leftSum == sum / 3 && rightSum == sum / 3)) return true;
        return false;
    }
}

