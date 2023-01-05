# AjaxTool

> 用于实现 Java 发送 HTTP 请求

## 项目信息

- 作者：欧阳鹏
- 开发日期：2023 年 1 月 5 日
- 官网：https://apee.top

## 导入类

```java
import top.apee.ajax.AjaxTool;
```

## API 文档与实例

### AjaxTool.ajax()

- 方法列表

    ```java
    // 不带回调
    ajax(String url)
    ajax(String url, String method)
    ajax(String url, String method, String content)
    ajax(String url, String method, String content, String[][] headers)

    // 带回调
    ajax(String url, IAjaxCallback iCallback)
    ajax(String url, String method, IAjaxCallback iCallback)
    ajax(String url, String method, String content, IAjaxCallback iCallback)
    ajax(String url, String method, String content, String[][] headers, IAjaxCallback iCallback)
    ```

- 参数说明
  - `url`：请求地址
  - `method`：请求方式
  - `content`：请求参数
  - `headers`：请求标头
  - `iCallback`：回调函数

- 返回值：响应状态码

- 抛出异常：Exception

### 实例

```java
import top.apee.ajax.AjaxTool;

public class Main {
    public static void main(String[] args) throws Exception {
        AjaxTool.ajax("https://apee.top", (String result) -> {
            System.out.println(result);
        });
    }
}

```

## 导出 Jar 包

```bash
javac -d . "top/apee/ajax/AjaxTool.java"
jar -cvf AjaxTool.jar "top/apee/ajax"
```