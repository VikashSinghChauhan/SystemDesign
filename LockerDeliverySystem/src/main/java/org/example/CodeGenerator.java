package org.example;

import java.util.UUID;

public class CodeGenerator {
    public static String generate(){
        return UUID.randomUUID().toString().substring(0,8);
    }
}
