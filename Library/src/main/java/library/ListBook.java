package library;


import java.util.ArrayList;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;


public class ListBook implements Callable {
		public static ArrayList<Book> book = new ArrayList<>();
		
		@Override
		public Object onCall(MuleEventContext eventContext) throws Exception {
			MuleMessage message = eventContext.getMessage();
			Singleton list =Singleton.singleton();
			message.setPayload(list.getBooks());
			return message;
		}

}
