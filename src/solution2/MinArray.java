package solution2;

public class MinArray {

    public static int minArray(int[] numbers) {
        int i = 1;
        while (i < numbers.length) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
            i++;
        }
        return numbers[0];
    }
}
