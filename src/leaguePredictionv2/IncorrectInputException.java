package leaguePredictionv2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IncorrectInputException extends Exception {

	private static Logger logger= Logger.getLogger("LoggingException");
	FileHandler filehandler;
	public IncorrectInputException(String message) throws IOException {
		super(message);
		//logger.setUseParentHandlers(false);
		filehandler=new FileHandler("LoggingException.txt");
		logger.addHandler(filehandler);
		 SimpleFormatter formatter = new SimpleFormatter();  
		filehandler.setFormatter(formatter);  
		
		 
	    	StringWriter trace = new StringWriter();
		    printStackTrace(new PrintWriter(trace));
		    logger.warning(trace.toString());
	   

		
		
	}
}