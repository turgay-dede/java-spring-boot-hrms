package kodlamaio.hrms.core.utilities.results;

import java.util.Map;

public class DataResult<T> extends Result {
	
	private T data;
	
	public DataResult(T data,boolean success, Map<String,String> message) {
		super(success, message);
		this.data=data;
		
	}
	
	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}	
	
	public T getData() {
		return this.data;
	}


}
