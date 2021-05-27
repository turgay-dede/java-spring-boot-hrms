package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class SuccessResult extends Result {
	
	public SuccessResult() {
		super(true);		
	}
	
	public SuccessResult(Map<String,String> message) {
		super(true, message);		
	}
	

}
