/*
Copyright 2015 Cube Reports committer(s)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0
	
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package com.relevantcodes.cubereports;

import com.relevantcodes.cubereports.markup.Configuration;

public class CubeReports {
		private final static CubeReports instance = new CubeReports();
		private static Class<?> clazz;
		private AbstractLog cube;
		private String filePath;
		
		
		//region Public Methods
		
		public static CubeReports get(Class<?> clazz) {
			CubeReports.clazz = clazz;
			return instance;
		}
		
		public void startTest(String testName) {
			cube.startTest(testName);
		}
		
		public void endTest() {
			cube.endTest("");
		}
		
		public void log(LogStatus logStatus, String stepName, String details, String screenCapturePath) {
			cube.log(logStatus, "[" + clazz.getName() + "] " + stepName, details, screenCapturePath);
		}
		
		public void log(LogStatus logStatus, String stepName, String details) {
			log(logStatus, stepName, details, "");
		}
		
		public void setLogLevel(LogLevel logLevel) {
			cube.setLogLevel(logLevel);
		}
		
		public Configuration configure() {
			return Configuration.instance;
		}
		
		public void init(String filePath, Boolean replaceExisting) {
			this.filePath = filePath;
			
			cube = new CubeLog(filePath, replaceExisting);
			configure().params("filePath", filePath);
			performInitialWrite();
		}
		
		
		// region Private Methods
		
		private void performInitialWrite() {
			CubeSource.renewSystemSpecs(filePath);
		}
		
		
		//region Constructor(s)
		private CubeReports() {}
}