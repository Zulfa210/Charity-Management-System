package com.example.mycms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class DonorAppointmentTest {

    @Test
    void onCreate() {

    }

    @Test
    void addAppointment() {

    }

    @Test
    void checkAppointment()
    {

        try{
            String Name1 =  "Zulfa Attar";
            String PhoneNo1 = "1234567890";
            String Date1= "22/12/2021";
            String Time1= "10:30pm";

            String Name2 =  "";
            String PhoneNo2 = "";
            String Date2= "";
            String Time2= "";

            String Name3 =  "Zulfa Attar";
            String PhoneNo3 = "12345";
            String Date3= "22/12/2021";
            String Time3 = "10:30pm";



            DonorAppointment obj = new DonorAppointment();

            boolean x = obj.checkAppointment(Name1, PhoneNo1, Date1, Time1);
            boolean y = obj.checkAppointment(Name2, PhoneNo2, Date2, Time2);
            boolean z = obj.checkAppointment(Name3, PhoneNo3, Date3, Time3);

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