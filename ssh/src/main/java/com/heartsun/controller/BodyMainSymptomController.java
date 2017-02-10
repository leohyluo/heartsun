package com.heartsun.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heartsun.entity.BodyMainSymptom;
import com.heartsun.service.IBodyMainSymptomService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/bodyMainSymptom")
public class BodyMainSymptomController extends AbstractController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private IBodyMainSymptomService bodyMainSymptomService; 

	@RequestMapping(value = "queryAll", method = RequestMethod.POST)
	@ResponseBody
	public String query(BodyMainSymptom param) throws Exception {
		List<BodyMainSymptom> list = bodyMainSymptomService.get(param);
		logger.info("BodyMainSymptom size = " + list.size());
		
		String result = parse(list).toString();
		return result;
	}
	
	@RequestMapping(value = "queryByBody", method = RequestMethod.POST)
	@ResponseBody
	public String query(String bodyId) {
		List<BodyMainSymptom> list = bodyMainSymptomService.queryByBody(bodyId);
		logger.info("BodyMainSymptom size = " + list.size());
		
		String result = parse(list).toString();
		return result;
	}
	
	private JSONArray parse(List<BodyMainSymptom> list) {
		Map<String, List<String>> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		Map<String, String> map3 = new HashMap<>();
		
		for(BodyMainSymptom item : list) {
			String bodyId = item.getBody().getId().toString();
			String bodyName = item.getBody().getName();
			String mainSymptomId = item.getMainSymptom().getId().toString();
			String mainSymptomName = item.getMainSymptom().getName();
			
			if(!map1.containsKey(bodyId)) {
				List<String> symptomList = new ArrayList<>();
				map1.put(bodyId, symptomList);
			}
			map1.get(bodyId).add(mainSymptomId);
			map2.put(bodyId, bodyName);
			map3.put(mainSymptomId, mainSymptomName);
		}
		JSONArray jarr = new JSONArray();
		for(String bodyId : map1.keySet()) {
			JSONObject item = new JSONObject();
			item.put("bodyId", bodyId);
			item.put("bodyName", map2.get(bodyId));
			
			List<String> symptomList = map1.get(bodyId);
			JSONArray symptomArr = new JSONArray();
			for(String symptomId : symptomList) {
				String symptomName = map3.get(symptomId);
				
				JSONObject itemSymptom = new JSONObject();
				itemSymptom.put("mainId", symptomId);
				itemSymptom.put("mainName", symptomName);
				symptomArr.add(itemSymptom);
			}
			item.put("mainSymptoms", symptomArr);
			jarr.add(item);
		}
		return jarr;
	}
}
