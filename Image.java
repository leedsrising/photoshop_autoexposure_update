import java.io.File;

 /* This class stores all data for one image. Each image is created
 * as an object with this class to organize the data easily. 
 */

public class Image {
	
	Util util = new Util();
    private String fileName;
    private String filePath;
    private String xmpPath;
    private String shutterSpeed;
    private int iso;
    private int listNum;
    private int whiteBalance;
    private double ratio;
    private double aperture; 
    private double shutterNum;
    private double exposureOffset;
	
	public Image(String n) {
		fileName = n;
	}
	
	// Initializing image object
	public Image(String n, String folder) {
		listNum = 0;
		fileName = n;
		filePath = folder + "\\" + n;
		exposureOffset = 0;
		
		xmpPath = "";
		xmpPath += folder + "\\" + util.getXMPName(n);
	}
	
	// Initialize object
	public Image(Util util) {
		this.util = util;
		fileName = "";
		ratio = 0;
		listNum = 0;
		exposureOffset = 0;
	}
	
	// Returns string file path
	public String getFilePath() {
		return filePath;
	}
	
	// Returns File object of image file
	public File getFile() {
		return new File(filePath);
	}
	
	// Returns XMP file of image
	public File getXMP() {
		return new File(xmpPath);
	}
	
	// Returns path to XMP file
	public String getDataPath() {
		return xmpPath;
	}
	
	// Returns list number of image in sequence
	public int getListNum() {
		return listNum;
	}
    
    // Returns shutterspeed
	public String getShutterSpeed() {
		return shutterSpeed;
	}
	
	// Calculates double shutter value from fractional value
	public void calcShutterNum() {
		String numS = shutterSpeed.substring(0, shutterSpeed.indexOf('/'));
		String denS = shutterSpeed.substring(numS.length() + 1, shutterSpeed.length());
		
		int num = Integer.parseInt(numS);
		int den = Integer.parseInt(denS);
		shutterNum = ((num + 0.00000000)/den);
	}
	
	// Returns the shutter value as a double
	public double getShutterNum() {
		return shutterNum;
	}
	
	// Returns exposure offset (processed value) as a double
	public double getExposureOffset() {
		return exposureOffset;
	}
    
    // Returns aperture offset (processed value) as a double
	public double getAperture() {
		return aperture;
	}
    
    // Returns ISO offset (processed value) as an int
	public int getISO() {
		return iso;
	}
	
	// Returns white balance value as an int
	public int getWhiteBalance() {
		return whiteBalance;
	}
	
	// Returns name of file as a string
	public String getName() {
		return fileName;
	}
    
    // Returns ratio as a double
	public double getRatio() {
		return ratio;
	}
	
	// Sets the location in image sequence
	public void setListNum(int n) {
		listNum = n;
	}
	
	// Sets name of file
	public void setName(String n) {
		fileName = n;
	}
    
    // Sets shutter speed
	public void setShutterSpeed(String s) {
		shutterSpeed = s;
	}
    
    // Sets aperture
	public void setAperture(double a) {
		aperture = a;
	}
    
    // Sets ISO
	public void setISO(int i) {
		iso = i;
	}
    
    // Sets white balance
	public void setWhiteBalance(int wb) {
		whiteBalance = wb;
	}
    
    // Sets exposure offset
	public void setExposureOffset(double e) {
		exposureOffset = e;
	}
	
	// Prints all information about an image
	public void printInfo() {
		System.out.println("                       ");
        System.out.println("File Path: " + filePath);
        System.out.println("File Name: " + fileName);
		System.out.println("XMP Path: " + xmpPath);
		System.out.println("Shutter Speed: " + shutterSpeed + " [" + shutterNum + "]");
		System.out.println("Aperture: " + aperture);
		System.out.println("ISO: " + iso);
		System.out.println("White Balance: " + whiteBalance);
		System.out.println("                       ");
	}
}
