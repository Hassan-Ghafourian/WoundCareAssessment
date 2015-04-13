package utilities.converter;

public interface Converter<T> {
	public T convert(Class<T> type, Object value);
}
