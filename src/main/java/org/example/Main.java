package org.example;

public class Main {
    public static void main(String[] args) {
        CarpBread mintCarpBread = new CarpBread(1, "mint", "민트 붕어빵");
        CarpBread burntCarpBread = new CarpBread(2, "brown", "탄 붕어빵");
        CarpBread redBeanCarpBread = new CarpBread(3, "yellow", "팥 붕어빵");
        CarpBread creamCarpBread1 = new CarpBread(4, "gray", "크림 붕어빵");
        CarpBread creamCarpBread2 = new CarpBread(5, "gray", "크림 붕어빵");

        mintCarpBread.cook();
        burntCarpBread.cook();
        redBeanCarpBread.cook();
        creamCarpBread1.cook();
        creamCarpBread2.cook();
    }
}

