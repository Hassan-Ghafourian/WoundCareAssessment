package utilities.converter;

public interface Converter {
	public <T> T convert(Class<T> type, Object value);
}
