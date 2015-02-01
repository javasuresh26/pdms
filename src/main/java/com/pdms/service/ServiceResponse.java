/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pdms.service;

import java.util.ArrayList;

/**
 *
 * @author Suresh
 */
public class ServiceResponse<T> {

    private T response;
    private ArrayList<Exception> errors = new ArrayList<>();

    public ServiceResponse() {
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ArrayList<Exception> getErrors() {
        return errors;
    }

    public void setErrors(Exception error) {
        //StackTraceElement[] elements = error.getStackTrace();
        errors.add(error);
    }

}
