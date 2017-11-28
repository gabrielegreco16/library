package library;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

public class FindByName implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		Singleton find = Singleton.singleton();
		String name = message.getPayloadAsString();
		Book result = find.findByName(name);
		if(result!=null){
			return result;
		}
		else{
			return "Book not found";
		}
	}
}
