package org.service;
public class CurrentUser_Id {
    private static int user_Id;
    public static int getUser_Id() {
        return user_Id;
    }

    public static void setUser_Id(int user_Id) {
        CurrentUser_Id.user_Id = user_Id;
    }
}
