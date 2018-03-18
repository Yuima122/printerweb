package com.printer.utils;

import com.itextpdf.text.pdf.PdfReader;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;

public class GetPage {

	public static int getPage(String path) {
		int page = 0;

		String ext = path.substring(path.lastIndexOf(".")).toLowerCase();
		// final String pdfname = path.substring(0, path.lastIndexOf("."))+
		// ".pdf";
		switch (ext) {
		case ".pdf":
			try {

				page = GetPage.getPdfPage(path);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return 0;
			}
			break;
		case ".doc":
		case ".docx":

		case ".ppt":
		case ".pptx":
			// page = GetPage.getPPTPage(path);
			// break;
			try {
				page = PIOGetPage.getPage(path);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			break;

		default:
			break;
		}

		if (page == 0) {
			switch (ext) {
			case ".doc":
			case ".docx":
				try {
					page = getWordPage(path);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case ".ppt":
			case ".pptx":
				try {
					page = getPPTPage(path);
					// System.out.println(page);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;
			}

		}

		return page;

	}

	public static int getPdfPage(String filepath) {
		int pagecount = 0;
		PdfReader reader = null;
		try {
			reader = new PdfReader(filepath);

			pagecount = reader.getNumberOfPages();
		} catch (Exception e) {
			e.printStackTrace();

			// System.out.println(filepath);
		} finally {
			if (reader != null)
				reader.close();
		}

		return pagecount;
	}

	public static synchronized int getPPTPage(String srcFilePath) {
		ActiveXComponent app2 = null;
		Dispatch ppt = null;
		int page = 0;
		try {
			ComThread.InitMTA(true);
			app2 = new ActiveXComponent("PowerPoint.Application");

			Dispatch ppts = app2.getProperty("Presentations").toDispatch();

			// 因POWER.EXE的发布规则为同步，所以设置为同步发布ReadOnly Untitled指定文件是否有标题
			// WithWindow指定文件是否可见
			ppt = Dispatch.call(ppts, "Open", srcFilePath, true, true, false)
					.toDispatch();

			Dispatch Slides = Dispatch.get(ppt, "Slides").toDispatch();
			page = Integer.parseInt(Dispatch.get(Slides, "Count").toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(srcFilePath);

		} finally {
			if (ppt != null)
				Dispatch.call(ppt, "Close");
			if (app2 != null)
				app2.invoke("Quit");
			ComThread.Release();
		}

		return page;
	}

	public static int getWordPage(String source) {
		Dispatch doc = null;
		ActiveXComponent app = null;
		Integer page = 0;
		try {
			ComThread.InitMTA(true);

			app = new ActiveXComponent("Word.Application");

			app.setProperty("Visible", false);

			Dispatch docs = app.getProperty("Documents").toDispatch();

			doc = Dispatch.call(docs, "Open", source, false, true).toDispatch();

			Dispatch Selection = Dispatch.get(app, "Selection").toDispatch();
			page = Integer.parseInt(Dispatch.call(Selection, "Information", 4)
					.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(source);
		} finally {
			if (doc == null)
				Dispatch.call(doc, "Close", false);
			if (app == null)
				app.invoke("Quit", 0);
			ComThread.Release();
		}

		return page;
	}
}
