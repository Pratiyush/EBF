package de.ebf.employee.service;

/**
 * IDataInitilizerService Interface is used for initialization of Test Data in
 * H2 DB.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
public interface IDataInitilizerService {
	
	/**
	 * This method deletes all Employees and Companies. After deleation it inserts
	 * some Test data in Employee and Company Tables.
	 *
	 */
	void init();
}
