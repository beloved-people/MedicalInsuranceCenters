package com.neuedu.service.implement;

public class Chufangservice3 {
	public Double zi2=0.0;
	public Double bao2=0.0;
	public void person(String person) {
		
		Chufangservice2 chu=new Chufangservice2();
		chu.person(person);
		
		double x=chu.getZi();
		double y=chu.getBao();//可报销金额
		System.out.println(chu.getBao());
		System.out.println(chu.getZi());
		if(y<=100) {
			zi2=+x+y;
		}
		else if(100<y&&y<=10000) {
			zi2=+y*0.2+100+x;
			bao2=0.8*(y-100);
		}
		else if(10000<y&&y<=30000) {
			zi2=+(y-10000)*0.1+2080+x;
			bao2=0.9*(y-10000)+7920;
		}
		else if(30000<y&&y<=50000) {
			zi2=+(y-30000)*0.05+4080+x;
			bao2=0.95*(y-30000)+25920;
		}
		else if(50000<y) {
			zi2=+(y-50000)+5080+x;
			bao2=449200.0;
		}
	}
	/**
	 * @return the zi2
	 */
	public Double getZi2() {
		return zi2;
	}
	/**
	 * @param zi2 the zi2 to set
	 */
	public void setZi2(Double zi2) {
		this.zi2 = zi2;
	}
	/**
	 * @return the bao2
	 */
	public Double getBao2() {
		return bao2;
	}
	/**
	 * @param bao2 the bao2 to set
	 */
	public void setBao2(Double bao2) {
		this.bao2 = bao2;
	}
public static void main(String[] args) {
	Chufangservice3 chu=new Chufangservice3();
	chu.person("537");
	System.out.println(chu.getBao2());
	System.out.println(chu.getZi2());
}	
}
