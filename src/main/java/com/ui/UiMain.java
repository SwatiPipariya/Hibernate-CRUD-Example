package com.ui;

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
		
		Products p4 = new Products(4, "Product4", 50, 100);
		// This is our transaction where we can add, remove, update the products
		em.getTransaction().begin();
		
		em.persist(p4);
		
		em.getTransaction().commit();
		
		System.out.println("Product added successfully");
		
		em.close();   // This is done for closing the connection
		
		
		
	}
}
