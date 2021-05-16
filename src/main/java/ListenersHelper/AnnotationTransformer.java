package ListenersHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import Utility.DataProviderUtility;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setDataProvider("getTestData");
		annotation.setDataProviderClass(DataProviderUtility.class);

	}

}
