package com.rajpal.app;

import java.util.Collection;
import java.util.List;

import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.transform.BodyInterceptor;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaSootClass;
import sootup.java.core.views.JavaView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String tcdir = "src/testcases";
        // AnalysisInputLocation inputLocation = new JavaSourcePathAnalysisInputLocation(tcdir);
        AnalysisInputLocation inputLocation = new JavaClassPathAnalysisInputLocation(tcdir);
        JavaView view = new JavaView(inputLocation);
        List<BodyInterceptor> bodyInterceptors = inputLocation.getBodyInterceptors();
        for(BodyInterceptor bodyInterceptor:bodyInterceptors){
            System.out.println(bodyInterceptor.toString());
        }
        System.out.println("size of bil: "+bodyInterceptors.size());
         Collection<JavaSootClass> classes = view.getClasses();
         for(JavaSootClass clazz:classes){
            System.out.println(clazz.getName().toString());
         }
    }
}
