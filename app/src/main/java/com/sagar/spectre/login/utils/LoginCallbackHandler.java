package com.sagar.spectre.login.utils;

public interface LoginCallbackHandler {

    void onSaveUsername(int nextPage, String username);

    void onSaveGender(int nextPage, String gender);

    void onSaveAge(int nextPage, String age);

    void onPermission();
}
