package com.printer.service;

import java.util.ArrayList;

import com.printer.pojo.Fileinfo;
import com.printer.pojo.Order;

public class ComPojo {
	Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public ArrayList<Fileinfo> getFileinfos() {
		return fileinfos;
	}

	public void setFileinfos(ArrayList<Fileinfo> fileinfos) {
		this.fileinfos = fileinfos;
	}

	ArrayList<Fileinfo> fileinfos;
}
