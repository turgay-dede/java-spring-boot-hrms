package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, Map<String,String> message) {
		super(data, true, message);		
	}
	
	public SuccessDataResult(T data) {
		super(data, true);		
	}
	
	public SuccessDataResult(Map<String,String> message) {
		super(null, true ,message);
	}
	
	public SuccessDataResult() {
		super(null, true);
	}

}
