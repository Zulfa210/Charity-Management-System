package com.example.mycms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DonorRegisterTest {

    @Test
    void registerDonor() {
    }
    @Test
    void checkDonorR()
    {
        try {
            String name1 = "Zulfa Attar";
            String email1 = "zulfa@gmail.com";
            String phone1 = "1234567890";
            String password1 = "123456";

            DonorRegister obj = new DonorRegister();

            String name2 = "";
            String phone2 = "";
            String email2 = "";
            String password2 = "";

            String name3 = "Zulfa Attar";
            String phone3 = "1234567890";
            String email3 = "";
            String password3 = "123456";

            String name4 = "Zulfa Attar";
            String email4 = "zulfa@gmail.com";
            String phone4 = "120";
            String password4 = "123456";

            String name5 = "Zulfa Attar";
            String email5 = "zulfa@gmail.com";
            String phone5 = "1234567890";
            String password5 = "123";


            boolean a = obj.checkDonorR(email1,name1,  phone1, password1 );
            boolean b = obj.checkDonorR(email2,name2,  phone2, password2 );
            boolean c = obj.checkDonorR(email3,name3,  phone3, password3 );
            boolean d = obj.checkDonorR(email4,name4,  phone4, password4 );
            boolean e = obj.checkDonorR(email4,name4,  phone4, password4 );

            assertEquals(true, a);
            assertEquals(false, b);
            assertEquals(false, c);
            assertEquals(false, d);
            assertEquals(false, e);
        }
        catch (Exception e)
        {

        }
    }
}