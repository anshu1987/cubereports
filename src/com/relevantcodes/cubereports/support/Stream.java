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


package com.relevantcodes.cubereports.support;

public class Stream {
	@SuppressWarnings("resource")
	public static String toString(java.io.InputStream is) {
	    java.util.Scanner scanner = new java.util.Scanner(is).useDelimiter("\\A");
	    return scanner.hasNext() ? scanner.next() : "";
	}	
}
