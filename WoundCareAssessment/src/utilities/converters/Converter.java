package utilities.converters;

public interface Converter<T> {
	public T convert(Class<T> type, Object value);
}
