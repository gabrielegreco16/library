package library;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class CreateBook implements Callable{
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		@SuppressWarnings("unused")
		Book book=(Book) message.getPayload();
		Singleton addBook=Singleton.singleton();
		String response = addBook.addBook(book);
		if(response.equals("OK")){
			return message;
		}
		message.setPayload(response);
		return message;
	}
}
