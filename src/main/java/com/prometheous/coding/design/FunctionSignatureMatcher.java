package com.prometheous.coding.design;

import java.util.*;

public class FunctionSignatureMatcher {

    static Map<String, Class> primitiveClassMap;
    static Map<String, Class> objectMap;
    static {
        primitiveClassMap = new HashMap<>();
        primitiveClassMap.put("int", Integer.class);
        primitiveClassMap.put("double", Double.class);
        primitiveClassMap.put("float", Float.class);
        objectMap = new HashMap<>();
        objectMap.put("Integer", Integer.class);
        objectMap.put("Double", Double.class);
        objectMap.put("String", String.class);
        objectMap.put("Object", Object.class);
    }

    private static List<String> findMatch(List<String> signatures, List<Class> args) {

        List<String> res = new ArrayList<>();
        for(String method : signatures) {
            int start = method.indexOf("(");
            int end = method.indexOf(")");
            String[] methodArgs = method.substring(start + 1, end).split(",");
            if(methodArgs.length != args.size()) {
                continue;
            }
            boolean matched = true;
            for(int i = 0; i < methodArgs.length && matched; i++) {
                Class<?> matchedClass = null;
                String mArgs = methodArgs[i].trim();
                String[] types = mArgs.split(" ");
                String mArg = types[0].trim();
                if(mArg.contains("...")) {
                    mArg.replaceAll(".", "").trim();
                }
                if(primitiveClassMap.containsKey(mArg)) {
                    matchedClass = primitiveClassMap.get(mArg);
                } else if(objectMap.containsKey(mArg)) {
                    matchedClass = objectMap.get(mArg);
                } else {
                    try {
                        matchedClass = Class.forName("java.util." + mArg);
                    } catch (ClassNotFoundException e) {
                        try {
                            matchedClass = Class.forName("java.lang." + mArg);
                        } catch (ClassNotFoundException ex) {
                            matchedClass = null;
                        }
                    }
                }
                if(matchedClass == null || !matchedClass.equals(args.get(i))) {
                    matched = false;
                }
            }

            if(matched) {
                res.add(method);
            }
        }
        return res;
    }

    public static void main(String[] ars) {
        List<String> signatures = Arrays.asList(
                "myFunc(int, String)",
                "myFunc(Integer, String)",
                "myFunc(Integer, Object)",
                "myFunc(long, int)",
                "myFunc(double)",
                "myFunc(Object, Object)",
                "myFunc(String)",
                "myFunc(int... args)", // Variadic
                "myFunc(String... messages)", // Variadic
                "myFunc(int, String... names)", // Variadic with fixed params
                "myFunc(Object... items)", // Variadic with Object
                "myFunc(List)" // Testing common interface
        );

        List<Class> args = List.of(Integer.class, String.class);
        List<String> matched = findMatch(signatures, args);
        System.out.println(matched);
    }
}
