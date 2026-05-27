package interviewprep;

public class TryWithResources {

    static class MyResource implements AutoCloseable {
        public MyResource() { System.out.println("Resource opened"); }

        public void use() { System.out.println("Using resource"); }

        @Override
        public void close() { System.out.println("Resource closed automatically"); }
    }

    public static void main(String[] args) {
        try (MyResource res = new MyResource()) {
            res.use();
        }
    }
}