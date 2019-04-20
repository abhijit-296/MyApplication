package com.example.mylibrary;

import android.content.Context;

public class DemoClassToBeTested {

//    public int addTwoValues(Context ctx)
   public String addTwoValues(Context ctx)
    {
      //  ctx.get
//        ctx.getString(R.integer.app_value)
//        return ctx.getString(R.integer.app_value)
//        return ctx.getResources().getInteger(R.integer.app_value);

        return ctx.getString(R.string.app_name);
    }
}
