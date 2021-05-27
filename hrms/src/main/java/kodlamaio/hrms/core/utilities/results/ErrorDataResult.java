package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, Map<String,String> message) {
		super(data, false ,message);
	}
	
	public ErrorDataResult(T data) {
		super(data,false);
	}
	
	public ErrorDataResult(Map<String,String> message) {
		super(null, false ,message);
	}
	
	public ErrorDataResult() {
		super(null, false);
	}

}