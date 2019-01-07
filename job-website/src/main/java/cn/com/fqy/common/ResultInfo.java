package cn.com.fqy.common;

/**
 * 网络请求接口返回通用
 * @author fqy
 *
 */
public class ResultInfo<T extends Object> {
	
	private String code;//网络请求结果 成功1，失败0
	
	private String msg;//网络请求返回结果信息
	
	private String business_code;//业务状态code值 根据不同业务而定
	
	private T data;//业务数据
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	
}
