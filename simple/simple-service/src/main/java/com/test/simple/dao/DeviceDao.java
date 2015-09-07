package com.test.simple.dao;

import java.util.concurrent.ConcurrentHashMap;

import com.test.simple.pojo.Device;

public class DeviceDao {
	
	private ConcurrentHashMap<String, Device> fakeDB = new ConcurrentHashMap<String, Device>();

	public DeviceDao() {
		super(); 
		
		fakeDB.put("192.168.1.1", new Device("192.168.1.1"));
		fakeDB.put("192.168.1.2", new Device("192.168.1.2"));
	}

	public Device getDevice(String deviceIp) {
		return fakeDB.get(deviceIp);
	}

	public Device updateDevice(Device device) {
		String ip = device.getIp();
		fakeDB.put(ip, device);
		return fakeDB.get(ip);
	}

}
