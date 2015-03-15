package utilities.id;

import java.util.UUID;
	public class UUIDGenerator {
		public static String nextUUID() {
			return UUID.randomUUID().toString();    
		}

}