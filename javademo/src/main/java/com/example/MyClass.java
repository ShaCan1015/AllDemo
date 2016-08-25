package com.example;

public class MyClass {
    public static String str = "abcd";
    public static void main(String[] args)
    {
        show(0, new String());
    }
    public static void show(int current_recur, String temp)
    {
        if(current_recur < str.length())
        {
            for(int i = 0; i < str.length(); i++)
            {
                if( ! ( temp.contains(str.substring(i, i + 1)) ) )
                {
                    System.out.println(temp + str.substring(i, i + 1));
                    show(current_recur + 1, new String(temp + str.substring(i, i + 1)));
                }
            }
        }
    }
}
