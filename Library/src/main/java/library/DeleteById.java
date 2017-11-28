package library;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import shapeless.syntax.singleton;

public class DeleteById implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		Singleton delete = Singleton.singleton();
		String value = message.getPayloadAsString();
		Integer id =Integer.valueOf(value);
		message.setPayload(delete.deleteById(id));
		return message;
	}
}
