package com.serv.web.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class MapUtil {
	
	public static Map<String, Object> getParaMap(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, Object> mapRes = (Map<String, Object>)request.getAttribute("map");
		
		if (mapRes == null || mapRes.size() == 0) {
			mapRes = new HashMap<String, Object>();
			Enumeration<String> rnames=request.getParameterNames();
			for (Enumeration<String> e = rnames ; e.hasMoreElements() ;) {
		        String thisName=e.nextElement().toString();
		        String thisValue=request.getParameter(thisName);
		        thisValue = eacapParaAttr(thisValue);
		        mapRes.put(thisName, thisValue);
			}
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
			String str = "";
			String wholeStr = "";
			while((str = reader.readLine()) != null){
				wholeStr += str;
			}
			if(wholeStr.startsWith("{")){
				Map<String, Object> map = JsonUtil.toMap(wholeStr);
				mapRes.putAll(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mapRes;
	}
	
	private static String eacapParaAttr(String strInput) {
		Map<String, String> mapCheck = new HashMap<String, String>();

		mapCheck.put("<", "&lt;");
		mapCheck.put(">", "&gt;");
		mapCheck.put("\"", "&quot;");
		mapCheck.put("\'", "&#39;");
		
		for (String key : mapCheck.keySet()) {
			String strReplaceVal = mapCheck.get(key);
			if (strInput.contains(key)) {
				strInput = strInput.replace(key, strReplaceVal);
			}
		}
		
		return strInput;
	}
}
