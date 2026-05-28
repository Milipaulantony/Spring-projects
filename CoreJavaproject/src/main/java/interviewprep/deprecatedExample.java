package interviewprep;

public class deprecatedExample {

    @Deprecated
    public void oldMethod(){
        System.out.println("This is old one");
    }

    public void newMethod(){
        System.out.println("This is new one");
    }

    public static void main(String[] args) {
        deprecatedExample obj = new deprecatedExample();
            obj.oldMethod();
            obj.newMethod();

    }
}
