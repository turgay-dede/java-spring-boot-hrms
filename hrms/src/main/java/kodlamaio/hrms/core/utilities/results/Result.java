package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class Result {
	private boolean success;
	private Map<String,String> message;	
	

	public Result(boolean success) {
		this.success = success;
	}
	
	public Result(boolean success, Map<String,String> message) {
		this(success);
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public Map<String,String> getMessage() {
		return message;
	}

}
