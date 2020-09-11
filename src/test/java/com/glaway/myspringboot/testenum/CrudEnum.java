package com.glaway.myspringboot.testenum;

/**
 * @filename:       FileAction
 * @copyright:      版权所有 2020-2025 南京国睿信维软件有限公司
 * @version:        V1.0
 * @author:         ZF
 * @createtime:     2020年08月20日17:16
 * @description:   
 *                      
 */
public  enum CrudEnum {
	//增删改查
	CREATE("create",new CreateAction()),
	REDAD("read",new ReadAction()),
	UPDATE("update",new UpdataAction()),
	DELTE("delete",new DelteAction());

	private String actionName;
	private AbstractAction abstractAction;

	//构造方法设值属性值
	CrudEnum(String actionName, AbstractAction abstractAction) {
		this.actionName = actionName;
		this.abstractAction = abstractAction;
	}

	public String getActionName() {
		return actionName;
	}

	public AbstractAction getAbstractAction() {
		return abstractAction;
	}

	/**
	 * @author 			ZF
	 * @date 			2020/8/20
	 * @parameter 		[actionName]
	 * @return 			com.example.test.testenum.CrudEnum
	 * @description
	 *       更具操作名称返回
	 **/
	static CrudEnum of(String actionName) {
		CrudEnum[] values = values();
		for (CrudEnum anEnum : values) {
			if(anEnum.getActionName().equals(actionName)) {
				return anEnum;
			}
		}
		return null;
	}

}
