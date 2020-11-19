package com.xlxl.karate;

import com.intuit.karate.junit5.Karate;

class RunKatateTest {

    @Karate.Test
    Karate testUsers() {
        return Karate.run("users").relativeTo(getClass());
    }

}
