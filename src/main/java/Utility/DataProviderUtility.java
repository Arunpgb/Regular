package Utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import HelperFunctions.ExcelUtils;
import ProjectConstants.ProjectConstants;

public class DataProviderUtility {

	private static List<Map<String, String>> list = new ArrayList<Map<String, String>>();

	@DataProvider(parallel = true)
	public Object[] getTestData(Method m) {
		String testName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestdetails(ProjectConstants.getDatasheet());
		}
		List<Map<String, String>> activeTestData = new ArrayList<Map<String, String>>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testName)
					&& list.get(i).get("execute").equalsIgnoreCase("Yes")) {
				activeTestData.add(list.get(i));
			}
		}
		return activeTestData.toArray();

	}
}
