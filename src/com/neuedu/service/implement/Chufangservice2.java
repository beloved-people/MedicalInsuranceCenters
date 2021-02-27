package com.neuedu.service.implement;

import java.util.List;

import com.neuedu.entity.Chufang;

public class Chufangservice2 {
	public Double zi=0.0;
	public Double bao=0.0;
	public void person(String person) {
		
		Chufangservice chu=new Chufangservice();
		chu.person(person);
		List<Chufang> chu1=chu.chulist1;
		for(Chufang p:chu1) {
			zi=+p.getSumMoney();
		}
		List<Chufang> chu2=chu.chulist2;
		for(Chufang p:chu2) {
			zi=+p.getSumMoney()*0.5;
			bao=+p.getSumMoney()*0.5;	
		}
		List<Chufang> chu3=chu.chulist3;
		for(Chufang p:chu3) {
			bao=+p.getSumMoney();	
		}
	}
	/**
	 * @return the zi
	 */
	public Double getZi() {
		return zi;
	}
	/**
	 * @param zi the zi to set
	 */
	public void setZi(Double zi) {
		this.zi = zi;
	}
	/**
	 * @return the bao
	 */
	public Double getBao() {
		return bao;
	}
	/**
	 * @param bao the bao to set
	 */
	public void setBao(Double bao) {
		this.bao = bao;
	}
//	public static void main(String[] args) {
//		Chufangservice3 chu=new Chufangservice3();
//		chu.person("537");
//		System.out.println(chu.getBao2());
//		System.out.println(chu.getZi2());
//	}

}
