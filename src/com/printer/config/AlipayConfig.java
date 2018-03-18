package com.printer.config;

import java.io.FileWriter;
import java.io.IOException;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082700326310";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDO4bVB/2I7R/K/vs2qIU2Pa/tFPOnGPek0aUtYJpfaocpG1fXjn7vkkNiYsBNQEnJ0Wn+iQ2XBkqXqp8U5TP/B8f+JG3b1oh79fgAXsZw6UYOJHhVa2YmAbTpEzBuedXAKRD6JEfkkPX3ZA5kcvEHxiSfw7GqSs4zto6hJ/aWsauivWJgF+Yjd5/ch5fhBdtYU2f93P+uncQsrDi0ANQ5dAEqvk5P5UQJYfE4+1ge7J2Zpgn/DBMtgAjiET4w0jwmYUgA41KbnZ10VfVaODBfm5Gr6AeSQQOyAjFYgLluvaloDinyaUTBBMEuHwZV7MZu997Y/RrX/Ccg3B63YBVrtAgMBAAECggEACIN/WxTwbPIcCkoG2q5+K53M/F9yW2cm1rJSmHEWJLgtw9aARPrI17IiR75PPSdVMHac9AeEA4BOdaar1hzWFZwo4PKRZbBjSBlMVa1IeZnrKNRlGpUDNJbKJBSmOlIo5zNBw5BKyXQCXtDoFyekKxVy4FZKWHktHoZyoYDftYWp0wVzVnNJCo4XqqEwYCC9VVmnDJrRA+2HLtOK/iTTJ4JwP/nwY3AsD7mBUl4HSdS9Ls/E5l6wXZq9+2vvCSDJLW+CIYM+4SCDttzn6Xpo78xngINzDPHf0oItgm1q0PKSknB/hOWVI18ebGr7IfbDJd56KX/6l2L/AmI8AscwYQKBgQDvSf1JlYUyEAvMHPEMcbYJKdtXAULI1jQN9zuALXX6DkZXe8AXW+nOD/oLxFHocJUEdQN+vevn6DroHbNkClK5dF6Q4vQOL5H4j6l1J0vxlFypb89VH23aqoKsC+93iwvrzExnlHu5Bumgi6/oxF4NELZZw2l3j0J2+dO9rUTLeQKBgQDdVFcAO//TQoEeU5B+t9KBu4k0KLyIBtEN3/B/So2Y+W6C31RCTEm7RQm03p+uihIk3nqqP+RT66p/Xu3vTUczKzHWs59xq6V5Far9vv7ykjB+6eG6yCiFIL1xEcjh1FBtjNqcDo6OlRch3mpfdEwYcOvuF/6lrNn6or6USHF6FQKBgEmxOJ7rvDxhsrBmjVmuv0ftKw6NZdriFN/kLt/XoEilEsaoZs0K0mNSikgLasoxucLIoo3qwXcHDvUjCHcbssRIcUMfkde4kLTC0YYx1vKMJUlNFMX7SuKXtmxztIjVOpOgtDsGAGBIH7UAr+j4aJqPdgkI5Dcc2HQ5lhsI/HHJAoGAELvetBLVPcjKcFuLEjmdvddLAVmPH428Ypsq2MTvPcCmHVj7SuPvsyv+FuG6Gv0vcAAuMA8SmVG5G1Y3ER+7oV/DreL4zCRZJ3V+7x5wsjBhYEcYnQGjJqWaDSF2GbTuu8mpgaEMIDWfgR0K19q4IiTvgZno0+fktzF0zUtI4R0CgYBT/All4YdUzSVwxIkIsxZb2RyoFqo1+crROccIlpuBWuqS+FQBuiUwvgPhUO3vg1QY4es7/oZJYXLS1RQNgn08LFr+UVz/kS0gvxWVqNNe9/DXvN8jxGzp47wqVBw6A7Sla91Q5gnbt0rqtIT4cUpDYT2dPoVn/kHxol0BrgC16Q==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwkzd5T5lwbnWsPmhAJB9DqqK8VXENHRA26BgT7MilpWdvVA4/Qm0ExOZ6Djl7arMbr8r6v+H9OH0JqZvZ85w0G3drKjwzAAHfu2ocBGdvHmNClOXIndcitZEpj3Wnh8VxDD/sYzlbV6s7HA5hSv+YPu0nRFzTvKkHipCIezE0+D4NFOC8Qq04wvlfXhF7ILfffjH0xlYV5MNNraFZ9bg539RqcNHi7AuEjAzdHKoItb+UPX1N3vs60tEvm1njyYsyPMsE4OpRLErxGo1nwup1G+VA89I2KcqoHXHaeB/EENOs1uO5faj8NgFuVbuoQwsYfyIyUDyCXjSbRYF6XvRGQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:8080/printerWeb/pay/notify_url.action";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:8080/printerWeb/pay/return_url.action";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "UTF-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	public static AlipayClient alipayClient = new DefaultAlipayClient(
			gatewayUrl, app_id, merchant_private_key, "json", charset,
			alipay_public_key, "RSA2");
	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_"
					+ System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
