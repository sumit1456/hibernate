package Exception;

public class InvalidId extends RuntimeException {
	
	public String getMessage() {
		return "Invalid id, Please Enter correct id's";
	}

}
