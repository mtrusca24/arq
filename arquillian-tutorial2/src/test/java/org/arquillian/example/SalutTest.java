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

@RunWith(Arquillian.class)
public class SalutTest {

	@Inject
	public Salut salut;
	
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Salut.class)// ca sa stie framework-ul de clasa asta
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	
	
	@Test
	public void metodaDeTest() {
		assertEquals("salut marius", salut.mesajDeSalutare("marius"));
		salut.salutare(System.out, "marius");
	}
	
	
}
