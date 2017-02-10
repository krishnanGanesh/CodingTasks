package puneet.chugh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MainClass {

	public static void main(String[] args){
		
		implementGroceryStore();
		implementCarShowroom();
	}
	
	public static void implementGroceryStore(){
		
		GroceryStore<String, String> groceryStore = new GroceryStore<String, String>();
		LinkedList<String> foodList = new LinkedList<String>();
		foodList.add("Fruit");
		foodList.add("Dog-Food");
		foodList.add("Vegetables");
		foodList.add("Juice");
		foodList.add("Cookies");
		groceryStore.put("Food", foodList);
		
		LinkedList<String> retrievedFoodList = (LinkedList<String>)groceryStore.get("Food");
		System.out.println("The food items are : ");
		for(String foodItem : retrievedFoodList){
			System.out.println(foodItem);
		}
		
		LinkedList<String> foodList2 = new LinkedList<String>();
		foodList2.add("Dry-Fruits");
		foodList2.add("Breads");
		foodList2.add("Meat");
		groceryStore.put("Food", foodList2);
		
		//This list shows the items are inserted at the front in LinkedList
		retrievedFoodList = (LinkedList<String>)groceryStore.get("Food");
		System.out.println("The food items are : ");
		for(String foodItem : retrievedFoodList){
			System.out.println(foodItem);
		}
		// There are no items corresponding to Key = Cosmetics
		LinkedList<String> retrievedCosmeticsList = (LinkedList<String>)groceryStore.get("Cosmetics");
		
		LinkedList<String> vitaminList = new LinkedList<String>();
		foodList2.add("Vitamin B-12");
		foodList2.add("Multi-Vitamin");
		foodList2.add("Zinc Supplement");
		groceryStore.put("Vitamins", vitaminList);
		
		LinkedList<String> dairyProductsList = new LinkedList<String>();
		foodList2.add("Milk");
		foodList2.add("Eggs");
		foodList2.add("Yogurt");
		groceryStore.put("Dairy", dairyProductsList);
		
		//This list will show that the ordering of the keys is not preserved in HashMap Implementation
		System.out.println("The set of keys is :");
		Set<String> keySet = groceryStore.keySet();
		for(String key: keySet){
			System.out.println(key);
		}
	}
	
	public static void implementCarShowroom(){
		
		CarShowroom<String, String> carShowroom = new CarShowroom<String, String>();
		ArrayList<String> hondaList = new ArrayList<String>();
		hondaList.add("CRV");
		hondaList.add("Civic-HatchBack");
		hondaList.add("Civic-Sedan");
		hondaList.add("Accord-Coup");
		hondaList.add("Accord-Sedan");
		carShowroom.put("Honda", hondaList);
		
		ArrayList<String> retrievedHondaList = (ArrayList<String>)carShowroom.get("Honda");
		System.out.println("The cars in the Honda List are : ");
		for(String foodItem : retrievedHondaList){
			System.out.println(foodItem);
		}
		
		ArrayList<String> hondaList2 = new ArrayList<String>();
		hondaList2.add("Odessey");
		hondaList2.add("City");
		carShowroom.put("Honda", hondaList2);
		
		//This list shows in ArrayList the items are inserted at the end in ArrayList
		retrievedHondaList = (ArrayList<String>)carShowroom.get("Honda");
		System.out.println("The cars in the Honda List are : ");
		for(String foodItem : retrievedHondaList){
			System.out.println(foodItem);
		}
		// There are no items corresponding to Key = Jaguar
		ArrayList<String> retrievedJaguarList = (ArrayList<String>)carShowroom.get("Jaguar");
		
		ArrayList<String> toyotaList = new ArrayList<String>();
		toyotaList.add("Prius");
		toyotaList.add("Corrola");
		toyotaList.add("Sienna");
		carShowroom.put("Toyota", toyotaList);
		
		ArrayList<String> hyundaiList = new ArrayList<String>();
		hyundaiList.add("Elantra");
		hyundaiList.add("Sonata");
		hyundaiList.add("i10");
		carShowroom.put("Hyundai", hyundaiList);
		
		
		ArrayList<String> audiList = new ArrayList<String>();
		hyundaiList.add("A-4");
		hyundaiList.add("A-7");
		hyundaiList.add("A-5");
		carShowroom.put("Audi", audiList);
		
		//This list will show that keys are sorted on the basis of TreeMap
		System.out.println("The set of keys is :");
		Set<String> keySet = carShowroom.keySet();
		for(String key: keySet){
			System.out.println(key);
		}
	}
}
