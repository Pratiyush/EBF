package de.ebf.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.ebf.employee.service.IDataInitilizerService;
import static de.ebf.employee.constant.Constants.*;

/**
 * InitController is used for initialization of Test Data in H2 DB.
 *
 * @author Pratiyush Kumar Singh
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1")
public class InitController {

	@Autowired
	private IDataInitilizerService dataInitilizerService;

	/**
	 * This method is used to initialize Employees and Companies.
	 * @return String - Message after Successful Initialization.
	 */
	@GetMapping("/init")
	String getAllEmployees() {
		dataInitilizerService.init();
		return APP_INITILIZED;//TODO: Better Way of Handling Response.
	}

}
