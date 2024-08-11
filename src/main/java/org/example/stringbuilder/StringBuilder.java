package org.example.stringbuilder;

public class StringBuilder {
    public static void main(String[] args) {
        final int STRING_SIZE = 500000;
        // String 성능 측정
        long startTime = System.currentTimeMillis();
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        String result = "";
        for (int i = 0; i < STRING_SIZE; i++) {
            result += "Hello ";
        }

        long endTime = System.currentTimeMillis();
        long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("String Length: " + result.length());
        System.out.println("String Time: " + (endTime - startTime) + " ms");
        System.out.println("String Memory: " + (endMemory - startMemory) / 1024 + " KB");

        // StringBuilder 성능 측정
        startTime = System.currentTimeMillis();
        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < STRING_SIZE; i++) {
            sb.append("Hello ");
        }

        endTime = System.currentTimeMillis();
        endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("StringBuilder Length: " + sb.length());
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ms");
        System.out.println("StringBuilder Memory: " + (endMemory - startMemory) / 1024 + " KB");
    }
}
