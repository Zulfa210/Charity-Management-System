package com.example.mycms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NgoRegisterTest {




    @Test
    void testRegisterNgo() {
    }

    @Test
    void checkNgoR()
    {

        try {
            String name1 = "Zakaat Foundation";
            String person1 = "Akshay Tike";
            String phone1 = "0789654231";
            String reg1 = "1983626278";
            String address1 = "Pune";
            String email1 = "akshay@gmail.com";
            String upi1 = "akshay@obank.com";
            String password1 = "123456";

            NgoRegister obj = new NgoRegister();

            String name2 = "";
            String person2 = "";
            String phone2 = "";
            String reg2 = "";
            String address2 = "";
            String email2 = "";
            String upi2 = "";
            String password2 = "";

            String name3 = "Zakaat Foundation";
            String person3 = "Akshay Tike";
            String phone3 = "0789654231";
            String reg3 = "";
            String address3 = "Pune";
            String email3 = "akshay@gmail.com";
            String upi3 = "akshay@obank.com";
            String password3 = "123456";

            boolean x = obj.checkNgoR(email1, person1, phone1, password1, name1, reg1, upi1, address1);
            boolean y = obj.checkNgoR(email2, person2, phone2, password2, name2, reg2, upi2, address2);
            boolean z = obj.checkNgoR(email3, person3, phone3, password3, name3, reg3, upi3, address3);

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