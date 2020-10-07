//package testobjects;
//
//import java.io.File;
//
//import org.sikuli.script.Match;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;
//import static utilities.reporting.Reporting.//create_logs_and_report;
//public class Sikulixutilities {
//	
//	
//	
//    public static String inputFilePath = System.getProperty("user.dir") +File.separator + "snapshots";
//
//    // Method used for clicking on element using the image
//    public static void clickUsingSnapshots(String screenshotname) {
//        try {
//            Screen s = new Screen();
//            System.out.println(inputFilePath + File.separator +screenshotname);
//            Pattern p = new Pattern(inputFilePath + File.separator +screenshotname);
//            s.click(p);
//            //create_logs_and_report("Clicked " + screenshotname + " using snapshot", "pass");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            //create_logs_and_report("Not able to click " + screenshotname +" using snapshot", "fail");
//        }
//    }
//    
//    //Method used for double clicking on element using the image
//    public static void doubleclickUsingSnapshots(String screenshotname) throws
//    Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p = new
//            Pattern(inputFilePath + File.separator + screenshotname);
//            s.doubleClick(p);
//            //create_logs_and_report("Double clicked " + screenshotname + " using snapshot","pass");
//        } catch (Exception e) {
//            //create_logs_and_report("Not able to Double clicked " +screenshotname + " using snapshot", "fail");
//        }
//    }
//
//    //Method used for typing on element using the image
//    public static void typeUsingSnapshots(String screenshotname, String text)
//    throws Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p = new
//            Pattern(inputFilePath + File.separator + screenshotname);
//            s.type(p, text);
//            //create_logs_and_report("Typed " + text + " in " + screenshotname + " using sanpshot","pass");
//        } catch (Exception e) {
//            //create_logs_and_report("Not able to type " + text + " in " +screenshotname + " using sanpshot", "fail");
//        }
//    }
//    
//    //Method used for hovering over specific element using the image
//    public static void hoverUsingSnapshots(String screenshotname) throws
//    Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p = new
//            Pattern(inputFilePath + File.separator + screenshotname);
//            s.hover(p);
//            //create_logs_and_report("Hovered over " + screenshotname + " using sanpshot","pass");
//        } catch (Exception e) {
//            //create_logs_and_report("Not able to hover over " +screenshotname + " using sanpshot", "fail");
//        }
//    }
//
//    //Method used for finding an element using image it returns boolean values
//    public static boolean findUsingSnapshots(String screenshotname) throws
//    Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p = new
//            Pattern(inputFilePath + File.separator + screenshotname);
//            Match x = s.find(p);
//            if (x != null) {
//                //create_logs_and_report("Found " + screenshotname + " using snapshot", "pass");
//                return true;
//            } else {
//                //create_logs_and_report("Not able to find " + screenshotname + " using snapshot","fail");
//                return false;
//            }
//        } catch (Exception e) {
//            //create_logs_and_report("Not able to find " + screenshotname + " using snapshot","fail");
//            return false;
//        }
//    }
//
//    //used to extract the  text on the screen using the image
//    public static String findtextUsingSnapshots(String screenshotname) throws
//    Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p = new
//            Pattern(inputFilePath + File.separator + screenshotname);
//            //create_logs_and_report("Found " + screenshotname + " using snapshot", "pass");
//            return s.find(p).text();
//        } catch (Exception e) {
//            //create_logs_and_report("Not able to find " + screenshotname + " using snapshot","fail");
//            return "error";
//        }
//    }
//    
//   //used to perform drag and drop action from one place to another using the images
//    public static void draganddropUsingSnapshots(String image1, String image2)
//    throws Exception {
//        try {
//            Screen s = new Screen();
//            Pattern p1 = new
//            Pattern(inputFilePath + File.separator + image1);
//            Pattern p2 = new
//            Pattern(inputFilePath + File.separator + image2);
//            s.dragDrop(p1, p2);
////            //create_logs_and_report("Dragged and dropped from " + image1 + " to " +image2 + " using snapshot", "pass");
//        } catch (Exception e) {
////            //create_logs_and_report("Not able to drag and drop from " + image1 + " to " + image2 + " using snapshot", "fail");
//        }
//    }
//
//
//
//}