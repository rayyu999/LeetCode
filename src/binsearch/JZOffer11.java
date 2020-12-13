package binsearch;

public class JZOffer11 {

    public int minArray(int[] numbers) {
        if (numbers.length > 0) {
            int left = 0, right = numbers.length - 1;
            while(left < right) {
                int mid = (left + right) / 2;
                if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else if (numbers[mid] == numbers[right]) {
                    right--;
                } else {
                    right = mid;
                }
            }
            return numbers[left];
        }
        throw new IllegalArgumentException("No min array solution");
    }

}
