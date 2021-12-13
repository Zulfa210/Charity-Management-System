package com.example.mycms;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class AddEventTest {

    @Test
    void onCreate() {


    }

    @Test
    void addEvent() {

    }

    @Test
    void checkEvent()
    {
        try{
            String EventName1= "Food Donation Drive";
            String EventDescription1="Donating food to 50+ families";
            String Date1 = "25/12/2020";
            String Time1=  "12:30";
            String Address1 = "Pune";

            String EventName2= "";
            String EventDescription2="";
            String Date2 = "";
            String Time2=  "";
            String Address2 = "";

            String EventName3= "Food Donation Drive";
            String EventDescription3="Donating food to 50+ families";
            String Date3 = "25/12";
            String Time3 =  "12:30";
            String Address3 = "Pune";

            AddEvent obj = new AddEvent();

            boolean x = obj.checkEvent(EventName1, EventDescription1, Date1, Time1, Address1);
            boolean y = obj.checkEvent(EventName2, EventDescription2, Date2, Time2, Address2);
            boolean z = obj.checkEvent(EventName3, EventDescription3, Date3, Time3, Address3);

            assertEquals(true, x);
            assertEquals(false, y);
            assertEquals(false, z);


        }
        catch (Exception e)
        {
        }
    }
}