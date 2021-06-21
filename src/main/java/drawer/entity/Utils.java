package drawer.entity;

public class Utils {

    public static boolean allPositive(int... numbers) throws IllegalArgumentException {
        for (int num : numbers) {
            if (num < 0) {
                throw new IllegalArgumentException("Parameters should be positive integers");
            }
        }
        return true;
    }

    public static  double calculateDistanceBetweenPoints(
            int x1,
            int y1,
            int x2,
            int y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public static int indexOfSmallest(double[] array){

        // add this
        if (array.length == 0)
            return -1;

        int index = 0;
        double min = array[index];

        for (int i = 1; i < array.length; i++){
            if (array[i] <= min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
