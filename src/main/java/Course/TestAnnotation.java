package Course;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Strings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface CustomAnnotation{
        String myAnnotation() default "annotation";
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        CustomAnnotation annotation = testClass.getClass().getAnnotation(CustomAnnotation.class);
        System.out.println(annotation.myAnnotation());
    }

}

