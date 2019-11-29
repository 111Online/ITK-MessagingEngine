package OctopusConsortium.Core.Transformers.DoS.Proxy;

import java.util.Comparator;

import OctopusConsortium.Models.DOS.Proxy.Response.ContactDetailsField;

public class ContactFieldComparator implements Comparator<ContactDetailsField>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(ContactDetailsField a, ContactDetailsField b)
    {
    	return a.getOrderField() - b.getOrderField();
    }
}

