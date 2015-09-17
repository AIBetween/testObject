package com.sf.testObject;
/**
 * 
 * 描述：经清洗过的巴枪状态
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           			PERSON          REASON
 *  1    2015年2月26日 下午3:41:33      204401          Create
 * ****************************************************************************
 * </pre>
 * 
 * @author xianyang.yang
 * @since 1.0
 */
public enum BarRecordStatus {
	/**
	 * 推断可信
	 */
    CREDIBLE,
	
	/**
	 * 推断新增
	 */
	ADDED,

	/**
	 * 推断可疑
	 */
	SUSPICIOUS,

	/**
	 * 推断临时
	 */
	TEMP,

    /**
     * 整车可信
     */
    VEHICLE_CREDIBLE,

    /**
     * 单件可信
     */
    INDIVIDUAL_CREDIBLE,

    /**
     * 过程可疑
     */
    PROCESS_SUSPICIOUS,

     /**
     * 广播可疑
     */
    BROADCAST_SUSPICIOUS,

	/**
	 * 升格可信
	 */
	UPGRADE_CREDIBLE,

	/**
	 * 升格可信
	 */
	UPGRADE_ADDED;
	
	public int getStatusValue(){
		return ordinal();
	}

    /**
     * 用于获取中间记录的上记录和下记录的规则，除可疑的数据、过程可疑的数据外，都可以被选取
     * @return
     */
	public boolean isSelectable() {
		return !SUSPICIOUS.equals(this) && !PROCESS_SUSPICIOUS.equals(this) ;
	}

	/**
     * 用于排除中间操作为可疑情况，对在预处理时可能会出现的可以情况进行排除
     * @return
     */
    public boolean isSuspicious() {
        return SUSPICIOUS.equals(this);
    }

    /**
     * 用于排除不保存的状态，过程可疑被定义为一个走过场的状态，不作数据保存
     * @return
     */
	public boolean isNotSave() {
		return PROCESS_SUSPICIOUS.equals(this);
	}

    /**
     * 临时状态，用于进行容器运单关系推断
     * @return
     */
	public boolean isTemp() {
		return TEMP.equals(this);
	}

	/**
	 * 可信状态，用于过滤推断可信和推断新增数据
	 * @return
	 */
	public boolean isCredible() {
		return !SUSPICIOUS.equals(this)
				&& !TEMP.equals(this)
				&& !PROCESS_SUSPICIOUS.equals(this)
				&& !BROADCAST_SUSPICIOUS.equals(this);
	}

	/**
	 * 可用状态，用于过滤对外不可用的数据
	 * @return
	 */
	public boolean isAvailable() {
		return !TEMP.equals(this)
				&& !PROCESS_SUSPICIOUS.equals(this)
				&& !BROADCAST_SUSPICIOUS.equals(this);
	}
	
	/**
	 * 内部路由查询时需要剔除的状态
	 * @return
	 */
	public boolean excludeByInsideRouteQuery() {
		return SUSPICIOUS.equals(this) || TEMP.equals(this)
				|| PROCESS_SUSPICIOUS.equals(this)
				|| BROADCAST_SUSPICIOUS.equals(this);
	}
}
