package top.apee.ajax;


/**
 * 回调接口
 */
@FunctionalInterface
public interface IAjaxCallback {
    /**
     * 回调函数
     * 
     * @param result
     */
    public void call(String result);
}