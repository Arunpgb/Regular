package ListenersHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import HelperFunctions.ExcelUtils;
import ProjectConstants.ProjectConstants;

public class MethodInterceptor implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<Map<String, String>> excelcases = ExcelUtils.getTestdetails(ProjectConstants.getRunmangersheet());
		List<IMethodInstance> actualCases = new ArrayList<IMethodInstance>();
		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < excelcases.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(excelcases.get(j).get("testname"))
						&& excelcases.get(j).get("execute").equalsIgnoreCase("Yes")) {
					//methods.get(i).getMethod().setDescription(excelcases.get(j).get("testDescription"));
					//methods.get(i).getMethod().setPriority(Integer.parseInt(excelcases.get(j).get("priority")));
					methods.get(i).getMethod().getEnabled();
					actualCases.add(methods.get(i));
				}
			}
		}
		System.out.println("********************Below Test cases Enabled from Excel*****************");  
        System.out.println(actualCases);  
		return actualCases;
	}
}
