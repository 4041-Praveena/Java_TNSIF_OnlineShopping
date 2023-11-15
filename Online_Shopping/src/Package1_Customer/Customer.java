package Package1_Customer;
import java.util.*;
import Package4_Store.Store;


public class Customer extends Thread {
	
	private String name;
	private Store store;
	private HashMap<Integer,Integer> carts;
	
	public Customer(String name, Store store) {

		this.name = name;
		this.store = store;
		this.carts = new HashMap<Integer,Integer>();
	}
	
	public synchronized void addToCart()
	{
		
		Random r=new Random();
		List<Integer> list=new ArrayList<Integer>(store.stock.keySet());
		int n=r.nextInt(5)+1;
		for(int i=0;i<n;i++)
		{
			int index=r.nextInt(0,list.size());
			int qty=r.nextInt(10)+1;
			carts.put(list.get(index),qty);
		}
	}
	
	public void viewcart()
	{
		carts.forEach((key,value)->System.out.println(key+":"+value));
	}
	
	void buy()
	{
		store.sale(carts);
	}

	@Override
	
	public void run()
	{
		synchronized(this)
		{
			System.out.println(name+" do Shopping.....");
			addToCart();
			buy();
		}
	}
	
	
}
