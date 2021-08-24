package annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationsExample {
    @Override
    @MethodInfo(author = "Krati", comments = "Main method", date = "Aug 24 2021", revision = 1)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "August 24 2021")
    public static void oldMethod() {
        System.out.println("Old method , don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationsExample.class.getMethods()) {
                // checks if methodInfo annotation present for method
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all annotations available in method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method " + method + " :" + anno);

                        }
                        MethodInfo methodAnno = method.getDeclaredAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);

                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e)
        {
            e.printStackTrace();
        }
    }
}

