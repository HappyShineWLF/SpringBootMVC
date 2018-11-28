/**
 * 
 */
package com.wlf.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlf.mapper.TelMapper;
import com.wlf.pojo.Tel;
import com.wlf.service.TelService;

/**
 * @author wlf
 *
 */
@Service
@Transactional
public class TelServiceImpl implements TelService {

	@Autowired
	private TelMapper telMapper;

	@Override
	public List<Tel> selectTel(String num) {
		List<Tel> listEnd = new ArrayList<Tel>();
		int index = 1;
		List<Tel> list = null;
		switch(num){
		case "6":
			list = telMapper.selectTel();//;
		    break;
		case "7":
			list = telMapper.selectTel7();//;
		    break;
		case "8":
			list = telMapper.selectTel8();//;
		    break;
		case "9":
			list = telMapper.selectTel9();//;
		    break;
		case "10":
			list = telMapper.selectTel10();//;
		    break;
		case "11":
			list = telMapper.selectTel11();//;
		    break;
		case "12":
			list = telMapper.selectTel12();//;
		    break;
		case "13":
			list = telMapper.selectTel13();//;
		    break;
		default:
		    break;
		}
		Tel t1 = list.get(0);

		String section = "";
		for (int i = 1; i < list.size(); i++) {
			Tel t2 = list.get(i);
			for (int k = 1; k <= 10; k++) {
				section = getMethod(t1, "getSection" + k);

				String sectionNumber = getMethod(t2, "getSection" + k);
				if (null != sectionNumber && !"".equals(sectionNumber)) {
					if (sectionNumber.split("、").length > 1) {
						String sectionNumberTmp;
						for (int s = 0; s < sectionNumber.split("、").length; s++) {
							sectionNumberTmp = sectionNumber.split("、")[s];
							if (sectionNumberTmp.split("-").length > 1) {
								String startString = sectionNumberTmp.split("-")[0];
								String endString = sectionNumberTmp.split("-")[1];
								int start = Integer.parseInt(startString);
								int end = Integer.parseInt(endString);
								System.out.println(section + "---" + start + "---" + end);
								for (int j = start; j <= end; j++) {
									Tel t5 = new Tel();
									t5.setId(index++);
									t5.setNumber1(section + "" + autoGenericCode(j, 3));
									t5.setCity(t2.getCity());
									t5.setCode("0" + t2.getCode());
									t5.setProvince(t2.getProvince());
									t5.setSection1("(" + section + ")" + sectionNumber);
									listEnd.add(t5);
								}
							} else {
								Tel t4 = new Tel();
								t4.setId(index++);
								t4.setNumber1(section + sectionNumberTmp);
								t4.setCity(t2.getCity());
								t4.setCode("0" + t2.getCode());
								t4.setProvince(t2.getProvince());
								t4.setSection1("(" + section + ")" + sectionNumber);
								listEnd.add(t4);
							}
						}

					} else {
						if (sectionNumber.split("-").length > 1) {
							int start = Integer.parseInt(sectionNumber.split("-")[0]);
							int end = Integer.parseInt(sectionNumber.split("-")[1]);
							System.out.println(section + "--------" + start + "-------" + end);
							for (int j = start; j <= end; j++) {
								Tel t3 = new Tel();
								t3.setId(index++);
								t3.setNumber1(section + "" + autoGenericCode(j, 3));
								t3.setCity(t2.getCity());
								t3.setCode("0" + t2.getCode());
								t3.setProvince(t2.getProvince());
								t3.setSection1("(" + section + ")" + sectionNumber);
								listEnd.add(t3);
							}
						} else {
							Tel t4 = new Tel();
							t4.setId(index++);
							t4.setNumber1(section+sectionNumber);
							t4.setCity(t2.getCity());
							t4.setCode("0" + t2.getCode());
							t4.setProvince(t2.getProvince());
							t4.setSection1("(" + section + ")" + sectionNumber);
							listEnd.add(t4);
						}

					}
				}

			}

		}
		System.out.println("总记录：" + listEnd.size());
		return listEnd;
	}

	public String getMethod(Tel tel, String methodName) {
		String value = "";
		try {
			Method m = tel.getClass().getMethod(methodName);
			try {
				value = (String) m.invoke(tel);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 不够位数的在前面补0，保留num的长度位数字
	 * 
	 * @param code
	 * @return
	 */
	private String autoGenericCode(int value, int length) {
		String result = "";
		// 保留num的位数
		// num 代表长度为4
		// d 代表参数为正数型
		// 0 代表前面补充0
		result = String.format("%0" + length + "d", value);

		return result;
	}

}
