package com.sports.life.utils;


import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.exception.code.ResponseCodeInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DataResult<T> {
     /**
       * 请求响应code，0为成功 其他为失败
       */
     @ApiModelProperty(value = "请求响应code，0为成功 其他为失败", name = "code")
     private int code = 0;
     /**
       * 响应异常码详细信息
       */
      @ApiModelProperty(value = "响应异常码详细信息", name = "msg")
     private String msg;
     /**
       * 响应内容 ， code 0 时为 返回 数据
       */
     @ApiModelProperty(value = "需要返回的数据", name = "data")
     private T data;

    /**
     * 构造方法
     * @param code
     * @param data
     */
    public DataResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public DataResult(int code, T data) {
        this.code = code;
        this.data = data;
        this.msg=null;
    }

    public DataResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public DataResult() {
         this.code= BaseResponseCode.SUCCESS.getCode();
         this.msg=BaseResponseCode.SUCCESS.getMsg();
         this.data=null;
     }
     //泛型定义参数
    public DataResult(T data) {
         this.data = data;
         this.code= BaseResponseCode.SUCCESS.getCode();
         this.msg=BaseResponseCode.SUCCESS.getMsg();
  }
    public DataResult(ResponseCodeInterface responseCodeInterface) {
         this.data = null;
         this.code = responseCodeInterface.getCode();
         this.msg = responseCodeInterface.getMsg();
  }
    public DataResult(ResponseCodeInterface responseCodeInterface, T data) {
         this.data = data;
         this.code = responseCodeInterface.getCode();
         this.msg = responseCodeInterface.getMsg();
  }

  //以下为静态方法，供外界调用
    public static DataResult success(){
           return new DataResult();
  }

    /**
     *
     * @param data
     * @return
     * @param <T> 泛型定义的返回值
     */
    public static <T>DataResult success(T data){
           return new DataResult(data);
  }
    public static <T>DataResult getResult(int code,String msg,T data){
          return new DataResult(code,msg,data);
  }

    public static DataResult getResult(int code,String msg){
          return new DataResult(code,msg);
  }
    public static DataResult getResult(BaseResponseCode responseCode){
          return new DataResult(responseCode);
  }
  public static <T>DataResult getResult(BaseResponseCode responseCode, T data){
          return new DataResult(responseCode,data);
  }
}
