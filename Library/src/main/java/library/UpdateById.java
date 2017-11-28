package library;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class UpdateById implements Callable {
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		@SuppressWarnings("unused")
		Book book=(Book) message.getPayload();
		Singleton updateById=Singleton.singleton();
		message.setPayload(	updateById.updateById(book));
		return message; 
	}
}
