package com.bibliotheque;

import com.bibliotheque.services.Password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class PasswordTest {

    @Test
    void test() {
        Password p = new Password("123");
        p.firstHash();
        System.out.print(p.getHash());
        fail("Not yet implemented");

    }

}
