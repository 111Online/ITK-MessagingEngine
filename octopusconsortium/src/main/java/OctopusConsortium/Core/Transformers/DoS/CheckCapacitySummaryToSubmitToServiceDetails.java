package OctopusConsortium.Core.Transformers.DoS;

import java.util.List;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination;
import OctopusConsortium.DosService.CheckCapacitySummaryResponse;
import OctopusConsortium.DosService.ServiceCareSummaryDestination;
import OctopusConsortium.Service.Models.SubmitToServiceDetails;

public class CheckCapacitySummaryToSubmitToServiceDetails extends
	//AbstractMessageTransformer
	AbstractTransformer{

	//public static final String AssigningAuthorityName = "";
	/**
	 * 
	 */
	public CheckCapacitySummaryToSubmitToServiceDetails() {
		// TODO Auto-generated constructor stub
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.DosService.CheckCapacitySummaryResponse.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination.class));
		
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitToServiceDetails.class));
		
	}
	
	@Override
	protected Object doTransform(Object payload, String enc)
			throws TransformerException {
		ArrayOfServiceCareSummaryDestination aoscs ;

		if (payload instanceof CheckCapacitySummaryResponse) {
			CheckCapacitySummaryResponse  response = (CheckCapacitySummaryResponse)payload;
			aoscs = response.getCheckCapacitySummaryResult();
		}
		else
			aoscs = (ArrayOfServiceCareSummaryDestination) payload;
		
		SubmitToServiceDetails submitToServiceDetails = new SubmitToServiceDetails();
		
		if(aoscs!=null)
		{
			List<ServiceCareSummaryDestination> results = aoscs.getServiceCareSummaryDestination();
			//if we decide to copy the results object then PropertyUtils.copyProperties can be used
			for (ServiceCareSummaryDestination serviceCareSummaryDestination : results) {
				if(serviceCareSummaryDestination.getServiceType()!=null && serviceCareSummaryDestination.getServiceType().getId() == 25){
					submitToServiceDetails.setId(serviceCareSummaryDestination.getId());
					submitToServiceDetails.setAddress(serviceCareSummaryDestination.getAddress());
					submitToServiceDetails.setName(serviceCareSummaryDestination.getName());
					submitToServiceDetails.setContactDetails(serviceCareSummaryDestination.getContactDetails());
					submitToServiceDetails.setOdsCode(serviceCareSummaryDestination.getOdsCode());
					submitToServiceDetails.setPostcode(serviceCareSummaryDestination.getPostcode());
					return submitToServiceDetails;
				}
			}						
		}		
		return submitToServiceDetails;
	}

}
