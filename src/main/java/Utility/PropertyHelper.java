package Utility;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import ProjectConstants.ProjectConstants;

/**
 * @author WS571
 *
 */
/************************************************************************************************************************************

In future-: Need to change Get Property Value to HashMap to avoid Thread safe issues 


*************************************************************************************************************************************/
public class PropertyHelper {

	public static Properties property;

	static {
		try {
			FileInputStream Fileimport = new FileInputStream(ProjectConstants.getBrowserconfig());
			property = new Properties();
			property.load(Fileimport);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getPropertyvalue(String key) throws Exception {
		if (Objects.isNull(property.get(key)) || Objects.isNull(key)) {
			throw new Exception("Property name " + key + " is not found. Please check Properties file. ");
		}
		return property.getProperty(key);
	}
	
	

}
