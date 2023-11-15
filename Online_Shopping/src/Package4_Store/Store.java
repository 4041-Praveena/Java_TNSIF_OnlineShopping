package Package4_Store;
import java.util.*;

import Package3_Product.Product;

public class Store {
	
	public ArrayList<Product> products;
	public HashMap<Integer,Integer> stock;
	
	public Store()
	{
		
		products =new ArrayList<Product>();
		stock=new HashMap<Integer,Integer>();
	}
	
	public void addProducts(Product product, int qty)
	{
		products.add(product);
		stock.put(product.getId(), qty);
	}

	
	public synchronized void sale(HashMap<Integer,Integer> carts)
	{
		for(Map.Entry<Integer,Integer> item: carts.entrySet())
		{
			
			int sqty=stock.get(item.getKey());
			if(sqty>=item.getValue())
			{
				int nqty=sqty-item.getValue();
				stock.replace(item.getKey(),nqty);
			}
		}
	}
	
	public void productsDisplay()
	{
		
		System.out.println("=======================================================================================================");
		System.out.printf("%-15s%-15s%-15s%-15s\n=======================================================================================================");
        for(Product p:products)
        {
        	System.out.printf("%-15d%-15s%-15.2f%-15d\n",p.getId(),p.getName(),p.getPrice(),stock.get(p.getId()));
        	   	
        }
	}
	
	
	
	
}
