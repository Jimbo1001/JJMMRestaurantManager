import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.print.*;
import java.io.IOException;
import java.io.StringWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Printer implements Printable {

	String fileText = "";
	
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		String fulltext = "";
		try {
			FileReader fr = new FileReader("C:/Users/Mugdha Yada/Desktop/testfile.txt");
			BufferedReader br = new BufferedReader(fr);
			String buffer;
			while ((buffer = br.readLine()) != null) {
				System.out.println(buffer);
				fulltext += System.lineSeparator() + buffer;
			}
			br.close();
			fr.close();
		} catch (Exception ex) {

		}
		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}

		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());

		int y = 10;
		int lineHeight = 18;
		int maxCharsPerLine = 85;
		for (int line = 0; line < fulltext.length(); line += maxCharsPerLine) {
			y += lineHeight;
			int charsLimit = line + maxCharsPerLine;
			if (charsLimit > fulltext.length()) {
				charsLimit = fulltext.length();
			}
			g.drawString(fulltext.substring(line, charsLimit), 20, y);
		}
		/* Now we perform our rendering */
		/* tell the caller that this page is part of the printed document */
		return PAGE_EXISTS;
	}

	public static PageFormat getPageFormat(PrinterJob pj) {

		PageFormat pf = pj.defaultPage();
		Paper paper = pf.getPaper();

		double middleHeight = 22.0;
		double headerHeight = 2.0;
		double footerHeight = 2.0;
		double width = convert_CM_To_PPI(20); // printer know only point per inch.default value is 72ppi
		double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
		paper.setSize(width, height);
		paper.setImageableArea(0, 10, width, height - convert_CM_To_PPI(1)); // define boarder size after that print
																				// area width is about 180 points

		pf.setOrientation(PageFormat.PORTRAIT); // select orientation portrait or landscape but for this time portrait
		pf.setPaper(paper);

		return pf;
	}

	protected static double convert_CM_To_PPI(double cm) {
		return toPPI(cm * 0.393600787);
	}

	protected static double toPPI(double inch) {
		return inch * 72d;
	}

	public void printFromFilePath(String str) {
		// String filepath = "C:/Users/Mugdha Yada/Desktop/testfile.txt ";
		fileText = "";
		try {
			FileReader fr = new FileReader("C:/Users/Mugdha Yada/Desktop/testfile.txt");
			BufferedReader br = new BufferedReader(fr);
			String buffer;
			while ((buffer = br.readLine()) != null) {
				System.out.println(buffer);
				fileText += System.lineSeparator() + buffer;
			}
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(new Printer(), getPageFormat(job));
			boolean ok = job.printDialog();
			if (ok) {
				try {
					job.print();
				} catch (PrinterException ex) {
					/* The job did not successfully complete */
				}
			}
                
		} catch (Exception ex) {
            
		}
	}

}
