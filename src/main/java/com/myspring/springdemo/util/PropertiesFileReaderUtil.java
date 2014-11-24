package com.myspring.springdemo.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.myspring.springdemo.exception.SpringDemoException;

public class PropertiesFileReaderUtil {

	private static final Logger logger = Logger
			.getLogger(PropertiesFileReaderUtil.class);
	private static Properties properties = System.getProperties();

	/**
	 * Method to get property value
	 * 
	 * @param key
	 *            key in the property file
	 * @return value corresponding to the passed key
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key).trim();
	}

	public static String getPropertyValue(String key) {
		try {
			properties.load(PropertiesFileReaderUtil.class.getClassLoader()
					.getResourceAsStream("properties/message.properties"));
		} catch (FileNotFoundException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		} catch (IOException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		}
		return properties.getProperty(key) != null ? properties
				.getProperty(key).trim() : "";
	}

	/*
	 * Get property values for Email
	 */

	public static String getEmailProperty(String key) {
		try {
			properties.load(PropertiesFileReaderUtil.class.getClassLoader()
					.getResourceAsStream("properties/mail.properties"));
		} catch (FileNotFoundException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		} catch (IOException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		}
		return properties.getProperty(key) != null ? properties
				.getProperty(key).trim() : "";
	}

	/*
	 * Get property value for velocity templates
	 */
	public static String getVelocityTemplateProperties(String key) {
		try {
			properties
					.load(PropertiesFileReaderUtil.class.getClassLoader()
							.getResourceAsStream(
									"properties/velocity-email.properties"));
		} catch (FileNotFoundException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		} catch (IOException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		}
		return properties.getProperty(key) != null ? properties
				.getProperty(key).trim() : "";
	}

	public static String getApplicationProperty(String key) {
		try {

			String OS = System.getProperty("os.name").toLowerCase();
			if (OS.indexOf("win") >= 0) {
				properties.load(PropertiesFileReaderUtil.class.getClassLoader()
						.getResourceAsStream(
								"properties/application.properties"));
			} else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0
					|| OS.indexOf("aix") > 0) {
				properties.load(PropertiesFileReaderUtil.class.getClassLoader()
						.getResourceAsStream(
								"properties/application_unix.properties"));
			}
		} catch (FileNotFoundException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		} catch (IOException e) {
			logger.fatal(FrontFlipUtil.getExceptionDescriptionString(e));
			throw new SpringDemoException();
		}
		return properties.getProperty(key) != null ? properties
				.getProperty(key).trim() : "";
	}



}
