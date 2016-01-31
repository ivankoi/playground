package ec.rea.mcat2.promis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class RrrFellowshipStartDateExtractor {
	
	private HarvesterRrs harvester;
	private FellowshipInfo fellowShipInfo;
	
	public RrrFellowshipStartDateExtractor(HarvesterRrs harvester) {
		this.harvester = harvester;
	}

	public static void main(String[] args) throws IOException {
		HarvesterRrs harvester = new HarvesterRrs();
                
		RrrFellowshipStartDateExtractor extractor = new RrrFellowshipStartDateExtractor(harvester);
		extractor.extract();
                
	}

	private void extract() throws IOException {
		Files.walkFileTree(Paths.get("C:\\Data\\ivankiv\\Projects\\Promis\\old\\single submission\\cofund\\RRRs"), harvester);
		System.out.println(harvester.getFilePaths());
		
		for (Path pdfFilePath : harvester.getFilePaths()) {
			PDFTextStripper stripper = new PDFTextStripper();
			
			PDFParser parser = new PDFParser(new FileInputStream(pdfFilePath.toFile()));
			parser.parse();
			PDDocument document =  parser.getPDDocument();
			String text = stripper.getText(document);
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println(text);
			System.out.println("---------------------------------------------------------------------------------");
		}		
	}
	
	
	private static class HarvesterRrs extends SimpleFileVisitor<Path> {
                
		private List<Path> filePaths = new ArrayList<Path>();
		
		
		public HarvesterRrs() {}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			filePaths.add(file);
                        Math.sqrt(3);
                        Assert.assertEquals("sd","sdf");
                        
			return FileVisitResult.CONTINUE;
		}

		public List<Path> getFilePaths() {
			return filePaths;
		}
		
	}
	
	private static class FellowshipInfo {
            
	}
}
