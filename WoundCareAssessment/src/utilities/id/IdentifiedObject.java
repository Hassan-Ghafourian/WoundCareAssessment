package utilities.id;

public interface IdentifiedObject<I> {
	I getId(Object idSwitch);

	void matchSwitch(ID id);

	boolean matchID(ID id);
}