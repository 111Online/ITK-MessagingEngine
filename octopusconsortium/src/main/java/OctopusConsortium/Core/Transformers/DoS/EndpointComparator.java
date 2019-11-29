package OctopusConsortium.Core.Transformers.DoS;

import java.util.Comparator;

import OctopusConsortium.DosService1_5.Endpoint;

public class EndpointComparator implements Comparator<Endpoint>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Endpoint a, Endpoint b)
    {
    	return a.getEndpointOrder() - b.getEndpointOrder();
    }
}
