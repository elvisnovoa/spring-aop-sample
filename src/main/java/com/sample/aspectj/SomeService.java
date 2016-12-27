package com.sample.aspectj;

import org.springframework.stereotype.Service;

/**
 * Created by elvis on 12/27/16.
 */

@Service
public class SomeService {

    public void someMethod(String someString) {
        System.out.println("executing someMethod() with value " + someString);
    }
}
