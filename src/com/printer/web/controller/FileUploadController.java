package com.printer.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.printer.pojo.Fileinfo;
import com.printer.service.ComPojo;
import com.printer.service.OrderService;
import com.printer.utils.GetPage;
import com.printer.utils.SaveFile;

@Controller
public class FileUploadController {
	@Autowired
	OrderService orderService;

	@ResponseBody
	@RequestMapping(value = "/FileUp", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("id") String id,
			@RequestParam("name") final String name,
			@RequestParam("type") String type,
			@RequestParam("lastModifiedDate") final String lastModifiedDate,
			@RequestParam("size") final int size,
			@RequestParam("file") MultipartFile file, final HttpSession session) {
		final String fileName;

		try {
			String ext = name.substring(name.lastIndexOf("."));

			fileName = UUID.randomUUID().toString() + ext;
			SaveFile.saveFile(SaveFile.getRealPath(), fileName, file);
			new Thread() {
				public void run() {
					int page = GetPage.getPage(SaveFile.getRealPath()
							+ fileName);
					session.setAttribute(name + size, page);
				};
			}.start();

		} catch (Exception ex) {
			ex.printStackTrace();
			return "{\"error\":true}";
		}

		return "{\"id\" : \"" + id + "\",\"filePath\" :\"" + fileName + "\"}";
	}

	@ResponseBody
	@RequestMapping("/getFilePage")
	public String getFilePage(String string, HttpSession session) {
		Object attribute = session.getAttribute(string);
		int i = 0;
		while (attribute == null) {
			try {
				Thread.sleep(1000);
				i++;
				if (i > 30) {
					return "{\"page\":\"计算页数超时，请自行输入\"}";
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			attribute = session.getAttribute(string);

		}
		if (attribute.toString().equals("0"))
			return "{\"page\":\"文件格式错误，请检查上传文件\"}";
		return "{\"page\":\"已上传，共" + attribute.toString() + "页\"}";

	}

	@ResponseBody
	@RequestMapping("/paying")
	public String paying(@RequestBody ComPojo comPojo,
			HttpServletRequest request, HttpServletResponse response) {
		String id = UUID.randomUUID().toString();
		comPojo.getOrder().setOther("");

		comPojo.getOrder().setOrderid(id);
		comPojo.getOrder().setPay(0);
		comPojo.getOrder().setDone(0);
		comPojo.getOrder().setTime(new Date());
		ArrayList<Fileinfo> fileinfos = comPojo.getFileinfos();
		// System.out.println(comPojo.getOrder());
		for (Fileinfo fileinfo : fileinfos) {
			fileinfo.setOrderid(id);
			// System.out.println(fileinfo);
		}
		orderService.addOrder(comPojo);
		return "{\"id\":" + "\"" + id + "\",\"pay\":\"0.5\"}";
	}
}
