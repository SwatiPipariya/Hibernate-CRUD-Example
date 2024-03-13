package com.ui;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dto.Products;

public class UiMain {
     
	public static void main(String[] args) {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products");
		
		EntityManager em = emf.createEntityManager();
		
		// Here we are finding a product
		// To retrieve data we use find method
		// This is a DRL statement so we don't need to start the transaction
		Products pro = em.find(Products.class, 2);
		
		if (pro!=null) {
			System.out.println(pro);
		} else {
			System.out.println("Product not found !!");
		}
		
		//Here we are adding a product in database
		// For this we need to start transaction and commit transaction
		
 		Products p7 = new Products(7, "Product7", 35, 100);
		// This is our transaction where we can add, remove, update the products
		em.getTransaction().begin();
		
		em.persist(p7);
		
		em.getTransaction().commit();
		
		System.out.println("Product added successfully");
		
		em.close();   // This is done for closing the connection
		
		
        //3. Here we are removing a product from database
		
		
		EntityManager em2 = emf.createEntityManager();

		Scanner sc = new Scanner(System.in);
		System.out.println("Write the ID of product that you want to remove !!");
		int id = sc.nextInt();
		em2.getTransaction().begin();
		// First we'll check product is present or not
		Products  product = em2.find(Products.class, id);
		
		if(product!=null) {
			// At this time we can say that product is present in our database
			em2.remove(product);
			System.out.println("Product whose id is "+id+" is removed successfully");
		}else {
			System.out.println("Product is not found in database whose id is "+id+"");
		}
		
		em2.getTransaction().commit();
		
		em2.close();
		
 
	}
}
