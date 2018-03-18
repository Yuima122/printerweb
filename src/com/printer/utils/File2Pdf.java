package com.printer.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class File2Pdf {

	private static final Integer WORD_TO_PDF_OPERAND = 17;
	private static final Integer PPT_TO_PDF_OPERAND = 2;
	public static final Integer SixSlide = 4;
	public static final Integer NineSlide = 9;
	public static final Integer OneSlide = 1;
	public static final Integer TwoSlide = 2;

	public static synchronized void doc2pdf(String srcFilePath,
			String pdfFilePath, int start, int end) throws Exception {
		ActiveXComponent app = null;
		Dispatch doc = null;
		try {
			ComThread.InitSTA();
			app = new ActiveXComponent("Word.Application");

			app.setProperty("Visible", false);
			Dispatch docs = app.getProperty("Documents").toDispatch();
			doc = Dispatch.call(docs, "Open", srcFilePath, false, true)
					.toDispatch();
			// Dispatch.put(doc, "Compatibility", false); //兼容性检查,为特定值false不正确
			Dispatch.put(doc, "RemovePersonalInformation", false);
			Dispatch.call(doc, "ExportAsFixedFormat", pdfFilePath,
					WORD_TO_PDF_OPERAND, false, 0, 3, start, end); // word保存为pdf格式宏，值为17

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (doc != null) {
				Dispatch.call(doc, "Close", false);
			}
			if (app != null) {
				app.invoke("Quit", 0);
			}
			ComThread.Release();
		}
	}

	public static synchronized void ppt2pdf(String srcFilePath,
			String pdfFilePath, int duo, int start, int end) throws Exception {

		ActiveXComponent app = null;
		Dispatch ppt = null;
		try {
			ComThread.InitSTA();
			app = new ActiveXComponent("PowerPoint.Application");

			Dispatch ppts = app.getProperty("Presentations").toDispatch();

			/*
			 * call param 4: ReadOnly param 5: Untitled指定文件是否有标题 param 6:
			 * WithWindow指定文件是否可见
			 */
			ppt = Dispatch.call(ppts, "Open", srcFilePath, true, true, false)
					.toDispatch();
			Dispatch option = Dispatch.get(ppt, "PrintOptions").toDispatch();
			Dispatch ranges = Dispatch.get(option, "Ranges").toDispatch();
			Variant range = Dispatch.call(ranges, "Add", start, end);

			Dispatch.call(ppt, "ExportAsFixedFormat", pdfFilePath,
					PPT_TO_PDF_OPERAND, 2, 0, 2, duo, 0, range, 4); // ppSaveAsPDF为特定值32

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (ppt != null) {
				Dispatch.call(ppt, "Close");
			}
			if (app != null) {
				app.invoke("Quit");
			}
			ComThread.Release();
		}
	}
}
/*
 * Path 必需 String 用于导出的路径。 FixedFormatType 必需 PpFixedFormatType 导出幻灯片时应采用的格式。 意图
 * 可选 PpFixedFormatIntent 导出的目的。 FrameSlides 可选 MsoTriState 要导出的幻灯片是否应当带有边框。
 * HandoutOrder 可选 可读 打印讲义时应遵循的顺序。 输出类型 可选 可读 输出的类型。 PrintHiddenSlides 可选
 * MsoTriState 是否打印隐藏的幻灯片。 PrintRange 可选 PrintRange 幻灯片范围。 RangeType 可选 可读
 * 幻灯片范围的类型。 SlideShowName 可选 String 幻灯片放映的名称。 IncludeDocProperties 可选 Boolean
 * 是否还应导出的文档属性。默认值为False。 KeepIRMSettings 可选 Boolean 是否还应导出 IRM 设置。默认值为True。
 * DocStructureTags 可选 Boolean 是否包括文档结构标记，以改进文档的辅助功能。默认值为True。
 * BitmapMissingFonts 可选 Boolean 是否包含文本的位图。默认值为True。 UseISO19005_1 可选 Boolean
 * 所得到的文档是否符合 ISO 19005 1 (PDF/A)。默认值为False。 ExternalExporter 可选 Variant 一个指向
 * Office 加载项实现IMsoDocExporter COM 接口，并允许对备用实现的代码的调用。默认值是一个空指针。
 */
