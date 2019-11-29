/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 * 
 * This is based on http://svn.codehaus.org/mule/branches/mule-3.x/tests/integration/src/test/java/org/mule/test/integration/routing/TestAggregator.java
 */

package OctopusConsortium.Core.Aggregators;

import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.store.ObjectStoreException;
import org.mule.routing.AbstractAggregator;
import org.mule.routing.AggregationException;
import org.mule.routing.EventGroup;
import org.mule.routing.correlation.CollectionCorrelatorCallback;
import org.mule.routing.correlation.EventCorrelatorCallback;

import java.util.ArrayList;
import java.util.Iterator;

public class StringArrayAggregator extends AbstractAggregator
{
    @Override
    protected EventCorrelatorCallback getCorrelatorCallback(MuleContext muleContext) {
        return new CollectionCorrelatorCallback(muleContext,storePrefix)
        {
            @Override
            public MuleEvent aggregateEvents(EventGroup events) throws AggregationException {
                ArrayList<String> buffer = new ArrayList<String>();

                try {
                    for (Iterator<MuleEvent> iterator = events.iterator(); iterator.hasNext();) {
                        MuleEvent event = iterator.next();
                                              
                        Object payload = event.getMessage().getPayload();
                        
                		if(payload instanceof String[]){
		                    String[] msg = (String[])payload;
		                	
		                    for(int index = 0; index < msg.length; index++) {
		                    	if (msg[index] != null) {
		                    		buffer.add(msg[index]);
		                    	}
		                    }
                        }
                		else {
                			throw new AggregationException(events,null);
                		}
                    }
                }
                catch (ObjectStoreException e) {
                    throw new AggregationException(events,null,e);
                }

                buffer.trimToSize();
                String[] linkArr = new String[buffer.size()];
                linkArr = buffer.toArray(linkArr);
                
                return new DefaultMuleEvent(new DefaultMuleMessage(linkArr, muleContext), events.getMessageCollectionEvent());
            }
        };
    }
}