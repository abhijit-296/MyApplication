package com.example.mylibrary;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DemoClassTest {

//    public static final int test_value = 5;
    public static final String test_name = "My Library";

    @Mock
    Context ctx;

    @Test
    public void testMethod()
    {
//        when(ctx.getResources().getInteger(R.integer.app_value)).thenReturn(test_value);
//        when(ctx.getResources().getInteger(R.integer.app_value)).thenReturn(test_value);
        when(ctx.getString(R.string.app_name)).thenReturn(test_name);

        DemoClassToBeTested dd = new DemoClassToBeTested();
//        int ee = dd.addTwoValues(ctx);
        String ee = dd.addTwoValues(ctx);
//        assertThat(ee,is(test_value));
        assertThat(ee,is(test_name));
    }
    //when(ctx.getResources(R.integer.text_hello_word)).thenReturn(TEST_STRING);

}
