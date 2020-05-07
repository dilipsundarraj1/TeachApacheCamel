package com.learncamel.launcher;

import com.learncamel.route.CopyFilesRoute;
import org.apache.camel.main.Main;

/**
 * Created by Dilip on 1/9/18.
 */
public class AppLauncher {


    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.addRouteBuilder(new CopyFilesRoute());

        System.out.println("Starting fo routelder polling app");

        main.run();



    }
}
