package com.serv.web.tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

public class JsonUtil {
//	private final static Logger logger = Logger.getLogger(JsonUtil.class);

	// 当前json格式字符串格式是否良好
	public static boolean isJSON(String jsonString) {
		return JSONUtils.mayBeJSON(jsonString);
	}

	public static String map2jsonStr(Map<String, Object> map){
		String res = "";
		if (map == null || map.size() == 0) {
			return res;
		}
		JSONObject jsonObj = JSONObject.fromObject(map);
		res = jsonObj.toString();
		return res;
	}
	
	// 将json格式的字符串转成为Map对象
	public static Map<String, Object> toMap(String jsonString) {
		return toMap(toJSONObject(jsonString));
	}

	// 将JSON对象转换成Map对象
	public static Map<String, Object> toMap(JSONObject jsonObject) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		Iterator<String> keys = jsonObject.keys();
		while (keys.hasNext()) {
			String key = keys.next().toString();
			Object value = jsonObject.get(key);
			if (value == null) {
				continue;
			}
			if(value instanceof JSONNull) {
				continue;
			} else if(value instanceof JSONObject) {
				if(((JSONObject)value).isNullObject()) {
					continue;
				}
				if(((JSONObject)value).isEmpty()) { 
					continue;
				}
			} else if(value instanceof JSONArray) {
				if(((JSONArray)value).isEmpty()) {
					continue;
				}
			}
			if (value instanceof Number) {
				map.put(key, value.toString());
			} else {
				map.put(key, value);
			}
		}
		return map;
	}

	// 将JSON数组转换成Java集合对象
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Object> toList(Object object, Class objectClass) {
		if (object instanceof JSONArray) {
			return (List<Object>) JSONArray.toCollection((JSONArray) object, objectClass);
		} else {
//			logger.warn("The object is not a instance of JSONArray");
			return null;
		}
	}

	// 将JSON格式的字符串转成JSON数组
	public static JSONArray toJSONArray(String jsonString) {
		return JSONArray.fromObject(jsonString);
	}

	// 将JSON格式的字符串转成JSON数组
	public static JSONArray toJSONArray(Object obj) {
		return JSONArray.fromObject(obj);
	}
	
	// 将JSON格式的字符串转成JSON对象
	public static JSONObject toJSONObject(String jsonString) {
		return JSONObject.fromObject(jsonString);
	}


	// 将JSON对象转换成Java对象
	public static Object toJava(JSON json) {
		return JSONSerializer.toJava(json);
	}

	// 将JSON对象转换成Java对象，按指定配置转换
	public static Object toJava(JSON json, JsonConfig jsonConfig) {
		return JSONSerializer.toJava(json, jsonConfig);
	}

	// 将Java对象转换成JSON对象
	public static JSONObject toJSONObject(Object object) {
		JsonConfig jsonConfig = new JsonConfig();
		return (JSONObject) JSONSerializer.toJSON(object, jsonConfig);
	}
}
