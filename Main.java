import top.apee.ajax.AjaxTool;

public class Main {
    public static void main(String[] args) throws Exception {
        AjaxTool.ajax("https://apee.top", (String result) -> {
            System.out.println(result);
        });
    }
}
