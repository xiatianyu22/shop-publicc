package com.shop.online.order.service;

import org.junit.Assert;
import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Tested;


public class OrderServiceTest {
	
	@Tested
    private Sample sample;

    @Test
    public void testStaticGetPrivateOne() {
        new Expectations(sample) {
            {
                Deencapsulation.invoke(sample, "staticGetOne");
                result = 2;
            }
        };

        Assert.assertTrue(sample.staticGetPrivateOne() == 2);
    }

   

}
