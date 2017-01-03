package puneet.chugh;

import java.util.Collection;
import java.util.Map;

public interface GenericMap<K, V> extends Map<K,Collection<V>>{

	boolean insertItem(K key, V value);
	
	Collection<V> getItems(K key);
}
