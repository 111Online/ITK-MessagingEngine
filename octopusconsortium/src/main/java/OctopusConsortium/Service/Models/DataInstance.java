package OctopusConsortium.Service.Models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataInstance", propOrder = {
	    "name",
	    "caption",
	    "value"	    
	})
public class DataInstance {

	@XmlElement(name = "Name", required = true)
	protected String name;
	@XmlElement(name = "Caption", required = false)
	protected String caption;
	@XmlElementWrapper(name = "Values")
	@XmlElement(name = "Value", type = String.class)
	protected List<String> value = new ArrayList<String>();

	public List<String> getValues(){
		return value;
	}
	public void setValues(List<String> value){
		this.value = value;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getCaption(){
		return this.caption;
	}
	public void setCaption(String caption){
		this.caption = caption;
	}
}
