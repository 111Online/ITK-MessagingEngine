package OctopusConsortium.Core;

import java.io.Serializable;

import org.junit.Test;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SqlCacheInterceptorTests  extends AbstractMuleContextTestCase {

	

	@Test
	public void testProcessCacheMiss() throws MuleException{
		//Arrange
		//#################
		SqlCacheInterceptor target = new SqlCacheInterceptor();
		MessageProcessor mp = mock(MessageProcessor.class);
		target.setListener(mp);
		@SuppressWarnings("unchecked")
		SqlObjectStore<Serializable> sos = mock(SqlObjectStore.class); 
		target.setStore(sos);
		
		MuleEvent me = mock(MuleEvent.class);		
		MuleMessage mm = mock(MuleMessage.class);
		String payload = "test";
		when(me.getMessage()).thenReturn(mm);
		when(mm.getPayload()).thenReturn(payload);
		
		MuleEvent meReturn = mock(MuleEvent.class);
		MuleMessage mmReturn = mock(MuleMessage.class);
		String payloadReturn = "testReturn";
		when(meReturn.getMessage()).thenReturn(mmReturn);
		when(mmReturn.getPayload()).thenReturn(payloadReturn);
		
		when(mp.process(me)).thenReturn(meReturn);
		
		
		
		//Act
		//##################		
		MuleEvent result =target.process(me);
		
		//Assert
		//##################
		verify( me ).getMessage();
		verify( mm ).getPayload();
		verify( sos ).retrieve(any(Serializable.class));
		verify( sos ).store(any(Serializable.class), eq((Serializable)payloadReturn));
		assertEquals(payloadReturn,result.getMessage().getPayload());
	}
	
	@Test
	public void testProcessCacheHit() throws Exception{
		//Arrange
		//#################
		SqlCacheInterceptor target = new SqlCacheInterceptor();
		MessageProcessor mp = mock(MessageProcessor.class);
		target.setListener(mp);
		@SuppressWarnings("unchecked")
		SqlObjectStore<Serializable> sos = mock(SqlObjectStore.class); 
		target.setStore(sos);
		
		String payload = "test";
		
		MuleEvent me = mock(MuleEvent.class);			
		//MuleMessage mm = mock(MuleMessage.class);
		DefaultMuleMessage dmm = new DefaultMuleMessage(payload,this.createMuleContext());
				
		
		when(me.getMessage()).thenReturn(dmm);
		when(me.getMuleContext()).thenReturn(this.createMuleContext());
		//when(mm.getPayload()).thenReturn(payload);
		
		MuleEvent meReturn = mock(MuleEvent.class);
		MuleMessage mmReturn = mock(MuleMessage.class);
		String payloadReturn = "testReturn";
		when(meReturn.getMessage()).thenReturn(mmReturn);
		when(meReturn.getMuleContext()).thenReturn(this.createMuleContext());
		when(mmReturn.getPayload()).thenReturn(payloadReturn);
		
		when(mp.process(me)).thenReturn(meReturn);
				
		when(sos.retrieve(any(Serializable.class))).thenReturn(payloadReturn);
		
		
		//Act
		//##################		
		MuleEvent result = target.process(me);
		
		//Assert
		//##################
		verify( me ).getMessage();
		//verify( mm ).getPayload();
		verify( sos ).retrieve(any(Serializable.class));
		verify( sos , never() ).store(any(Serializable.class), eq((Serializable)payloadReturn));
		
		assertEquals(payloadReturn,result.getMessage().getPayload());
		
	}
}
