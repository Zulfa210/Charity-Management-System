package com.example.mycms;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DonorLoginTest {

    @Test
    void onCreate() {
    }

    @Test
    void loginDonor() {

    }
    @Test
    void checkDonor()
    {
       try {
            DonorLogin obj = new DonorLogin();

            String email1 = "priyagopal@gmail.com";
            String pass1 = "123456";


            String email2 = "";
            String pass2= "";

            String email3 = "priyagopal@";
            String pass3= "123456";

            boolean x = obj.checkDonor(email1, pass1);
            boolean y = obj.checkDonor(email2, pass2);
            boolean z = obj.checkDonor(email3, pass3);


            assertEquals(true, x);
            assertEquals(false, y);
            assertEquals(false, z);

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}