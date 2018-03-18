package com.printer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.printer.mapper.FileinfoMapper;
import com.printer.mapper.OrderMapper;
import com.printer.pojo.DocPrint;
import com.printer.pojo.Fileinfo;
import com.printer.pojo.FileinfoExample;
import com.printer.pojo.Order;
import com.printer.pojo.PPTPrint;

@Service
public class OrderService {

	@Autowired
	OrderMapper orderMapper;
	@Autowired
	FileinfoMapper fileinfoMapper;

	public int getTotalNum() {
		// TODO Auto-generated method stub
		return 6;
	}

	public void setComplete(String id) {

		// orderMapper.updateByPrimaryKeySelective(record)
	}

	public void addOrder(ComPojo comPojo) {
		orderMapper.insert(comPojo.getOrder());
		ArrayList<Fileinfo> fileinfos = comPojo.getFileinfos();
		for (Fileinfo fileinfo : fileinfos) {
			fileinfoMapper.insert(fileinfo);
		}
	}

	public ArrayList<String> getFileName(String out_trade_no) {
		ArrayList<String> arrayList = new ArrayList<>();
		FileinfoExample fileinfoExample = new FileinfoExample();
		fileinfoExample.createCriteria().andOrderidEqualTo(out_trade_no);
		List<Fileinfo> list = fileinfoMapper.selectByExample(fileinfoExample);
		for (Fileinfo fileinfo : list) {
			arrayList.add(fileinfo.getSavename());
		}
		return arrayList;
	}

	public PPTPrint getPPTPrint(String string) {
		PPTPrint pptPrint = new PPTPrint();
		pptPrint.start = fileinfoMapper.selectByPrimaryKey(string)
				.getRangestart();
		pptPrint.end = fileinfoMapper.selectByPrimaryKey(string).getRangeend();
		pptPrint.douheyi = fileinfoMapper.selectByPrimaryKey(string)
				.getAllinone();
		return pptPrint;
	}

	public DocPrint getDocPrint(String string) {
		DocPrint docPrint = new DocPrint();
		docPrint.start = fileinfoMapper.selectByPrimaryKey(string)
				.getRangestart();
		docPrint.end = fileinfoMapper.selectByPrimaryKey(string).getRangeend();
		return docPrint;
	}

	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		List<Order> orderList = orderMapper.selectByExample(null);
		return orderList;
	}
}
