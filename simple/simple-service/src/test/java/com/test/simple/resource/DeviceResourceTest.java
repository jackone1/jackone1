package com.test.simple.resource;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.simple.pojo.Device;
import com.test.simple.service.Main;

public class DeviceResourceTest {

	private HttpServer server;
	
	private WebTarget target;
	
	@Before
	public void setup() {
		server = Main.startServer();
		
		final Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}
	
	@After
	public void tearDown() {
		server.shutdownNow();
	}
	
	@Test
	public void testGet() {
		final String testIp = "192.168.1.1";
		final Device device = target.path("device").queryParam("ip", testIp).request().get(Device.class);
		assertEquals(testIp, device.getIp());
	}

	@Test
	public void testPut() {
		final String testIp = "192.168.1.2";
		final Device device = new Device(testIp);
		device.setStatus(1);
		
		Entity<Device> entity = Entity.entity(device, MediaType.APPLICATION_XML_TYPE);
		final Device result = target.path("device").request().put(entity, Device.class);
		assertEquals(1, result.getStatus());
	}

}
