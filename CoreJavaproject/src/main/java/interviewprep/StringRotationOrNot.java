package interviewprep;

public class StringRotationOrNot {
    public static void main(String[] args) {
        String input_1 = "JavaJ2eeStrutsHibernate";
        String input_2 = "StrutsHibernateJavaJ2xx";
        String modifed_input_1 = input_1.concat(input_1);
        //alsoverify the length
        if(modifed_input_1.contains(input_2)) System.out.println("Itis rotated");

    }
}
