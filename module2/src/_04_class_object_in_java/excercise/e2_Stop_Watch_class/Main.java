package _04_class_object_in_java.excercise.e2_Stop_Watch_class;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch.getStartTime());
        int[] arr;
        arr = new int[100000];
        for (int i=0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100000);
        }
        for (int i=0; i < arr.length; i++) {
            for (int j=1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = arr[j];
                }
            }
        }
        stopWatch.stop();
        System.out.println(stopWatch.getEndTime());
        System.out.println(stopWatch.getElapseTime());

    }
}
