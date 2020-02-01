package com.test;

import javax.smartcardio.CardTerminal;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        ClassLoader classLoader = CardTerminal.class.getClassLoader();
        System.out.println(classLoader);
        ParentClassLoader parentClassLoader = new ParentClassLoader("/Users/serenityma/IdeaProjects/GGSDDU/study_netty/target/classes/");
        ChildClassLoader childClassLoader = new ChildClassLoader("/Users/serenityma/IdeaProjects/GGSDDU/study_netty/target/classes/", parentClassLoader);
        Class<?> child1 = childClassLoader.loadClass("Child");
        Class<?> parent1 = parentClassLoader.loadClass("Parent");
        child1.newInstance();
        parent1.newInstance();
        Class<?> child = Class.forName("Child", true, childClassLoader);
        Class<?> parent = Class.forName("Parent", true, parentClassLoader);
//        child.newInstance();

//        ClassLoader classLoader1 = child.getClassLoader();
        ClassLoader classLoader2 = parent.getClassLoader();

//        System.out.println(classLoader1);
        System.out.println(classLoader2);
    }
}
