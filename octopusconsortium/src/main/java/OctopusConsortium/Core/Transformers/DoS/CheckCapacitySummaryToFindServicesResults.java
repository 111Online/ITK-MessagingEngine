/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService.ArrayOfServiceCareItemRotaSession;
import OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination;
import OctopusConsortium.DosService.CheckCapacitySummaryResponse;
import OctopusConsortium.DosService.ServiceCareSummaryDestination;
import OctopusConsortium.Service.Models.DayOfWeek;
import OctopusConsortium.Service.Models.FindServicesResponse;
import OctopusConsortium.Service.Models.ServiceCareItemRotaSession;
import OctopusConsortium.Service.Models.ServiceDetails;
import OctopusConsortium.Service.Models.TimeOfDay;


/**
 * @author stuart.yeates
 *
 */
public class CheckCapacitySummaryToFindServicesResults extends
		//AbstractMessageTransformer
		AbstractTransformer{


	//public static final String AssigningAuthorityName = "";
	/**
	 * 
	 */
	public CheckCapacitySummaryToFindServicesResults() {
		// TODO Auto-generated constructor stub
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.DosService.CheckCapacitySummaryResponse.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination.class));
		
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Service.Models.FindServicesResponse.class));
		//this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.Nhs111Endpoint.class));
	}

	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
						
		ArrayOfServiceCareSummaryDestination aoscs ;
		
		if(payload instanceof CheckCapacitySummaryResponse ) 
		{
			CheckCapacitySummaryResponse  response = (CheckCapacitySummaryResponse)payload;
			aoscs = response.getCheckCapacitySummaryResult();
		}
		else
			aoscs = (ArrayOfServiceCareSummaryDestination) payload;
		
		FindServicesResponse findSeervicesResopnce = new FindServicesResponse();
		
		if(aoscs!=null)
		{	
			findSeervicesResopnce.setResults( new ArrayList<OctopusConsortium.Service.Models.ServiceCareSummaryDestination>());
			List<ServiceCareSummaryDestination> results = aoscs.getServiceCareSummaryDestination();
			//if we decide to copy the results object then PropertyUtils.copyProperties can be used
			for (ServiceCareSummaryDestination serviceCareSummaryDestination : results) {
				
				OctopusConsortium.Service.Models.ServiceCareSummaryDestination dest = new OctopusConsortium.Service.Models.ServiceCareSummaryDestination();
				
				dest.setAddress(serviceCareSummaryDestination.getAddress());
				dest.setContactDetails(serviceCareSummaryDestination.getContactDetails());
				dest.setEastings(serviceCareSummaryDestination.getEastings());
				dest.setId(serviceCareSummaryDestination.getId());
				dest.setName(serviceCareSummaryDestination.getName());
				dest.setNorthings(serviceCareSummaryDestination.getNorthings());
				dest.setNotes(serviceCareSummaryDestination.getNotes());
				//dest.setObsolete(serviceCareSummaryDestination.isObsolete());
				dest.setObsolete(false);
				dest.setOdsCode(serviceCareSummaryDestination.getOdsCode());
				dest.setOpenAllHours(serviceCareSummaryDestination.isOpenAllHours());
				dest.setPostcode(serviceCareSummaryDestination.getPostcode());
				//dest.setRootParent(convertServiceDetails(serviceCareSummaryDestination.getRootParent()));				
				dest.setRotaSessions(convertArrayOfServiceCareItemRotaSession(serviceCareSummaryDestination.getRotaSessions()));
				dest.setServiceType(convertServiceDetails(serviceCareSummaryDestination.getServiceType()));
				//dest.setUpdateTime(serviceCareSummaryDestination.getUpdateTime());
				dest.setUrl(serviceCareSummaryDestination.getUrl());
				findSeervicesResopnce.getResults().add(dest);
			}
						
		}
		
		return findSeervicesResopnce;
	}


	private List<ServiceCareItemRotaSession> convertArrayOfServiceCareItemRotaSession(
			ArrayOfServiceCareItemRotaSession rotaSessions) {
		ArrayList<ServiceCareItemRotaSession> returnValues = null;
		if( rotaSessions != null ){
			returnValues = new ArrayList<ServiceCareItemRotaSession>();
		
			List<OctopusConsortium.DosService.ServiceCareItemRotaSession> rota = rotaSessions.getServiceCareItemRotaSession();
			
			for (OctopusConsortium.DosService.ServiceCareItemRotaSession serviceCareItemRotaSession : rota) {
				ServiceCareItemRotaSession item = new ServiceCareItemRotaSession();
				item.setEndDayOfWeek(getDayConvert(serviceCareItemRotaSession.getEndDayOfWeek()));
				item.setEndTime(getTimeConvert(serviceCareItemRotaSession.getEndTime()));
				item.setStartDayOfWeek(getDayConvert(serviceCareItemRotaSession.getStartDayOfWeek()));
				item.setStartTime(getTimeConvert(serviceCareItemRotaSession.getStartTime()));
				item.setStatus(serviceCareItemRotaSession.getStatus());			
				returnValues.add(item);
			}
		}
		return returnValues;
	}


	private ServiceDetails convertServiceDetails(
			OctopusConsortium.DosService.ServiceDetails rootParent) {
		ServiceDetails details = null;
		if(rootParent != null){
			details = new ServiceDetails();
			details.setId(rootParent.getId());
			details.setName(rootParent.getName());
		}
		
		return details;
	}
	
	private DayOfWeek getDayConvert(OctopusConsortium.DosService.DayOfWeek value)
    {
    	if(value == OctopusConsortium.DosService.DayOfWeek.MONDAY)
			return DayOfWeek.MONDAY;
    	else if(value == OctopusConsortium.DosService.DayOfWeek.TUESDAY)
			return DayOfWeek.TUESDAY;
    	else if(value == OctopusConsortium.DosService.DayOfWeek.WEDNESDAY)
    		return DayOfWeek.WEDNESDAY;
    	else if(value == OctopusConsortium.DosService.DayOfWeek.THURSDAY)
    		return DayOfWeek.THURSDAY;
    	else if(value == OctopusConsortium.DosService.DayOfWeek.FRIDAY)
    		return DayOfWeek.FRIDAY;
    	else if(value == OctopusConsortium.DosService.DayOfWeek.SATURDAY)
    		return DayOfWeek.SATURDAY;
    	else 
    		return DayOfWeek.SUNDAY;    	
    }
    private TimeOfDay getTimeConvert(OctopusConsortium.DosService.TimeOfDay value) 
    {
    	TimeOfDay t = new TimeOfDay();
    	try {
			PropertyUtils.copyProperties(t, value);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return t;
    	
    }



	


	


	

	
}
