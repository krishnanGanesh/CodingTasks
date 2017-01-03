package puneet.chugh;

import java.util.List;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class GroceryStore<K,V> implements GenericMap<K,V>{

	private Map<K,List<V>> map;
	
	
	public GroceryStore(){
		
		map = new HashMap<K,List<V>>();
	}
	
	@Override
	public int size() {
		if(map == null){
			System.out.println("The map is still null.");
			return 0;
		}
		return(map.size());
	}

	@Override
	public boolean isEmpty() {
		
		if(map == null){
			System.out.println("The map is empty already.");
			return true;
		}
		
		if(map.isEmpty()){
			System.out.println("The map is empty.");
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		
		if(map == null){
			throw new IllegalArgumentException("Map is null.");
		}
		if(map.containsKey(key)){
			System.out.println("Map contains the key.");
			return true;
		}
		else{
			System.out.println("Map doesn't contain the key.");
			return false;
		}
	}

	@Override
	public boolean containsValue(Object value) {
		
		Set<K> keys = map.keySet();
		for(K key: keys){
			if(map.get(key).contains(value)){
				System.out.println("The value "+value+" found in key "+key);
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<V> get(Object key) {
		
		if(map.containsKey(key)){
			List<V> productList = map.get(key);
			return productList;
		}
		System.out.println("No matching records for this key.");
		return null;
	}

	@Override
	public Collection<V> put(K key, Collection<V> value) {
		List<V> list = new LinkedList<V>();
		if(map.containsKey(key)){
			list = map.get(key);
			list.addAll(value);
		}
		list.addAll(value);
		map.put(key, list);
		return value;
	}

	@Override
	public Collection<V> remove(Object key) {
		if(map.containsKey(key)){
			List<V> list = map.get(key);
			System.out.println("Removed Key : "+key);
			map.remove(key);
			return list;
		}
		System.out.println("There's no key corresponding to the given key "+key);
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends Collection<V>> m) {
		
		if(map == null){
			System.out.println("The map in the argument is empty");
			return;
		}
		Set<? extends K> setOfKeys = map.keySet();
		for(K key: setOfKeys){
			
			this.map.put(key, (LinkedList<V>)map.get(key));
		}
	}

	@Override
	public void clear() {
		
		if(map.isEmpty()){
			System.out.println("Its an empty Map already.");
			return;
		}
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		
		if(map == null){
			System.out.println("The map is null.");
			return null;
		}
		return(map.keySet());
	}

	@Override
	public Collection<Collection<V>> values() {
		
		if(map == null){
			System.out.println("The map is null");
		}
		
		Collection<Collection<V>> linkedList = new LinkedList<Collection<V>>();
		for(List<V> individualArrayLists : map.values()){
			linkedList.add(individualArrayLists);
		}
		return linkedList;
	}

	@Override
	public Set<java.util.Map.Entry<K, Collection<V>>> entrySet() {
		
		if(map == null){
			System.out.println("Map is null.");
			return null;
		}
		Set<Map.Entry<K, Collection<V>>> returnEntrySet = new HashSet<>();
		
		for(Entry<K, List<V>> mapObject : map.entrySet()){
			
			Entry<K,Collection<V>> individualEntry;
			individualEntry = new AbstractMap.SimpleEntry<K,Collection<V>>(mapObject.getKey(), mapObject.getValue());
			
			returnEntrySet.add(individualEntry);
		}
		return returnEntrySet;
	}

	@Override
	public boolean insertItem(K key, V value) {
		
		List<V> productsList = new LinkedList<V>(getItems(key));
		if(productsList == null){
			productsList = new LinkedList<V>();
		}
		productsList.add(value);
		map.put(key, productsList);
		return false;
	}

	@Override
	public Collection<V> getItems(K key) {
		
		if(map.containsKey(key)){
			List<V> productList = map.get(key);
			return productList;
		}
		System.out.println("No matching records for this key.");
		return null;
	}
}
