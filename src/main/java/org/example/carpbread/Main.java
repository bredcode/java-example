package org.example.carpbread;

public class Main {
    public static void main(String[] args) {
        CarpBread mintCarpBread = null;
        CarpBread orangeCarpBread = null;
        if (CarpBread.validateColor("mint")) {
            mintCarpBread = new CarpBread(1, "mint", "민트 붕어빵");
        }
        if (CarpBread.validateColor("orange")) {
            orangeCarpBread = new CarpBread(5, "orange", "오랜지 붕어빵");
        }

        mintCarpBread.cook();
        orangeCarpBread.cook();
    }
}

