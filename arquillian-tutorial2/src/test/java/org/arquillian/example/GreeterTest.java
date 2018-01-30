package org.arquillian.example;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)//This declaration tells Arquillian to take over execution of the test when it’s launched.
public class GreeterTest {

	@Inject// ca sa se intample trebui sa fim intr-un framework
	Greeter greeter;

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				
				.addClass(Greeter.class)// ca sa stie framework-ul de clasa asta  si testul vedea doar acesta clasa
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		
		/*
		 * 
		 * JavaArchive archive = ShrinkWrap.create(JavaArchive.class,"myarchive.jar") 
   .addClasses(MyClass.class, MyOtherClass.class)
   .addResource("mystuff.properties");
		 */
	}
	
	@Test
	public void should_create_greeting() {
		assertEquals("Hello Earthling!", greeter.createGreeting("Earthling"));
		greeter.greet(System.out, "Earthling!");// clasa system contine in ea un PrintStream out care scrie ceva
		
	}

}
