package OctopusConsortium.Core.Transformers.ITK;

import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

public class TestTransformer extends AbstractTransformer {

	public TestTransformer() {
		super();			
		this.registerSourceType(DataTypeFactory.create(Object.class));
		this.setReturnDataType(DataTypeFactory.create(Object.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc) {
		@SuppressWarnings("unused")
		Object temp = src;
	
		return src;
	}

}
