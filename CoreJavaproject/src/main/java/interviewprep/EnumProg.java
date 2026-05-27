package interviewprep;

public class EnumProg {
    public static void main(String[] args) {
        DayOfWeek today = DayOfWeek.TUESDAY;
        System.out.println(today);
        switch (today) {
            case MONDAY:
                System.out.println("Start of week");
                break;
            case TUESDAY:
                System.out.println("hectic day");
                break;
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Almost weekend!");
                break;
            default:
                System.out.println("Midweek day");
        }
    }
}
