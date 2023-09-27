package util;


public class HelperUtil {
    //private final static Scanner sc = new Scanner(System.in);

    public static int choiceVehical() {
        System.out.print("""
                =========== Choose Vehical ===========
                1. Car
                2. Motor
                3. Truck
                ======================================
                """);
        return ValidationUtil.getChoice();
    }

    public static int choiceProduct() {
        System.out.print("""
                =========== Choose Product ===========
                1. Immigrate Product
                2. Ex Product
                ======================================
                """);
        return ValidationUtil.getChoice();
    }

    public static int choiceYesOrNo() {
        System.out.print("""
                =========================
                1. Yes
                2. No
                =========================
                """);
        return ValidationUtil.getChoice();
    }
}
