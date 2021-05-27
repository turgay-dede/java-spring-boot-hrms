package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class ErrorResult extends Result {
	
	public ErrorResult() {
		super(false);		
	}
	
	public ErrorResult(Map<String,String> message) {
		super(false, message);		
	}
	
	

}
