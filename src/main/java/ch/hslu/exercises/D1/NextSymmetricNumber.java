package ch.hslu.exercises.D1;

public class NextSymmetricNumber {

    public static boolean isSymmetric(int number) {
        String numStr = String.valueOf(number);
        int i = 0, j = numStr.length() - 1;
        while (i < j) {
            if (numStr.charAt(i) != numStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int findNextSymmetricNumber(int number) {
        int nextNumber = number + 1;
        while (!isSymmetric(nextNumber)) {
            nextNumber++;
        }
        return nextNumber;
    }
}