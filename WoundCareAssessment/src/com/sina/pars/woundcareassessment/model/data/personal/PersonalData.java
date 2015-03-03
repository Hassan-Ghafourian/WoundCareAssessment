
package com.sina.pars.woundcareassessment.model.data.personal;

import com.sina.pars.woundcareassessment.model.data.Data;

public abstract class PersonalData extends Data {
	private final int id;
	private final String name;
	private final String family;

	public PersonalData(int id, String name, String family) {
		this.id = id;
		this.name = name;
		this.family = family;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFamily() {
		return family;
	}

	@Override
	public String toString() {
		return "PersonalData [id=" + id + ", name=" + name + ", family="
				+ family + "]";
	}

}
