package com.semanticssquare.thrillio.util;


public class HttpConnect {	
	
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
		System.out.println("Downloading: " + sourceUrl);
		URL url = new URI(sourceUrl).toURL();		
		
		try {
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();	
			
			if(responseCode >= 200 && responseCode < 300) { // ok
				return IOUtil.read(con.getInputStream());		        
			}
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
