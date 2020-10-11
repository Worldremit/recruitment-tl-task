package com.worldremit.credit.validator;

import org.junit.jupiter.api.Test;

public class LuhnTest {
    @Test
    public void test() {
        String number = "401288888881881";
        int length = number.length();
        int sum = 0;
        for (int index = length - 1; index >= 0; index--) {
            int element = Character.digit(number.charAt(index), 10);
            System.out.println(element);

            if (index % 2 == 1) {
                element *= 2;
            }


            if (element > 9) {
                element -= 9;
            }



            sum += element;
        }
        System.out.println(sum);
    }
}
