package com.cybertek.tests.day15_properties_driverUtil_testbase;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.testng.annotations.Test;

public class SystemPropertiesTest {

    @Test
    public void readingSystemProperties() {
        // os.name = Mac OS X
        System.out.println(System.getProperty("os.name"));
        System.out.println("User name = " + System.getProperty("user.name"));
        //                   most useful one
        System.out.println("User directory: " + System.getProperty("user.dir"));

        System.out.println("Pom.xml path: " + System.getProperty("user.dir") + "/pom.xml");
        System.out.println("java version: " + System.getProperty("java.version"));

    }


}
