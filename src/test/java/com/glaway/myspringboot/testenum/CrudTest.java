package com.glaway.myspringboot.testenum;

/**
 * @filename:       CrudTest
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         ZF
 * @createtime:     2020年08月20日17:37
 * @description:   
 *                      
 */
public class CrudTest {

	public static void main(String[] args) {
		String actionName = "create";
		testEnum(actionName);
		testIf(actionName);
	}

	public static void testEnum(String actionName) {
		CrudEnum crudEnum = CrudEnum.of(actionName);
		if(crudEnum != null){
			crudEnum.getAbstractAction().doAction();
		}
	}

	public static void testIf(String actionName) {
		if("create".equals(actionName)) {
			new CreateAction().doAction();
		} else if("read".equals(actionName)) {
			new ReadAction().doAction();
		} else if("delete".equals(actionName)) {
			new DelteAction().doAction();
		} else if("update".equals(actionName)) {
			new UpdataAction().doAction();
		}
	}
    
}
