package utilities.id;

public class ID {
	private final Class idClass;
	private final Object idSwitch;

	public ID(Class idClass, Object idSwitch) {
		super();
		this.idClass = idClass;
		this.idSwitch = idSwitch;
	}

	public Class getIdClass() {
		return idClass;
	}

	public Object getIdSwitch() {
		return idSwitch;
	}

}
