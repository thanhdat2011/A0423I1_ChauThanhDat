package _19_String_Regex.Exercise.Validate_ClassRoomName;

public class ClassRoomNameTest {
    private static ClassRoomName classRoomName;
    public static final String[] classRoomNames = new String[] { "C0318G", "A0423I", "A0423I_", "A042300I", "P0323A"};

    public static void main(String[] args) {
        classRoomName = new ClassRoomName();
        for (String classRoomName : classRoomNames) {
            boolean isvalid = ClassRoomNameTest.classRoomName.validate(classRoomName);
            System.out.println(classRoomName + " - " + isvalid);
        }
    }
}
