
package OctopusConsortium.DosService1_5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.nww_pathwaysdos_nhs_uk.app.api.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceVersion_QNAME = new QName("https://nww.pathwaysdos.nhs.uk/app/api/webservices", "serviceVersion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.nww_pathwaysdos_nhs_uk.app.api.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceDetailsById }
     * 
     */
    public ServiceDetailsById createServiceDetailsById() {
        return new ServiceDetailsById();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link CheckCapacitySummary }
     * 
     */
    public CheckCapacitySummary createCheckCapacitySummary() {
        return new CheckCapacitySummary();
    }

    /**
     * Create an instance of {@link Case }
     * 
     */
    public Case createCase() {
        return new Case();
    }

    /**
     * Create an instance of {@link CheckCapacitySummaryResponse }
     * 
     */
    public CheckCapacitySummaryResponse createCheckCapacitySummaryResponse() {
        return new CheckCapacitySummaryResponse();
    }

    /**
     * Create an instance of {@link ArrayOfServiceCareSummaryDestination }
     * 
     */
    public ArrayOfServiceCareSummaryDestination createArrayOfServiceCareSummaryDestination() {
        return new ArrayOfServiceCareSummaryDestination();
    }

    /**
     * Create an instance of {@link ServiceDetailsByIdResponse }
     * 
     */
    public ServiceDetailsByIdResponse createServiceDetailsByIdResponse() {
        return new ServiceDetailsByIdResponse();
    }

    /**
     * Create an instance of {@link ArrayOfServices }
     * 
     */
    public ArrayOfServices createArrayOfServices() {
        return new ArrayOfServices();
    }

    /**
     * Create an instance of {@link GetHospitalScoresResponse }
     * 
     */
    public GetHospitalScoresResponse createGetHospitalScoresResponse() {
        return new GetHospitalScoresResponse();
    }

    /**
     * Create an instance of {@link ArrayOfHospitalScores }
     * 
     */
    public ArrayOfHospitalScores createArrayOfHospitalScores() {
        return new ArrayOfHospitalScores();
    }

    /**
     * Create an instance of {@link GetHospitalScores }
     * 
     */
    public GetHospitalScores createGetHospitalScores() {
        return new GetHospitalScores();
    }

    /**
     * Create an instance of {@link ArrayOfServiceCareItemRotaSession }
     * 
     */
    public ArrayOfServiceCareItemRotaSession createArrayOfServiceCareItemRotaSession() {
        return new ArrayOfServiceCareItemRotaSession();
    }

    /**
     * Create an instance of {@link ArrayOfServiceCareDestination }
     * 
     */
    public ArrayOfServiceCareDestination createArrayOfServiceCareDestination() {
        return new ArrayOfServiceCareDestination();
    }

    /**
     * Create an instance of {@link Attribute }
     * 
     */
    public Attribute createAttribute() {
        return new Attribute();
    }

    /**
     * Create an instance of {@link AgeRange }
     * 
     */
    public AgeRange createAgeRange() {
        return new AgeRange();
    }

    /**
     * Create an instance of {@link ArrayOfOpenTimeSpecified }
     * 
     */
    public ArrayOfOpenTimeSpecified createArrayOfOpenTimeSpecified() {
        return new ArrayOfOpenTimeSpecified();
    }

    /**
     * Create an instance of {@link ServiceDetail }
     * 
     */
    public ServiceDetail createServiceDetail() {
        return new ServiceDetail();
    }

    /**
     * Create an instance of {@link ServiceCareItemRotaSession }
     * 
     */
    public ServiceCareItemRotaSession createServiceCareItemRotaSession() {
        return new ServiceCareItemRotaSession();
    }

    /**
     * Create an instance of {@link Endpoint }
     * 
     */
    public Endpoint createEndpoint() {
        return new Endpoint();
    }

    /**
     * Create an instance of {@link ArrayOfAttributes }
     * 
     */
    public ArrayOfAttributes createArrayOfAttributes() {
        return new ArrayOfAttributes();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link Hospital }
     * 
     */
    public Hospital createHospital() {
        return new Hospital();
    }

    /**
     * Create an instance of {@link ServiceCareDestination }
     * 
     */
    public ServiceCareDestination createServiceCareDestination() {
        return new ServiceCareDestination();
    }

    /**
     * Create an instance of {@link TimeOfDay }
     * 
     */
    public TimeOfDay createTimeOfDay() {
        return new TimeOfDay();
    }

    /**
     * Create an instance of {@link ServiceCareSummaryDestination }
     * 
     */
    public ServiceCareSummaryDestination createServiceCareSummaryDestination() {
        return new ServiceCareSummaryDestination();
    }

    /**
     * Create an instance of {@link ArrayOfCapacityAttributes }
     * 
     */
    public ArrayOfCapacityAttributes createArrayOfCapacityAttributes() {
        return new ArrayOfCapacityAttributes();
    }

    /**
     * Create an instance of {@link ArrayOfServiceAgeRanges }
     * 
     */
    public ArrayOfServiceAgeRanges createArrayOfServiceAgeRanges() {
        return new ArrayOfServiceAgeRanges();
    }

    /**
     * Create an instance of {@link ArrayOfServiceEndpoints }
     * 
     */
    public ArrayOfServiceEndpoints createArrayOfServiceEndpoints() {
        return new ArrayOfServiceEndpoints();
    }

    /**
     * Create an instance of {@link CapacityAttribute }
     * 
     */
    public CapacityAttribute createCapacityAttribute() {
        return new CapacityAttribute();
    }

    /**
     * Create an instance of {@link ArrayOfInt }
     * 
     */
    public ArrayOfInt createArrayOfInt() {
        return new ArrayOfInt();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://nww.pathwaysdos.nhs.uk/app/api/webservices", name = "serviceVersion")
    public JAXBElement<String> createServiceVersion(String value) {
        return new JAXBElement<String>(_ServiceVersion_QNAME, String.class, null, value);
    }

}
