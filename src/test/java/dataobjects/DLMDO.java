package dataobjects;

import java.util.Map;



public class DLMDO {
	
	public String Name;
	public String EntityType;
	public String Type1;
	public String Type2;
	public String Type3;

	public String StageName;
	public String Description;
	public String Completion;
	public String getStageName() {
		return StageName;
	}

	public void setStageName(String StageName) {
		StageName = StageName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCompletion() {
		return Completion;
	}

	public void setCompletion(String completion) {
		Completion = completion;
	}



	
	public static DLMDO INSTANCE;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEntityType() {
		return EntityType;
	}

	public void setEntityType(String entityType) {
		EntityType = entityType;
	}

	public String getType1() {
		return Type1;
	}

	public void setType1(String type1) {
		Type1 = type1;
	}

	public String getType2() {
		return Type2;
	}

	public void setType2(String type2) {
		Type2 = type2;
	}

	public String getType3() {
		return Type3;
	}

	public void setType3(String type3) {
		Type3 = type3;
	}


		
	public Map<String, DLMDO> item;
	
	public static void setInstance(DLMDO instance){
		INSTANCE = instance;
	}
	
	public static DLMDO getINSTANCE() {
		return INSTANCE;
	}

	
	
	
}