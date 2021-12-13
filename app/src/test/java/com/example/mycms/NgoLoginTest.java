package com.example.mycms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NgoLoginTest {

    @Test
    void loginNgo() {


    }

    @Test
    void checkNGO()
    {

            NgoLogin obj = new NgoLogin();

            String email1 = "tanyaraina@gmail.com";
            String pass1 = "123456";


            String email2 = "";
            String pass2= "";

            String email3 = "tanyaraina@";
            String pass3= "123456";

            boolean x = obj.checkNgo(email1, pass1);
            boolean y = obj.checkNgo(email2, pass2);
            boolean z = obj.checkNgo(email3, pass3);

            assertEquals(true, x);
            assertEquals(false, y);
            assertEquals(false, z);



    }
}