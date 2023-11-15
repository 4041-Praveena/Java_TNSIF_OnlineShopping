package Package2_Run;
import java.util.*;

import Package1_Customer.Customer;
import Package3_Product.Product;
import Package4_Store.Store;
public class Run {
	
	public static void main(String[] args)
	{
		
		Store ms=new Store();
		ms.addProducts(new Product(205,"Chudi",500),45);
		ms.addProducts(new Product(253,"Jeans",550),50);
		ms.addProducts(new Product(987,"Crop Top",350),70);
		ms.addProducts(new Product(864,"Saree",150),85);
		ms.addProducts(new Product(345,"Long Top",450),65);
		ms.addProducts(new Product(877,"Leganha",350),20);
		ms.addProducts(new Product(438,"T-Shirt",1150),80);
		ms.addProducts(new Product(734,"Salwar",650),15);
		ms.addProducts(new Product(643,"Choli",300),60);
		ms.addProducts(new Product(765,"Skirt",700),95);
		ms.addProducts(new Product(534,"Gown",100),25);
		ms.addProducts(new Product(645,"Suit",800),75);
		ms.addProducts(new Product(231,"Kurta",2500),10);
		ms.addProducts(new Product(234,"Frock",850),90);
		ms.addProducts(new Product(675,"Western Wear",900),55);
		
		ms.productsDisplay();
		
		Random r=new Random();
		int n=r.nextInt(5)+1;
		Customer[] customers=new Customer[n];
		System.out.println(n+" Customers Created");
		
		for(int i=0;i<n;i++)
		{
			
			customers[i] = new Customer("Customer"+(i+1),ms);
		}
		
		
		for(int i=0;i<n;i++)
		{
			customers[i].start();
		}
		
		for(int i=0;i<n;i++)
		{
			try
			{
				customers[i].join();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Customer"+(i+1)+"purchase details");
			customers[i].viewcart();
		}
		
		ms.productsDisplay();

	}

}
