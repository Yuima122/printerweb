package com.printer.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.printer.config.AlipayConfig;
import com.printer.pojo.DocPrint;
import com.printer.pojo.PPTPrint;
import com.printer.service.OrderService;
import com.printer.utils.File2Pdf;

@RequestMapping("pay")
@Controller
public class AliPayController {
	@Autowired
	OrderService orderService;

	@RequestMapping("do")
	public void pay(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse) throws Exception {
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);// 在公共参数中设置回跳和通知地址

		// 商户订单号，商户网站订单系统中唯一订单号，必填

		String out_trade_no = new String(httpRequest
				.getParameter("WIDout_trade_no").toString()
				.getBytes("ISO-8859-1"), "UTF-8");
		// String out_trade_no = "ab-sdfds";
		// 付款金额，必填
		String total_amount = new String(httpRequest
				.getParameter("WIDtotal_amount").toString()
				.getBytes("ISO-8859-1"), "UTF-8");
		// 订单名称，必填
		// String total_amount = "10.0";
		// String subject = new
		// String(httpRequest.getParameter("WIDsubject")
		// .getBytes("ISO-8859-1"), "UTF-8");
		String subject = "优印堂打印";
		// 商品描述，可空
		// String body = new String(httpRequest.getParameter("WIDbody")
		// .getBytes("ISO-8859-1"), "UTF-8");
		String body = "";

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no
				+ "\"," + "\"total_amount\":\"" + total_amount + "\","
				+ "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body
				+ "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		String form = "";

		form = AlipayConfig.alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单

		httpResponse.setContentType("text/html;charset=" + "UTF-8");

		httpResponse.getWriter().write(form);
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();

	}

	@RequestMapping(value = "notify_url")
	public void notify_url(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params,
				AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名

		// ——请在这里编写您的程序（以下代码仅作参考）——

		/*
		 * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		 * 3、校验通知中的seller_id（或者seller_email)
		 * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		 * 4、验证app_id是否为该商户本身。
		 */
		if (signVerified) {// 验证成功
			// 商户订单号
			final String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");

			// 交易状态
			String trade_status = new String(request.getParameter(
					"trade_status").getBytes("ISO-8859-1"), "UTF-8");

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
			}
			new Thread() {
				public void run() {
					orderService.setComplete(out_trade_no);
					ArrayList<String> list = orderService
							.getFileName(out_trade_no);
					for (String string : list) {
						String ext = string.substring(string.lastIndexOf("."))
								.toLowerCase();
						switch (ext) {
						case "doc":
						case "docx":
							try {
								DocPrint docPrint = orderService
										.getDocPrint(string);
								File2Pdf.doc2pdf(string, string + ".pdf",
										docPrint.start, docPrint.end);
							} catch (Exception e) {

								e.printStackTrace();
							}
							break;
						case "ppt":
						case "pptx":
							try {
								PPTPrint pptPrint = orderService
										.getPPTPrint(string);
								File2Pdf.ppt2pdf(string, string + ".pdf",
										pptPrint.douheyi, pptPrint.start,
										pptPrint.end);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						default:
							break;
						}
					}
				};
			}.start();

			response.getWriter().write("success");

		} else {// 验证失败
			response.getWriter().write("fail");

			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);
		}

	}

	@RequestMapping("return_url")
	public String return_url(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}

			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			// System.out.println(valueStr);
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params,
				AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名

		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter(
					"out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no")
					.getBytes("ISO-8859-1"), "UTF-8");

			// 付款金额
			String total_amount = new String(request.getParameter(
					"total_amount").getBytes("ISO-8859-1"), "UTF-8");
			return "index";
			// out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
		} else {
			// out.println("验签失败");
			return "print";
		}

	}
}
