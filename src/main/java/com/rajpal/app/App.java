package com.rajpal.app;

import java.util.Collection;
import java.util.Set;

import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootMethod;
import sootup.java.core.views.JavaView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void processClazz(JavaSootClass clazz){
        System.out.println("Processing "+clazz.getName());
        Set<JavaSootMethod> methods = clazz.getMethods();
        
        for(JavaSootMethod method:methods){
            processMethod(method);
        }
    }
    private static void processMethod(JavaSootMethod method) {
        System.out.println(method.getDeclaringClassType().getClassName()+":"+method.getName());
    }
    public static void main( String[] args )
    {
        String tcdir = "src/testcases";
        // AnalysisInputLocation inputLocation = new JavaSourcePathAnalysisInputLocation(tcdir);
        AnalysisInputLocation inputLocation = new JavaClassPathAnalysisInputLocation(tcdir);
        JavaView view = new JavaView(inputLocation);
         Collection<JavaSootClass> classes = view.getClasses();
         for(JavaSootClass clazz:classes){
            processClazz(clazz);
         }
    }
}
