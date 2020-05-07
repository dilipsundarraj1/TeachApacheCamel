package com.learncamel.bean;


import com.learncamel.exception.ApplicationException;

import java.util.logging.Logger;

/**
 * Created by Dilip on 7/1/17.
 */
public class DataModifier {

    Logger log = Logger.getLogger(DataModifier.class.getName());

    public String map(String input) throws Exception {
        String newBody=null;
        try{
             newBody = input.replace(",", "*");
        }catch(RuntimeException e){
            log.severe("RuntimeException : " + e);
            //throw e;
        }
        catch(Exception e){
            log.severe("Exception : " + e);
            throw e;
        }
        return  newBody;

    }

    public String mapOnException(String input) throws Exception {

        String newBody=null;
        try{
            newBody = input.replace(",", "*");
        }catch(RuntimeException e){
            log.severe("RuntimeException : " + e);
            //throw e;
            throw new ApplicationException(e.getMessage());
        }
        catch(Exception e){
            log.severe("Exception : " + e);
            throw e;
        }
        return  newBody;
    }
}
