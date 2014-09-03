package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.sax.SAXSource;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class JAXBUtils {
	
	private static transient Logger logger = Logger.getLogger(JAXBUtils.class.getName());
	
	private static JAXBContext jaxbContext;
	private static Unmarshaller jaxbUnmarshalle;
	private static Marshaller jaxbMarshaller;
	
	/**
	 * This is used to update the jaxb instance i.e. if you have more then one xml format you need to use
	 * call this class to change the context ... the new context will propagate out to the marshaller and
	 * unmarshaller 
	 * @param packagePath
	 */
	public static void setJAXBContextforNewInstance(String packagePath){
		try{
		jaxbContext = JAXBContext.newInstance(packagePath);
		} catch(Throwable t){
			logger.log(Level.SEVERE,"Exiting Application as Jaxbcontext Could not be loaded due to " + t);
			System.exit(0);
		}
	}
	
	/** 
	 * list of jaxb model classes 
	 * @param modelClass
	 */
	private static void setModelClass(Class<?> ... modelClass){
		try{
		jaxbContext = JAXBContext.newInstance(modelClass);
		} catch(Throwable t){
			logger.log(Level.SEVERE,"Exiting Application as Jaxbcontext Could not be loaded due to " + t);
			System.exit(0);
		}
	}
	
	
	
	public static JAXBContext getJAXBContext(){
		return jaxbContext;
	}
	
	private static Unmarshaller getUnmarshallerFromContext(){
		
		try{
			if(jaxbUnmarshalle == null){
				jaxbUnmarshalle = getJAXBContext().createUnmarshaller();
			}
		} catch(Throwable t){
			logger.log(Level.SEVERE, " there was an issue creating the unmarshaller due to " + t);
		}
			return jaxbUnmarshalle;
		}
	
	private static Marshaller getMarshallerFromContext(){
		
		try{
			if(jaxbMarshaller == null){
				jaxbMarshaller = getJAXBContext().createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			}
		} catch(Throwable t){
			logger.log(Level.SEVERE, " there was an issue creating the marshaller due to " + t);
		}
			return jaxbMarshaller;
		}
	
	
	public static Object getElementFromString(String input, Class<?> modelClass){
		JAXBElement<?> jaxbele = null;
		try {
		SAXSource s = new SAXSource(new InputSource(new StringReader(input)));
		
		jaxbele =  (JAXBElement<?>) getUnmarshallerFromContext().unmarshal(s);
		} catch (Throwable t){
			
		}
		return jaxbele.getValue();
	}
	
	
	public static Object getObjectBySettubgNewInstanceModelClass(String input, Class<?> modelClass){
		Object jaxbele = null;
		try {
		SAXSource s = new SAXSource(new InputSource(new StringReader(input)));
		jaxbele =  getUnmarshallerFromContext().unmarshal(s);
		} catch (Throwable t){
			
		}
		return jaxbele;
	}
	
	
	public static Object getModelClassFromString(String input, Class<?> modelClass){
		JAXBElement<?> jaxbele = null;
		try {
		SAXSource s = new SAXSource(new InputSource(new StringReader(input)));
		jaxbele =  getUnmarshallerFromContext().unmarshal(s, modelClass);
		} catch (Throwable t){
			
		}
		return jaxbele;
	}
	
	
	
	public static Object getElementFromFile(File f){
		Object jaxbele = null;
		try {
			
		       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       dbf.setNamespaceAware(true);
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document doc = db.parse(f);
			
			
		jaxbele =  getUnmarshallerFromContext().unmarshal(doc);
		} catch (Throwable t){
			t.printStackTrace();
		}
		return jaxbele;
	}
	
	
	public static Object getElementFromFile(File f, Class<?> modelClass){
		Object jaxbele = null;
		try {
			jaxbContext = JAXBContext.newInstance(modelClass);
		jaxbele =  getUnmarshallerFromContext().unmarshal(f);
		} catch (Throwable t){
			t.printStackTrace();
		}
		return jaxbele;
	}
	
	
	
	/**
	 * get the object from a input stream
	 * @param input input stream which will be read
	 * @param modelClass api class that you wish to unmarshal the object to
	 * @return
	 */
	public static Object getObjectFromInputStreamJAXB(InputSource input, Class<?> modelClass){
		Object jaxbele = null;
		try {
			javax.xml.transform.Source s = new SAXSource(input);
		jaxbele =  getUnmarshallerFromContext().unmarshal(s);
		} catch (Throwable t){
			
		}
		return jaxbele;
	}
	
	/**
	 * returns the writer used to write the object please note that a default string writer is used
	 * @param jaxbElement
	 * @return
	 */
	public static Writer marshalObjectToStringWriter(JAXBElement<?> jaxbElement , Writer outs ){
		try {
			getMarshallerFromContext().marshal(jaxbElement, outs);
		} catch (Throwable t){
		}
		return outs;
	}
	
	
	public static Writer marshalObjectToFileWriter(JAXBElement<?> jaxbElement, File f ){
		Writer outs = null;
		try {
			 outs = new FileWriter(f);
			getMarshallerFromContext().marshal(jaxbElement, outs);
		} catch (Throwable t){
		}
		return outs;
	}
	
	
	

}
