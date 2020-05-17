package com.lifecycle.xmlconfiguration;

public class DellLaptop implements ILaptop {
	
	private ILaptopService laptopService;

	public void setLaptopService(ILaptopService laptopService) {
		this.laptopService = laptopService;
	}

	@Override
	public String getConfiguration() {
		return "This is 8GB RAM, i7 intel processor, 512 SSD";
	}

	@Override
	public String getServiceDueCycle() {
		return this.laptopService.getServiceDueCycle("dell");
	}

}
