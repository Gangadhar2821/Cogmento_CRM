package cogmentoCRM_Web.dataUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	// Map of test method name to file/sheet path
	private static final Map<String, String[]> testDataMap = new HashMap<>();

	static {
		testDataMap.put("login", new String[] { "./testdata/OurBank.xlsx", "LoginCreds" });
		// Add more mappings as needed (n Number of Excel Sheets you desire to)
	}

	@DataProvider(name = "DynamicExcelData")
	public Object[][] dynamicExcelData(Method method) {
		String methodName = method.getName();
		if (testDataMap.containsKey(methodName)) {
			String[] config = testDataMap.get(methodName);
			return ExcelUtility.getExcelData(config[0], config[1]);
		}
		throw new RuntimeException("No Excel mapping found for method: " + methodName);
	}
}
