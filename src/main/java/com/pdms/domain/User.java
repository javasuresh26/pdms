/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.domain;

/**
 *
 * @author Suresh
 */
public class User {

    private static String currentUserName = "Admin1";

    public synchronized static String getCurrentUserName() {
        return currentUserName;
    }

    public synchronized static void setCurrentUserName(String currentUserName) {
        User.currentUserName = currentUserName;
    }

}
