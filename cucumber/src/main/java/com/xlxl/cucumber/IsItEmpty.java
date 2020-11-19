package com.xlxl.cucumber;

public class IsItEmpty {
    static String isItEmpty(Integer actualVal) {
        return actualVal == 0 ? "Yep" : "Nope";
    }
}
