package SecuGen.FDxSDKPro.samples;


import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;
import SecuGen.FDxSDKPro.jni.*;
import dao.Userdao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DButil;

/**
 *
 * @author  Dan Riley
 */
public class register2 {
    
    /** Creates a new instance of JFPLibTest */
    public register2() {
    }
    
    /**
     * @param args the command line arguments
     */
  // public static void main(String arg[]){
    
        // TODO code application logic here
    public String verif(){
        long err;
        byte kbBuffer[] = new byte[100];
        byte kbWhichFinger[] = new byte[100];
		Scanner scan=new Scanner(System.in);
        int fingerLength = 0;
        String finger = new String("Finger");
        byte[] imageBuffer1;
        byte[] imageBuffer2;
        byte[] SG400minutiaeBuffer1;
        byte[] ANSIminutiaeBuffer1;
        byte[] ISOminutiaeBuffer1; 
        byte[] SG400minutiaeBuffer2;
        byte[] ANSIminutiaeBuffer2;
        byte[] ISOminutiaeBuffer2 = null;
        FileOutputStream fout = null;
        PrintStream fp = null;
        String res="";
        StringBuffer aadhar=new StringBuffer("11223344557");
               
                   
               
        //Initialize fingerprint prompt buffer
        for (int i=0; i < kbWhichFinger.length; ++i)
           kbWhichFinger[i] = 0x00;

        System.out.println("");
        System.out.println("###############################");       
        System.out.println("Registration");
        System.out.println("###############################");
        System.out.println("");
        
        
        ///////////////////////////////////////////////
        // Instantiate JSGFPLib object
        System.out.println("Instantiate JSGFPLib Object");
        JSGFPLib sgfplib = new JSGFPLib();
        if ((sgfplib != null) && (sgfplib.jniLoadStatus != SGFDxErrorCode.SGFDX_ERROR_JNI_DLLLOAD_FAILED))
        {
            System.out.println(sgfplib);
        }
        else
        {
            System.out.println("An error occurred while loading JSGFPLIB.DLL JNI Wrapper");
         //   return;
        }

        ///////////////////////////////////////////////
        // Init()
        System.out.println("Call Init(SGFDxDeviceName.SG_DEV_AUTO)");
        err = sgfplib.Init(SGFDxDeviceName.SG_DEV_AUTO);
        System.out.println("Init returned : [" + err + "]");

        ///////////////////////////////////////////////
        // GetLastError()
        System.out.println("Call GetLastError()");
        err = sgfplib.GetLastError();
        System.out.println("Last error returned : [" + err + "]");

        ///////////////////////////////////////////////
        // GetMinexVersion()
        int[] extractorVersion = new int[1];
        int[] matcherVersion = new int[1];
        System.out.println("Call GetMinexVersion()");
        err = sgfplib.GetMinexVersion(
        		extractorVersion, matcherVersion);
        System.out.println("GetMinexVersion returned : [" + err + "]");
        System.out.println("Extractor version : [" + extractorVersion[0] + "]");
        System.out.println("Matcher version : [" + matcherVersion[0] + "]");
        
        ///////////////////////////////////////////////
        // OpenDevice()
        System.out.println("Call OpenDevice(SGPPPortAddr.AUTO_DETECT)");
        err = sgfplib.OpenDevice(SGPPPortAddr.AUTO_DETECT);
        System.out.println("OpenDevice returned : [" + err + "]");

        ///////////////////////////////////////////////
        // GetError()
        System.out.println("Call GetLastError()");
        err = sgfplib.GetLastError();
        System.out.println("GetLastError returned : [" + err + "]");

        ///////////////////////////////////////////////
        // GetDeviceInfo()
        System.out.println("Call GetDeviceInfo()");
        SGDeviceInfoParam deviceInfo = new SGDeviceInfoParam();
        err = sgfplib.GetDeviceInfo(deviceInfo);
        System.out.println( "GetDeviceInfo returned : [" + err + "]");
        System.out.println("\tdeviceInfo.DeviceSN:    [" + new String(deviceInfo.deviceSN()) + "]");
        System.out.println("\tdeviceInfo.Brightness:  [" + deviceInfo.brightness + "]");
        System.out.println("\tdeviceInfo.ComPort:     [" + deviceInfo.comPort + "]");
        System.out.println("\tdeviceInfo.ComSpeed:    [" + deviceInfo.comSpeed + "]");
        System.out.println("\tdeviceInfo.Contrast:    [" + deviceInfo.contrast + "]");
        System.out.println("\tdeviceInfo.DeviceID:    [" + deviceInfo.deviceID + "]");
        System.out.println("\tdeviceInfo.FWVersion:   [" + deviceInfo.FWVersion + "]");
        System.out.println("\tdeviceInfo.Gain:        [" + deviceInfo.gain + "]");
        System.out.println("\tdeviceInfo.ImageDPI:    [" + deviceInfo.imageDPI + "]");
        System.out.println("\tdeviceInfo.ImageHeight: [" + deviceInfo.imageHeight + "]");
        System.out.println("\tdeviceInfo.ImageWidth:  [" + deviceInfo.imageWidth + "]");
        
        ///////////////////////////////////////////////
        // SetLedOn(true)
        /*System.out.print("Press <Enter> to turn fingerprint sensor LEDs on >> ");
        try
        {
            System.in.read(kbBuffer);
            System.out.println("Call SetLedOn(true)");
            err = sgfplib.SetLedOn(true);
            System.out.println("SetLedOn returned : [" + err + "]");
        }
        catch (IOException e)
        {
            System.out.println("Exception reading keyboard : " + e);
        }

        ///////////////////////////////////////////////
        // SetLedOn(false)
        System.out.println("Fingerprint Sensor LEDS should now be illuminated.");
        System.out.print("Press <Enter> to turn fingerprint sensor LEDs off >> ");
        try
        {
            System.in.read(kbBuffer);
            System.out.println("Call SetLedOn(false)");
            err = sgfplib.SetLedOn(false);
            System.out.println("SetLedOn returned : [" + err + "]");
        }
        catch (IOException e)
        {
            System.out.println("Exception reading keyboard : " + e);
        }

        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
		System.out.println("Enter the number of fingers to register");
		
        System.out.println("Fingerprint Sensor LEDS should now be off.");
		
        
	*/	
       /* System.out.print("Which finger would you like to test with? (e.g. left thumb) >> ");
        try
        {
            System.in.read(kbWhichFinger);
            //Remove CR/NL (<ENTER>)
            for (int i=0; i < kbWhichFinger.length; ++i)
            {
                if ((kbWhichFinger[i] == 0x0A) || (kbWhichFinger[i] == 0x0D)|| (kbWhichFinger[i] == 0x00))
                {
                    fingerLength = i;
                    break;
                }
            }
            if (fingerLength > 0)
                finger = new String(kbWhichFinger,0,fingerLength);
            else finger = new String("finger");
        }
        catch (IOException e)
        {
            System.out.println("Exception reading keyboard : " + e);
        }

*/
        int[] quality = new int[1];
        int[] maxSize = new int[1];
        int[] size = new int[1];
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImageQuality = quality[0];
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;



//////////////////////////////////////////////////////////////////////////////
// Finger 1
        ///////////////////////////////////////////////
        // getImage() - 1st Capture
        System.out.println("Call SetLedOn(true)");
        err =sgfplib.SetLedOn(true);
        System.out.println("SetLedOn returned : [" + err + "]");
        System.out.print("Capture 1. Please place [" + finger + "] on sensor with LEDs on and press <ENTER> ");
        imageBuffer1 = new byte[deviceInfo.imageHeight*deviceInfo.imageWidth];
        try
        {
            System.in.read(kbBuffer);
            System.out.println("Call GetImage()");
            err = sgfplib.GetImage(imageBuffer1);
            System.out.println("GetImage returned : [" + err + "]");
            if (err == SGFDxErrorCode.SGFDX_ERROR_NONE)
            {
                err = sgfplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer1, quality);
                System.out.println("GetImageQuality returned : [" + err + "]");
                System.out.println("Image Quality"
                        + " is : [" + quality[0] + "]");
                fout = new FileOutputStream("G:\\backupversion0.3\\Store\\"+finger + ".raw");
                fp = new PrintStream(fout);
                fp.write(imageBuffer1,0, imageBuffer1.length);
                fp.close();
                fout.close();
                fp = null;
                fout = null;
            }
            else
            {
                System.out.println("ERROR: Fingerprint image capture failed for sample1.");
                //return; //Cannot continue test if image not captured
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception reading keyboard : " + e);
        }

        ///////////////////////////////////////////////
        // Set Template format SG400
        System.out.println("Call SetTemplateFormat(SG400)");
        err = sgfplib.SetTemplateFormat(SGFDxTemplateFormat.TEMPLATE_FORMAT_SG400);
        System.out.println("SetTemplateFormat returned : [" + err + "]");

        ///////////////////////////////////////////////
        // Get Max Template Size for SG400
        System.out.println("Call GetMaxTemplateSize()");
        err = sgfplib.GetMaxTemplateSize(maxSize);
        System.out.println("GetMaxTemplateSize returned : [" + err + "]");
        System.out.println("Max SG400 Template Size is : [" + maxSize[0] + "]");

        ///////////////////////////////////////////////
        // Greate SG400 Template for Finger 1
        SG400minutiaeBuffer1 = new byte[maxSize[0]];
        System.out.println("Call CreateTemplate()");
        err = sgfplib.CreateTemplate(fingerInfo, imageBuffer1, SG400minutiaeBuffer1);
        System.out.println("CreateTemplate returned : [" + err + "]");
        err = sgfplib.GetTemplateSize(SG400minutiaeBuffer1, size);
        System.out.println("GetTemplateSize returned : [" + err + "]");
        System.out.println("SG400 Template Size is : [" + size[0] + "]");
        try
        {
            if (err == SGFDxErrorCode.SGFDX_ERROR_NONE)
            {
                fout = new FileOutputStream("G:\\backupversion0.3\\Store\\"+finger +".sg400");
                fp = new PrintStream(fout);
                fp.write(SG400minutiaeBuffer1,0, size[0]);
                fp.close();
                fout.close();
                fp = null;
                fout = null;
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception writing minutiae file : " + e);
        }

        ///////////////////////////////////////////////
        // Set Template format ANSI378
        System.out.println("Call SetTemplateFormat(ANSI378)");
        err = sgfplib.SetTemplateFormat(SGFDxTemplateFormat.TEMPLATE_FORMAT_ANSI378);
        System.out.println("SetTemplateFormat returned : [" + err + "]");

        ///////////////////////////////////////////////
        // Get Max Template Size for ANSI378
        System.out.println("Call GetMaxTemplateSize()");
        err = sgfplib.GetMaxTemplateSize(maxSize);
        System.out.println("GetMaxTemplateSize returned : [" + err + "]");
        System.out.println("Max ANSI378 Template Size is : [" + maxSize[0] + "]");

        ///////////////////////////////////////////////
        // Greate ANSI378 Template for Finger1
        ANSIminutiaeBuffer1 = new byte[maxSize[0]];
        System.out.println("Call CreateTemplate()");
        err = sgfplib.CreateTemplate(fingerInfo, imageBuffer1, ANSIminutiaeBuffer1);
        System.out.println("CreateTemplate returned : [" + err + "]");
        err = sgfplib.GetTemplateSize(ANSIminutiaeBuffer1, size);
        System.out.println("GetTemplateSize returned : [" + err + "]");
        System.out.println("ANSI378 Template Size is : [" + size[0] + "]");
        try
        {
            if (err == SGFDxErrorCode.SGFDX_ERROR_NONE)
            {
                fout = new FileOutputStream("G:\\backupversion0.3\\Store\\"+finger +".ansi378");
                fp = new PrintStream(fout);
                fp.write(ANSIminutiaeBuffer1,0, size[0]);
                fp.close();
                fout.close();
                fp = null;
                fout = null;
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception writing minutiae file : " + e);
        }

        ///////////////////////////////////////////////
        // Set Template format ISO19794
        System.out.println("Call SetTemplateFormat(ISO19794)");
        err = sgfplib.SetTemplateFormat(SGFDxTemplateFormat.TEMPLATE_FORMAT_ISO19794);
        System.out.println("SetTemplateFormat returned : [" + err + "]");

        ///////////////////////////////////////////////
        // Get Max Template Size for ISO19794
        System.out.println("Call GetMaxTemplateSize()");
        err = sgfplib.GetMaxTemplateSize(maxSize);
        System.out.println("GetMaxTemplateSize returned : [" + err + "]");
        System.out.println("Max ISO19794 Template Size is : [" + maxSize[0] + "]");

        ///////////////////////////////////////////////
        // Greate ISO19794 Template for Finger1
        ISOminutiaeBuffer1 = new byte[maxSize[0]];
        System.out.println("Call CreateTemplate()");
        err = sgfplib.CreateTemplate(fingerInfo, imageBuffer1, ISOminutiaeBuffer1);
        System.out.println("CreateTemplate returned : [" + err + "]");
        err = sgfplib.GetTemplateSize(ISOminutiaeBuffer1, size);
        System.out.println("GetTemplateSize returned : [" + err + "]");
        System.out.println("ISO19794 Template Size is : [" + size[0] + "]");
        try
        {
            if (err == SGFDxErrorCode.SGFDX_ERROR_NONE)
            {
                fout = new FileOutputStream("G:\\backupversion0.3\\Store\\"+finger +".iso19794");
                fp = new PrintStream(fout);
                fp.write(ISOminutiaeBuffer1,0, size[0]);
                fp.close();
                fout.close();
                fp = null;
                fout = null;
            }
        }
        catch (IOException e)
        {
            System.out.println("Exception writing minutiae file : " + e);
        }
		
      
    for(int j=0;j<10;j++){
        try {
        	File file = new File("G:\\backupversion0.3\\Store\\11223344557"+j+".iso19794") ;        	
            ISOminutiaeBuffer2=new byte[(int)file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(ISOminutiaeBuffer2);
            fileInputStream.close();
        } catch (IOException ex){
            System.out.println(ex);
      //  	return; 
        }
				///////////////////////////////
				
				///////////////////////////////////
				boolean[] matched = new boolean[1];
        int[] score = new int[1];
        //Match ISO19794 Templates
        System.out.println("Matching.......");
        matched[0] = false;
        score[0] = 0;
        String id="d";
        //System.out.println("Call SetTemplateFormat(ISO19794)");
        err = sgfplib.SetTemplateFormat(SGFDxTemplateFormat.TEMPLATE_FORMAT_ISO19794);
        //System.out.println("SetTemplateFormat returned : [" + err + "]");
        //System.out.println("Call MatchIsoTemplates()");
        err = sgfplib.MatchIsoTemplate(ISOminutiaeBuffer1, 0, ISOminutiaeBuffer2, 0, SGFDxSecurityLevel.SL_NORMAL, matched);
        //System.out.println("MatchISOTemplates returned : [" + err + "]");
        //System.out.println("ISO-1 <> ISO-2 Match Result : [" + matched[0] + "]");
    
        //System.out.println("Call GetIsoMatchingScore()");
        err = sgfplib.GetIsoMatchingScore(ISOminutiaeBuffer1, 0, ISOminutiaeBuffer2, 0, score);
        //System.out.println("GetIsoMatchingScore returned : [" + err + "]");
        //System.out.println("ISO-1  <> ISO-2 Match Score : [" + score[0] + "]");
        if(matched[0])
        {  System.out.println(j);
            aadhar.append(j);
           // Connection con=DButil.getDbconnection();
       
        	break;
        }
        else
        {
        	continue;
        }

    }


   
          
          
/////////////////
return aadhar.toString();    
    }
        
    }   


